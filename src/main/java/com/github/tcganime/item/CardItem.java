package com.github.tcganime.item;

import com.github.tcganime.services.CardStats.RarityTier;
import net.minecraft.world.item.Item;

public class CardItem extends Item {
    private final RarityTier rarity; // None for the moment, will be given when doing the GiveCardRarity method.
    //private final MobEffect effect; // Same
    private final String name;

    // Constructor
    public CardItem(Properties properties, RarityTier rarity, String name) {
        super(properties);
        this.rarity = rarity;
        //this.effect = effect;
        this.name = name;
    }

    //Getters
    public RarityTier getCardTier() {
        return this.rarity;
    }
    /*public MobEffect getCardEffect() {
        return this.effect;
    }*/

}
