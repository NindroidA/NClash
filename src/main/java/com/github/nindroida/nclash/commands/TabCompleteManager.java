package com.github.nindroida.nclash.commands;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.currency.CurrencyManager;
import com.github.nindroida.nclash.items.potions.PotionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TabCompleteManager implements TabCompleter {

    public TabCompleteManager() {
        NClash plugin = NClash.getInstance();
        Objects.requireNonNull(plugin.getCommand("clash")).setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabs = new ArrayList<>();

        switch (args.length) {
            case 1:
                if (sender instanceof Player player && player.hasPermission("nclash.getCurrency")) { tabs.add("getPotion"); }
                if (sender instanceof Player player && player.hasPermission("nclash.getPotion")) { tabs.add("getPotion"); }


            case 2:
                if (args[0].equalsIgnoreCase("getCurrency")) { return CurrencyManager.getCurrencyNames(); }
                if (args[0].equalsIgnoreCase("getPotion")) { return PotionManager.getPotionNames(); }
        }

        return tabs;
    }
}
