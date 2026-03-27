package com.example.examplemod;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class CardTestItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("simplecards");

    public static final DeferredHolder<Item, Item> CARTE_STANDARD = ITEMS.register("carte_standard",
            () -> new Item(new Item.Properties().stacksTo(64))
    );
}
