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
    public BoosterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack boosterStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            ItemStack card1 = CardServices.pullRandomCard().toStack();
            ItemStack card2 = CardServices.pullRandomCard().toStack();
            ItemStack card3 = CardServices.pullRandomCard().toStack();

            ItemHandlerHelper.giveItemToPlayer(player, card1);
            ItemHandlerHelper.giveItemToPlayer(player, card2);
            ItemHandlerHelper.giveItemToPlayer(player, card3);

            boosterStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(boosterStack, level.isClientSide());
    }
}