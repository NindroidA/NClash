package com.github.nindroida.nclash.items.potions;

import com.github.nindroida.nclash.items.ItemSetup;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionManager {

    private static final Map<String, ItemStack> itemList = new HashMap<>();

    static {
        itemList.put("skeleton_potion", ItemSetup.createItem(Material.SPLASH_POTION, "Skeleton Potion", "Lore Bruh", 56313704));
    }

    public static ItemStack getPotions(String name) { return itemList.get(name); }

    public static List<String> getPotionNames() { return new ArrayList<>(itemList.keySet()); }
}
