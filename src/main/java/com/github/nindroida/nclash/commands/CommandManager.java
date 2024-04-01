package com.github.nindroida.nclash.commands;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.ItemSetup;
import com.github.nindroida.nclash.items.currency.CurrencyManager;
import com.github.nindroida.nclash.items.potions.PotionManager;
import com.github.nindroida.nclash.items.weapons.TestItem;
import com.github.nindroida.nclash.utils.Msg;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager implements CommandExecutor {

    private final ArrayList<String> tabList = new ArrayList<>();

    public CommandManager() {
        NClash plugin = NClash.getInstance();
        Objects.requireNonNull(plugin.getCommand("clash")).setExecutor(this);
        new TabCompleteManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("clash") && args.length > 0) {
            if (args[0].equalsIgnoreCase("getCurrency")) {
                if (args.length > 1) {
                    String itemName = args[1];
                    Cmd.getCurrency(sender, itemName);
                    return true;
                }
                return true;
            } else if (args[0].equalsIgnoreCase("getPotion")) {
                if (args.length > 1) {
                    String itemName = args[1];
                    Cmd.getPotion(sender, itemName);
                    return true;
                }
                return true;
            }
        }
        return true;
    }
}
