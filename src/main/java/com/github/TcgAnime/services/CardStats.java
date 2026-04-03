package com.github.TcgAnime.services;
import com.github.TcgAnime.item.CardItem;
import net.minecraft.world.effect.MobEffect;

import java.util.HashMap;
import java.util.Random;

public class CardStats {


    public enum RarityTier {
        /* This enum will allow to determine the rarity of the card we will be opening in order to give the right effect*/
        COMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    private final HashMap<RarityTier, MobEffect> testEffect = new HashMap<>();

    /* Param : card object
     * changes the tier of the card to the one that has been rolled. */
    public RarityTier RollRandomRarity(CardItem card) {
        final double COMMON = 0.5;
        final double RARE = 0.75;
        final double EPIC = 0.93;
        // DROP RATE : COMMON 50% RARE 25% EPIC 18% LEGENDARY 7%

        Random rand = new Random();
        double randomNumber = rand.nextDouble();

        if (randomNumber > EPIC) {
            return RarityTier.LEGENDARY;
        } else if (randomNumber >= RARE) {
            return RarityTier.EPIC;
        } else if (randomNumber >= COMMON) {
            return RarityTier.RARE;
        } else {
            return RarityTier.COMMON;
        }
    }
    /* Param : card object, HashMap of the effects that have the tier : the effect
    * changes the effect of the card to the one that is associated with the tier in the effectMap hashmap. */
    public MobEffect EffectPerTier(CardItem card, HashMap<RarityTier, MobEffect> effectMap) {
        return effectMap.get(card.getCardTier());
    }
}
