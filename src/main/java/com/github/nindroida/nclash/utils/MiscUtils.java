package com.github.nindroida.nclash.utils;

import com.github.nindroida.nclash.NClash;
import net.Zrips.CMILib.Colors.CMIChatColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

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

    /**
     * getBlocks
     *
     * gets the blocks in the desired radius (idk how to word this one)
     *
     * @param start the starting block
     * @param radius the radius of blocks you want to get
     * @return list of blocks in the inputted radius
     */
    public static ArrayList<Block> getBlocks(Block start, int radius){
        ArrayList<Block> blocks = new ArrayList<>();
        for(double x = start.getLocation().getX() - radius; x <= start.getLocation().getX() + radius; x++){
            for(double y = start.getLocation().getY() - radius; y <= start.getLocation().getY() + radius; y++){
                for(double z = start.getLocation().getZ() - radius; z <= start.getLocation().getZ() + radius; z++){
                    Location loc = new Location(start.getWorld(), x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }
}
