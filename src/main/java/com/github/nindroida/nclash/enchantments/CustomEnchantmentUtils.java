package com.github.nindroida.nclash.enchantments;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomEnchantmentUtils {

    public static void addCustomEnchantment(ItemStack item, String name, int level) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            String enchantText = ChatColor.AQUA + name + " ";
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (lore != null) {
                lore.add(enchantText);
                meta.setLore(lore);
                item.setItemMeta(meta);
            }
        }

    }
}
