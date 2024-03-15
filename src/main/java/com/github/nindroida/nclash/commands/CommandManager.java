package com.github.nindroida.nclash.commands;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.currency.CurrencyManager;
import com.github.nindroida.nclash.items.potions.PotionManager;
import com.github.nindroida.nclash.items.weapons.TestItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager implements CommandExecutor, TabCompleter {

    public CommandManager() {
        NClash plugin = NClash.getInstance();
        Objects.requireNonNull(plugin.getCommand("clash")).setExecutor(this);
        Objects.requireNonNull(plugin.getCommand("clash")).setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("clash") && args.length > 0) {
            if (args[0].equalsIgnoreCase("getCurrency")) {
                if (args.length > 1 && sender instanceof Player) {
                    Player player = (Player) sender;
                    String itemName = args[1];
                    ItemStack item = CurrencyManager.getCurrency(itemName);
                    if (item != null) {
                        player.getInventory().addItem(item);
                        player.sendMessage("You have been given " + itemName + ".");
                    } else {
                        player.sendMessage("Item not found.");
                    }
                    return true;
                } else {
                    sender.sendMessage("Usage: /clash getCurrency <item name>");
                }
            } else if (args[0].equalsIgnoreCase("getPotion")) {
                if (args.length > 1 && sender instanceof Player) {
                    Player player = (Player) sender;
                    String itemName = args[1];
                    ItemStack item = PotionManager.getPotions(itemName);
                    if (item != null) {
                        player.getInventory().addItem(item);
                        player.sendMessage("You have been given " + itemName + ".");
                    } else {
                        player.sendMessage("Item not found.");
                    }
                    return true;
                } else {
                    sender.sendMessage("Usage: /clash getCurrency <item name>");
                }
            } else if (args[0].equalsIgnoreCase("getItem")) {
                Player player = (Player) sender;
                ItemStack item = TestItem.getItem();
                player.getInventory().addItem(item);
                player.sendMessage("You have been given the test item brother.");
                return true;
            }

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (alias.equalsIgnoreCase("clash") && args.length == 1) {
            return List.of("getCurrency", "getItem", "getPotion");
        } else if (alias.equalsIgnoreCase("clash") && args.length == 2 && args[0].equalsIgnoreCase("getCurrency")) {
            return CurrencyManager.getCurrencyNames();
        } else if (alias.equalsIgnoreCase("clash") && args.length == 2 && args[0].equalsIgnoreCase("getPotion")) {
            return PotionManager.getPotionNames();
        }
        return new ArrayList<>();
    }
}
