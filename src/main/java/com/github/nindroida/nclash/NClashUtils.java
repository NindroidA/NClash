package com.github.nindroida.nclash;

import org.bukkit.plugin.Plugin;

public class NClashUtils {

    /**
     * CMICheck
     *
     * Method that checks if the server has any CMI-based plugins
     *
     * @return boolean flag that checks if we've got the plugin
     */
    public static boolean CMICheck() {
        boolean check = false; // flag
        Plugin[] serverPlugins = NClash.getInstance().getServer().getPluginManager().getPlugins();
        for (Plugin plugin : serverPlugins) {
            String pluginName = plugin.toString();
            if (pluginName.startsWith("CMI")) {
                NClash.getInstance().getLogger().info("CMI is on this server!");
                check = true;
                break;
            }
        }
        return check;
    }
}
