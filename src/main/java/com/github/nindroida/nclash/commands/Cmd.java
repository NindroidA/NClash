package com.github.nindroida.nclash.commands;

import com.github.nindroida.nclash.items.currency.CurrencyManager;
import com.github.nindroida.nclash.items.potions.PotionManager;
import com.github.nindroida.nclash.utils.Msg;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public enum Cmd {
    currency("getCurrency"),
    potion("getPotion");
    public String cmd;

    Cmd(String cmd) {}

    static
    {
    }
    public static boolean getCurrency(CommandSender sender, String itemName) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (CurrencyManager.currencyExists(itemName)) {
                player.getInventory().addItem(CurrencyManager.getCurrency(itemName));
                player.sendMessage(Msg.info_giveItem.getCoolMsg() + itemName);
                return true;
            } else {
                player.sendMessage(Msg.info_NoItem.getCoolMsg());
                return false;
            }
        } else {
            sender.sendMessage(Msg.info_NotPlayer.getMsg());
            return false;
        }
    }

    public static boolean getPotion(CommandSender sender, String itemName) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (PotionManager.potionExists(itemName)) {
                player.getInventory().addItem(PotionManager.getPotion(itemName));
                player.sendMessage(Msg.info_giveItem.getFullMsg() + itemName);
                return true;
            } else {
                player.sendMessage(Msg.info_NoItem.getFullMsg());
                return false;
            }

        } else {
            sender.sendMessage(Msg.info_NotPlayer.getMsg());
            return false;
        }
    }
}
