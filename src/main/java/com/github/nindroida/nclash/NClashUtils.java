package com.github.nindroida.nclash;

import org.bukkit.plugin.Plugin;

public class NClashUtils {

    public static boolean CMICheck() {
        boolean check = false; // flag to see if we've got the plugin
        Plugin[] serverPlugins = NClash.getInstance().getServer().getPluginManager().getPlugins();
        for (Plugin plugin : serverPlugins) {
            if (plugin.toString().equals("CMI v9.6.10.7")) {
                NClash.getInstance().getLogger().info("CMI is on this server!");
                check = true;
                break;
            }
        }
        return check;
    }
}
