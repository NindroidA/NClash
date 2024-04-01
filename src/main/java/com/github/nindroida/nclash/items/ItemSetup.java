package com.github.nindroida.nclash.items;

import com.github.nindroida.nclash.utils.MiscUtils;
import com.github.nindroida.nclash.utils.Test;
import net.Zrips.CMILib.Colors.CMIChatColor;
import net.Zrips.CMILib.Colors.CMIColors;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.Collections;

/**
 * ItemSetup
 *
 * collection of methods for custom item creation
 *
 * @author NindroidA
 */
public class ItemSetup {

    /**
     * createItem
     *
     * overloaded methods for creating custom items
     *
     * @param material the item we want
     * @return item
     */
    public static ItemStack createItem(Material material) {
        return new ItemStack(material);
    }

    /**
     * createItem
     *
     * @see ItemSetup#createItem(Material material)
     *
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
     *
     * @see ItemSetup#createItem(Material material)
     *
     * @param lname localized name as a String
     * @param name display name as a String
     * @param color item/name color as type Color
     * @param lore lore as a string
     * @param material the kind of item
     * @param id custom item id as an int
     * @return custom item
     */
    public static ItemStack createItem(String lname, String name, String color, String lore, Material material, int id) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            CMIChatColor c = MiscUtils.getColor(color);
            meta.setLocalizedName(lname);
            meta.setDisplayName(c + name);
            meta.setLore(Collections.singletonList(lore));
            meta.setCustomModelData(id);
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * createPotion
     *
     * Method for creating custom potions
     *
     * @param lname localized name as a String
     * @param name display name as a String
     * @param color potion color as type Color
     * @param lore lore as a String
     * @param splash boolean for whether you want the potion to be a splash potion or not (true = get splash potion)
     * @param level potion level as an int
     * @param id custom potion id as an int
     * @return custom potion
     */
    public static ItemStack createPotion(String lname, String name, String color, String lore, Boolean splash, int level, int id) {
        ItemStack potion;
        if (splash) {
            potion = new ItemStack(Material.SPLASH_POTION);
        } else {
            potion = new ItemStack(Material.POTION);
        }
        PotionMeta meta = (PotionMeta) potion.getItemMeta();

        if (meta != null) {
            CMIChatColor c = MiscUtils.getColor(color);
            meta.setLocalizedName(lname);
            meta.setDisplayName(c + name);
            meta.setColor(c.getRGBColor());
            meta.setLore(Collections.singletonList(lore));
            meta.setCustomModelData(id);
            potion.setItemMeta(meta);
        }

        return potion;
    }
}
