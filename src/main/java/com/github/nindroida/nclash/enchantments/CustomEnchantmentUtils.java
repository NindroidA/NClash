package com.github.nindroida.nclash.enchantments;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomEnchantmentUtils {

    // converts level number to roman numerals
    public static String romanNumerals(int level) {
        switch (level) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            default: return Integer.toString(level);
        }
    }

    public static void addCustomEnchantment(ItemStack item, String name, int level) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            String enchantText = ChatColor.AQUA + name + " " + romanNumerals(level);
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (lore != null) {
                lore.add(enchantText);
                meta.setLore(lore);
                item.setItemMeta(meta);
            }
        }

    }
}
