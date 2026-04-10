package com.github.tcganime.item;

import com.github.tcganime.services.CardServices.RarityTier;
import com.github.tcganime.services.Universe;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

public class CardItem extends Item {
    private final RarityTier rarity;
    private final Holder<MobEffect> effect; // Same
    private final int effectAmplifier;
    private final int id;
    private final Universe universe;

    // Constructor
    public CardItem(Properties properties, RarityTier rarity, Holder<MobEffect> effect, int effectAmplifier, int id, Universe universe) {
        super(properties);
        this.rarity = rarity;
        this.effect = effect;
        this.effectAmplifier = effectAmplifier;
        this.id = id;
        this.universe = universe;
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
    public int getId() {
        return this.id;
    }
    public Universe getUniverse() {
        return universe;
    }
}
