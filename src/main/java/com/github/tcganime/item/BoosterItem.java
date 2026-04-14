package com.github.tcganime.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import com.github.tcganime.services.CardServices;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class BoosterItem extends Item {

    private final boolean isGodPack;
    public BoosterItem(Properties properties, boolean isGodPack) {
        super(properties);
        this.isGodPack = isGodPack;
    }
    public boolean GetIsGodPack() {
        return isGodPack;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack boosterStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {

            ItemStack card1;
            ItemStack card2;
            ItemStack card3;

            if (this.isGodPack) {
                card1 = CardServices.pullEpicOrLegendaryCard().toStack();
                card2 = CardServices.pullEpicOrLegendaryCard().toStack();
                card3 = CardServices.pullEpicOrLegendaryCard().toStack();
            }
            else {
                card1 = CardServices.pullRandomCard().toStack();
                card2 = CardServices.pullRandomCard().toStack();
                card3 = CardServices.pullRandomCard().toStack();
            }

            ItemHandlerHelper.giveItemToPlayer(player, card1);
            ItemHandlerHelper.giveItemToPlayer(player, card2);
            ItemHandlerHelper.giveItemToPlayer(player, card3);

            boosterStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(boosterStack, level.isClientSide());
    }
}