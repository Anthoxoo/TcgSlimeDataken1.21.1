package com.github.TcgSlimeDataken.services;
import java.util.Random;

public class CardStats {

    public enum RarityTier {
        /* This enum will allow to determine the rarity of the card we will be opening in order to give the right effect*/
        COMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    public RarityTier RollRandomRarity() {
        final double COMMON = 0.5;
        final double RARE = 0.75;
        final double EPIC = 0.95;
        // DROP RATE : COMMON 50% RARE 25% EPIC 20% LEGENDARY 5%

        Random rand = new Random();
        double randomNumber = rand.nextDouble();

        if (randomNumber > EPIC) { // legendary
            return RarityTier.LEGENDARY;
        } else if (randomNumber >= RARE) {
            return RarityTier.EPIC;
        } else if (randomNumber >= COMMON) {
            return RarityTier.RARE;
        } else {
            return RarityTier.COMMON;
        }
    }

    //public MobEffect RollEffect() {
    //}
}
