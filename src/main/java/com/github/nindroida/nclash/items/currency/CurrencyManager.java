package com.github.nindroida.nclash.items.currency;

import com.github.nindroida.nclash.items.ItemSetup;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyManager {

    private static final Map<String, ItemStack> currencyItems = new HashMap<>();
    private static final String lore = "Clash Currency";

    static {
        currencyItems.put("gold_coin", ItemSetup.createItem(Material.GOLD_NUGGET, "Gold Coin", lore));
        currencyItems.put("gem", ItemSetup.createItem(Material.EMERALD, "Gem", lore));
    }

    public static ItemStack getCurrency(String name) {
        return currencyItems.get(name);
    }

    public static List<String> getCurrencyNames() {
        return new ArrayList<>(currencyItems.keySet());
    }
}
