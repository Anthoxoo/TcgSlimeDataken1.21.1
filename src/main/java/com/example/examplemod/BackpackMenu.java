package com.example.examplemod;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

// c'est la Creation du cerveau de l'inventaire donc l'inventaire invisible
// ou il y a le nombre de slot d'inventaire
// les parametre pour deplacer des objets de case en case
// mais ne sauvegarde rien concretement c'est le fonctionnement de l'inventaire
// il fait comme un inventaire virtuel qu'il envoie a backpackitem lorsque je le ferme pour sauvegarder les donner


public class BackpackMenu extends AbstractContainerMenu {

    private final Container container;

    // 1. CONSTRUCTEUR CLIENT (Utilisé par l'ordinateur du joueur quand il reçoit l'ordre d'ouvrir le sac)
    public BackpackMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(27)); // 27 = 3 lignes de 9 cases
    }

    // 2. CONSTRUCTEUR SERVEUR (Utilisé par le serveur, c'est lui qui possède les vrais objets)
    public BackpackMenu(int containerId, Inventory playerInventory, Container backpackContainer) {
        // On relie ce menu à son identifiant dans le registre (qu'on va créer juste après)
        super(ExampleMod.BACKPACK_MENU.get(), containerId);
        this.container = backpackContainer;

        // On dit au conteneur qu'un joueur l'a ouvert
        backpackContainer.startOpen(playerInventory.player);

        // --- DESSIN DE LA GRILLE INVISIBLE ---
        // Les nombres 8, 18, 84, etc. sont les pixels X et Y où se trouveront les cases sur l'image de fond !

        // A. Les 27 cases du Sac à Dos (3 lignes, 9 colonnes)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(backpackContainer, col + row * 9, 8 + col * 18, 18 + row * 18));
            }
        }

        // B. Les 27 cases de l'inventaire principal du Joueur
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // C. Les 9 cases de la barre d'action (Hotbar) du Joueur
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    // Le serveur demande en boucle : "Le joueur a-t-il toujours le droit de voir ce menu ?"
    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    // --- LE CAUCHEMAR DU SHIFT-CLIC ---
    // Cette fonction gère le déplacement instantané des objets d'un inventaire à l'autre
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            // Si on Shift-clic depuis le Sac vers le Joueur
            if (index < 27) {
                if (!this.moveItemStackTo(itemstack1, 27, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // Si on Shift-clic depuis le Joueur vers le Sac
            else if (!this.moveItemStackTo(itemstack1, 0, 27, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

    // Quand le joueur ferme le menu avec Echap
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}