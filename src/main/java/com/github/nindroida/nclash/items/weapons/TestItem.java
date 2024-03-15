package com.github.nindroida.nclash.items.weapons;

import com.github.nindroida.nclash.enchantments.CustomEnchantmentUtils;
import com.github.nindroida.nclash.items.ItemSetup;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TestItem {

    /*public static ItemStack getItem() {
        CustomEnchantment test = CustomEnchantmentManager.getEnchantment(TestEnchant.class);
        int level = 2;
        assert test != null;
        return ItemSetup.createItem(
                Material.NETHERITE_AXE,
                "Explosive Axe",
                test.getLore(level),
                test,
                level
        );
    }*/

    public static ItemStack getItem() {
        ItemStack item = ItemSetup.createItem(
                Material.NETHERITE_AXE,
                "Explosive Axe"
        );

        CustomEnchantmentUtils.addCustomEnchantment(item, "Axesplode", 2);
        return item;
    }
}
