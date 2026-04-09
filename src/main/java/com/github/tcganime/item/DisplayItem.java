package com.github.tcganime.item;

import com.github.tcganime.services.BoosterServices;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemHandlerHelper;

import java.util.Random;

public class DisplayItem extends Item {
    private final String name;

    public DisplayItem(Properties properties, String name) {
        super(properties);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack displayStack = player.getItemInHand(hand);


        if (!level.isClientSide()) {

            int numberGodPack;

            Random rand = new Random();
            int randomIndex = rand.nextInt(10);

            numberGodPack = switch (randomIndex) {
                case 0, 1, 2, 3, 4, 5 -> 1;
                case 6, 7, 8 -> 2;
                default -> 3;
            };
            int numberBoosterPerDisplay = 6 - numberGodPack;

            for (int i = 0; i < numberBoosterPerDisplay; i++) {
                ItemStack pulledBooster = BoosterServices.pullRandomBooster().toStack();
                ItemHandlerHelper.giveItemToPlayer(player, pulledBooster);
            }

            for (int i = 0; i < numberGodPack; i++) {
                ItemStack pulledBooster = BoosterServices.pullRandomGodPack().toStack();
                ItemHandlerHelper.giveItemToPlayer(player, pulledBooster);
            }

            displayStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(displayStack, level.isClientSide());
    }
}
