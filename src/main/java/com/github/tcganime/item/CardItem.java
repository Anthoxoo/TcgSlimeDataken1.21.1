package com.github.tcganime.item;

import com.github.tcganime.services.CardStats.RarityTier;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

public class CardItem extends Item {
    private final RarityTier rarity; // None for the moment, will be given when doing the GiveCardRarity method.
    private final Holder<MobEffect> effect; // Same
    private final int effectAmplifier;
    private final String name;

    // Constructor
    public CardItem(Properties properties, RarityTier rarity, Holder<MobEffect> effect, int effectAmplifier, String name) {
        super(properties);
        this.rarity = rarity;
        this.effect = effect;
        this.effectAmplifier = effectAmplifier;
        this.name = name;
    }

    //Getters
    public RarityTier getCardTier() {
        return this.rarity;
    }
    public Holder<MobEffect> getCardEffect() {
        return this.effect;
    }
    public int getEffectAmplifier() {
        return this.effectAmplifier;
    }

}
