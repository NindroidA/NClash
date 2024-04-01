package com.github.nindroida.nclash.items.currency;

import com.github.nindroida.nclash.items.ItemSetup;
import com.github.nindroida.nclash.utils.FileManager;
import com.github.nindroida.nclash.utils.MiscUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class CurrencyManager {

    private static final Map<String, ArrayList<Object>> itemList = new HashMap<>();
    private static final FileManager cFile = new FileManager("currency.yml");
    private static final FileConfiguration config = cFile.getConfig();
    private static final String lore = "&7🗡 &6Clash Currency";

    static {
        for (String type: config.getKeys(false)) {
            String nPath = type + ".name"; // path to name
            String cPath = type + ".color"; // path to color
            String mPath = type + ".material"; // path to material
            String iPath = type + ".id"; // path to id

            ArrayList<Object> info = new ArrayList<>();
            info.add(config.getString(nPath)); // 0 - $Name
            info.add(config.getString(cPath)); // 1 - $Color
            info.add(Material.getMaterial(Objects.requireNonNull(config.getString(mPath)))); // 2 - $Material
            info.add(config.getInt(iPath)); // 3 - $ID

            itemList.put(type, info);
        }
    }

    public static boolean currencyExists(String name) {
        return itemList.containsKey(name);
    }

    public static ItemStack getCurrency(String name) {
        ArrayList<Object> l = itemList.get(name);
        return new ItemStack(ItemSetup.createItem(
                name,
                (String) l.get(0),
                (String) l.get(1),
                MiscUtils.ccodeToString(lore),
                (Material) l.get(2),
                (int) l.get(3)
        ));
    }

    public static List<String> getCurrencyNames() {
        return new ArrayList<>(itemList.keySet());
    }
}
