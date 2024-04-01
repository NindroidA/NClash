package com.github.nindroida.nclash.utils;

import com.github.nindroida.nclash.NClash;
import net.Zrips.CMILib.Colors.CMIChatColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.plugin.Plugin;

public class MiscUtils {
    /**
     * CMICheck
     *
     * Method that checks if the server has any CMI-based plugins
     * (ik this isn't the most efficient way to do this, but it works rn so ima worry abt it later :3)
     *
     * @return boolean flag that checks if we've got the plugin
     */
    public static boolean CMICheck() {
        boolean check = false; // flag
        Plugin[] serverPlugins = NClash.getInstance().getServer().getPluginManager().getPlugins();
        for (Plugin plugin : serverPlugins) {
            String pluginName = plugin.toString();
            if (pluginName.startsWith("CMI")) {
                NClash.getInstance().getLogger().info(Msg.console_CMIFound.get());
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * ccodeToString
     *
     * takes in a string with the mc '&' color codes and translates them
     *
     * @param text string
     * @return color translated string
     */
    public static String ccodeToString(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * getColor
     *
     * takes in a hex code as a string and turns it into type CMIChatColor
     *
     * @param color hex code
     * @return the cmi color
     */
    public static CMIChatColor getColor(String color) {
        return CMIChatColor.getClosest(color);
    }
}
