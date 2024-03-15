package com.github.nindroida.nclash.enchantments.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class TestEnchantTwo extends Enchantment {

    //public TestEnchantTwo(NamespacedKey key) { super(key); }
    @Override
    public String getName() {
        return "testenchant2";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }

    @Override
    public NamespacedKey getKey() {
        return this.getKey();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Enchantment) {
            Enchantment other = (Enchantment) obj;
            return this.getKey().equals(other.getKey());
        }
        return false;
    }

    @Override
    public int hashCode(){ return this.getKey().hashCode(); }
}
