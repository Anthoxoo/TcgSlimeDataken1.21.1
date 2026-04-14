package com.github.tcganime.services;

import com.github.tcganime.TcgAnime;
import com.github.tcganime.item.BoosterItem;
import com.github.tcganime.item.CardItem;
import com.sun.jna.platform.win32.WinDef;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Random;

public class BoosterServices {

    public static final List<DeferredItem<BoosterItem>> NON_GODPACK_BOOSTERS = List.of(
            TcgAnime.CLASSIC_BOOSTER
    );
    public static final List<DeferredItem<BoosterItem>> GODPACK_BOOSTERS = List.of(
            TcgAnime.CLASSIC_GODPACK_BOOSTER
    );


    public static DeferredItem<BoosterItem> pullRandomBooster() {
        Random rand = new Random();

        try {
            int randomIndex = rand.nextInt(NON_GODPACK_BOOSTERS.size());
            return NON_GODPACK_BOOSTERS.get(randomIndex);
        } catch (IllegalArgumentException e) {
            TcgAnime.LOGGER.error("ERROR, the stack of boosters possible from the is empty");
            return NON_GODPACK_BOOSTERS.getFirst(); // gives the first card of the common stack as preventive
        }
    }

    public static DeferredItem<BoosterItem> pullRandomGodPack() {
        Random rand = new Random();

        try {
            int randomIndex = rand.nextInt(GODPACK_BOOSTERS.size());
            return GODPACK_BOOSTERS.get(randomIndex);
        } catch (IllegalArgumentException e) {
            TcgAnime.LOGGER.error("ERROR, the stack of boosters possible from the is empty");
            return GODPACK_BOOSTERS.getFirst(); // gives the first card of the common stack as preventive
        }    }
}
