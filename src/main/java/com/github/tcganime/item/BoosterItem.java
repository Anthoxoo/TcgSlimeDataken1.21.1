package com.github.tcganime.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import com.github.tcganime.services.CardStats;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class BoosterItem extends Item {
    private final String name;

    public BoosterItem(Properties properties, String name) {
        super(properties);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack boosterStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            ItemStack card1 = CardStats.pullRandomCard().toStack();
            ItemStack card2 = CardStats.pullRandomCard().toStack();
            ItemStack card3 = CardStats.pullRandomCard().toStack();

            ItemHandlerHelper.giveItemToPlayer(player, card1);
            ItemHandlerHelper.giveItemToPlayer(player, card2);
            ItemHandlerHelper.giveItemToPlayer(player, card3);

            boosterStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(boosterStack, level.isClientSide());
    }
}