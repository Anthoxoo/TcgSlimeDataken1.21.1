package com.github.tcganime.item;

import net.minecraft.world.item.Item;

public class BinderItem extends Item {
    private final String name;
    public BinderItem(Properties properties, String name) {
        super(properties);
        this.name = name;
    }
}
