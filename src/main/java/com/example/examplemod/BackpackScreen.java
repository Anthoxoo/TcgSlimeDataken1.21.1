package com.example.examplemod;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
// c'est l'inteface graphique du Backpack
// donc L'ui en 2D pour montrer dans le rendu du jeux les objet ou il sont
// j'ai utiliser un copier de la texture de la shulker box pour pas ce faire chier a faire l'interface graphique

public class BackpackScreen extends AbstractContainerScreen<BackpackMenu> {

    // On utilise la texture de la Shulker Box par défaut de Minecraft !
    private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/shulker_box.png");

    public BackpackScreen(BackpackMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        // C'est la taille exacte en pixels de l'image de la Shulker Box
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    // 1. DESSIN DU FOND (L'image de la boîte)
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        // On calcule le milieu de l'écran pour centrer l'inventaire
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        // On dessine l'image à l'écran
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

    // 2. DESSIN GLOBAL (On assemble tout)
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick); // Ça assombrit le reste du jeu derrière
        super.render(guiGraphics, mouseX, mouseY, partialTick); // Ça dessine les cases et les objets
        this.renderTooltip(guiGraphics, mouseX, mouseY); // Ça affiche les infos quand tu survoles un objet
    }
}