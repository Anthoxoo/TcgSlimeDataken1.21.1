package com.github.tcganime.item;

import com.github.tcganime.services.CardServices.RarityTier;
import com.github.tcganime.services.Families;
import com.github.tcganime.services.SubFamilies;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

import java.util.List;

public class CardItem extends Item {
    private static int globalCounter = 1;

    private final RarityTier rarity;
    private final Holder<MobEffect> effect; // Same
    private final int effectAmplifier;
    private final int id;
    private final List<Families> families;
    private final List<SubFamilies> subFamilies;


    // Constructor
    public CardItem(Properties properties, RarityTier rarity, Holder<MobEffect> effect, int effectAmplifier, List<Families> families, SubFamilies... subFamilies) {
        super(properties);
        this.rarity = rarity;
        this.effect = effect;
        this.effectAmplifier = effectAmplifier;
        this.id = globalCounter++;
        this.families = families;
        this.subFamilies = List.of(subFamilies);

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
    public List<Families> getFamilies() {
        return this.families;
    }
    public List<SubFamilies> getSubFamilies() {
        return this.subFamilies;
    }
}
