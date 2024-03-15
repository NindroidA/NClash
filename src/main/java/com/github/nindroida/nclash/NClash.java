package com.github.nindroida.nclash;

import com.github.nindroida.nclash.commands.CommandManager;
import com.github.nindroida.nclash.enchantments.CustomEnchantmentListener;
import com.github.nindroida.nclash.items.potions.listeners.SkeletonListener;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.Zrips.CMI.CMI;

import java.util.Arrays;

public final class NClash extends JavaPlugin {

    private static NClash instance;

    public static NClash getInstance() { return instance; }
    @Override
    public void onEnable() {
        instance = this;

        // see if ya got CMI
        if (!NClashUtils.CMICheck()) {
            getLogger().severe("Could not find CMI! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info("Proceeding . . .");

        // register commands
        new CommandManager();

        // register listeners
        new CustomEnchantmentListener();
        new SkeletonListener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
