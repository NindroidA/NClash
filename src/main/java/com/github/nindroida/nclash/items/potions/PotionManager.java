package com.github.nindroida.nclash.items.potions;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.ItemSetup;
import com.github.nindroida.nclash.utils.FileManager;
import com.github.nindroida.nclash.utils.MiscUtils;
import net.Zrips.CMILib.Colors.CMIChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;

public class PotionManager {
    private static final Map<String, ArrayList<Object>> itemList = new HashMap<>();
    private static final FileManager pFile = new FileManager("potions.yml");
    private static final FileConfiguration pConfig = pFile.getConfig();

    static {
        for (String type : pConfig.getKeys(false)) {
            String nPath = type + ".name"; // path to name
            String cPath = type + ".color"; // path to color
            String lPath = type + ".lore"; // path to lore
            String bPath = type + ".splash"; // path to splash boolean
            String levPath = type + ".maxLevel"; // path to max level
            String iPath = type + ".id"; // path to id

            int maxLevel = pConfig.getInt(levPath);
            for (int i = 1; i <= maxLevel; i++) {
                ArrayList<Object> info = new ArrayList<>();
                info.add(pConfig.getString(nPath)); // 0 - potionName
                info.add(pConfig.getString(cPath)); // 1 - potionColor
                info.add(pConfig.getString(lPath)); // 2 - potionLore
                info.add(pConfig.getBoolean(bPath)); // 3 - potionSplash
                info.add(i); // 4 - potionLevel
                info.add(iPath); // 5 - potionLevel

                itemList.put(type + i, info);
            }
        }
    }

    public static boolean potionExists(String name) {
        return itemList.containsKey(name);
    }

    public static ItemStack getPotion(String name) {
        ArrayList<Object> l = itemList.get(name);
        return new ItemStack(ItemSetup.createPotion(
                name,
                (String) l.get(0),
                (String) l.get(1),
                (String) l.get(2),
                (Boolean) l.get(3),
                (int) l.get(4),
                (int) l.get(5)
        ));
    }

    public static List<String> getPotionNames() {
        return new ArrayList<>(itemList.keySet());
    }

    public static int getLevel(String name) {
        ArrayList<Object> l = itemList.get(name);
        return (int) l.get(4);
    }

    public static int getID(String name) {
        ArrayList<Object> l = itemList.get(name);
        return (int) l.get(5);
    }
}
