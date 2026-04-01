package com.example.examplemod;


import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

// c'est la memoire des donner d'invenataire du joueur
// lorsque je ferme mon inventaire il et appeler pour sauvegarder les donner du joueur
//

public class BackpackItem extends Item {

    public BackpackItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {

            // 1. LIRE LE DISQUE DUR : On récupère la sauvegarde contenue dans l'item
            ItemContainerContents contents = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);

            // On prépare une liste vide de 27 cases et on y copie les objets sauvegardés
            NonNullList<ItemStack> savedItems = NonNullList.withSize(27, ItemStack.EMPTY);
            contents.copyInto(savedItems);

            // 2. CRÉER L'INVENTAIRE INTELLIGENT
            SimpleContainer backpackContainer = new SimpleContainer(27) {
                // Cette fonction se déclenche automatiquement à chaque clic dans l'inventaire
                @Override
                public void setChanged() {
                    super.setChanged();

                    // 3. ÉCRIRE SUR LE DISQUE DUR : On rassemble tous les objets actuels...
                    List<ItemStack> currentItems = new ArrayList<>();
                    for (int i = 0; i < this.getContainerSize(); i++) {
                        currentItems.add(this.getItem(i));
                    }

                    // ... et on remplace l'ancienne sauvegarde de l'item par la nouvelle !
                    itemStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(currentItems));
                }
            };

            // 4. CHARGER LES OBJETS VISUELLEMENT : On met les objets lus à l'étape 1 dans les cases de l'étape 2
            for (int i = 0; i < 27; i++) {
                backpackContainer.setItem(i, savedItems.get(i));
            }

            // 5. OUVRIR LE MENU (Avec notre nouveau container intelligent)
            MenuProvider provider = new SimpleMenuProvider(
                    (containerId, playerInventory, playerEntity) -> new BackpackMenu(containerId, playerInventory, backpackContainer),
                    Component.literal("Mon Sac à Dos")
            );

            player.openMenu(provider);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}