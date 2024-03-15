package com.github.nindroida.nclash.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

/**
 * Methods for custom item creation/setup
 */
public class ItemSetup {

    /**
     * createItem
     * Overloaded methods for the
     * @param material the item we want
     * @return item
     */
    public static ItemStack createItem(Material material) {
        ItemStack item = new ItemStack(material);
        return item;
    }

    /**
     * createItem
     * @see ItemSetup#createItem(Material material)
     * @param material the item we want
     * @param name custom name
     * @return item
     */
    public static ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }

        return item;
    }

    /**
     * createItem
     * @see ItemSetup#createItem(Material material)
     * @param material the item we want
     * @param name custom name
     * @param lore custom lore
     * @return item
     */
    public static ItemStack createItem(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(Collections.singletonList(lore));
            item.setItemMeta(meta);
        }

        return item;
    }

    /**
     * createItem
     * @see ItemSetup#createItem(Material material)
     * @param material the item we want
     * @param name custom name
     * @param lore custom lore
     * @param data int for adding custom model data
     * @return item
     */
    public static ItemStack createItem(Material material, String name, String lore, int data) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(Collections.singletonList(lore));
            meta.setCustomModelData(data);
            item.setItemMeta(meta);
        }

        return item;
    }
}
