package com.github.nindroida.nclash;

import com.github.nindroida.nclash.commands.CommandManager;
import com.github.nindroida.nclash.enchantments.CustomEnchantmentListener;
import com.github.nindroida.nclash.items.potions.PotionListener;
import com.github.nindroida.nclash.utils.MiscUtils;
import com.github.nindroida.nclash.utils.Msg;
import org.bukkit.plugin.java.JavaPlugin;


public final class NClash extends JavaPlugin {

    private static NClash instance;
    public static NClash getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;

        // see if ya got CMI
        if (!MiscUtils.CMICheck()) {
            getLogger().severe(Msg.console_CMINotFound.get());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // register commands
        new CommandManager();

        // register listeners
        new CustomEnchantmentListener();
        new PotionListener();


    }

    @Override
    public void onDisable() {
    }
}
