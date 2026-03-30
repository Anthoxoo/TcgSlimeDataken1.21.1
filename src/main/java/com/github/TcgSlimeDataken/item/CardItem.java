package com.github.TcgSlimeDataken.item;

import com.github.TcgSlimeDataken.services.CardStats.RarityTier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

public class CardItem extends Item {
    private final RarityTier rarity; // None for the moment, will be given when doing the GiveCardRarity method.
    private final MobEffect effect; // Same


    // Constructor
    public CardItem(Properties properties, RarityTier rarity, MobEffect effect) {
        super(properties);
        this.rarity = rarity;
        this.effect = effect;
    }

    //Getters
    public RarityTier getCardTier() {
        return this.rarity;
    }
    public MobEffect getCardEffect() {
        return this.effect;
    }

}
