package com.github.tcganime.services;
import com.github.tcganime.TcgAnime;
import com.github.tcganime.item.CardItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Random;

public class CardServices {
    public enum RarityTier {
        /* This enum will allow to determine the rarity of the card we will be opening in order to give the right effect*/
        COMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    // we put every card we registered in this list so we can later pull a random one.
    public static final List<DeferredItem<CardItem>> COMMON_CARDS = List.of(
            TcgAnime.LIMULE_SLIME,
            TcgAnime.RENGA,
            TcgAnime.GOBUTA,
            TcgAnime.GABIRU,
            TcgAnime.KUROBE,
            TcgAnime.RIGURUD,
            TcgAnime.GERUDO,
            TcgAnime.CLAYMAN,
            TcgAnime.FRANKY,
            TcgAnime.BROOK,
            TcgAnime.JIMBE
    );

    public static final List<DeferredItem<CardItem>> RARE_CARDS = List.of(
            TcgAnime.RIMURU,
            TcgAnime.SHION,
            TcgAnime.SHUNA,
            TcgAnime.SOUEI,
            TcgAnime.HAKUROU,
            TcgAnime.KARION,
            TcgAnime.FREY,
            TcgAnime.DINO,
            TcgAnime.LUFFY,
            TcgAnime.NAMI,
            TcgAnime.ROBIN,
            TcgAnime.CHOPPER,
            TcgAnime.BAGGY
    );

    public static final List<DeferredItem<CardItem>> EPIC_CARDS = List.of(
            TcgAnime.BENIMARU,
            TcgAnime.DIABLO,
            TcgAnime.SHIZU,
            TcgAnime.LAMIRIS,
            TcgAnime.LEON,
            TcgAnime.ZORO,
            TcgAnime.SANJI,
            TcgAnime.SHANKS,
            TcgAnime.BARBE_BLANCHE,
            TcgAnime.KAIDO,
            TcgAnime.BIG_MOM
    );

    public static final List<DeferredItem<CardItem>> LEGENDARY_CARDS = List.of(
            TcgAnime.RIMURU_ROI,
            TcgAnime.VELDRA,
            TcgAnime.MILIM,
            TcgAnime.ROUGE,
            TcgAnime.VALENTINA,
            TcgAnime.LUFFY_GEAR_5,
            TcgAnime.BARBE_NOIRE
    );

    /* Param : card object
     * changes the tier of the card to the one that has been rolled. */
    public static RarityTier rollRandomRarity() {
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

    public static DeferredItem<CardItem> pullRandomCard() {
        RarityTier tier = rollRandomRarity();

        List<DeferredItem<CardItem>> poolToUse;
        switch (tier) {
            case LEGENDARY -> poolToUse = LEGENDARY_CARDS;
            case EPIC -> poolToUse = EPIC_CARDS;
            case RARE -> poolToUse = RARE_CARDS;
            default -> poolToUse = COMMON_CARDS;
        }


        Random rand = new Random();
        try { // in case the list of the tier given is empty
            // taking a random index from the card in the poolToUse list.
            int randomIndex = rand.nextInt(poolToUse.size());
            return poolToUse.get(randomIndex);
        }
        catch (IllegalArgumentException e) {
            TcgAnime.LOGGER.error("ERROR, the stack of card possible from the {} is empty", tier);
            return COMMON_CARDS.getFirst(); // gives the first card of the common stack as preventive
        }
    }
}
