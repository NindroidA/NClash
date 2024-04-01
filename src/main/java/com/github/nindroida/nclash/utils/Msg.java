package com.github.nindroida.nclash.utils;

import net.Zrips.CMILib.Colors.CMIChatColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Msg
 *
 * collection of messages used by the NClash plugin
 *
 * @author NindroidA
 */
public enum Msg {

    prefix("&f[&5&lNClash&f] "),
    console_CMIFound("CMI found! Proceeding ..."),
    console_CMINotFound("Could not find CMI! Disabling plugin."),
    info_NoPermission("&cYou don't have permission!"),
    info_NoCommand("&cCommand not found!"),
    info_NoArgs("&cInvalid arguments!"),
    info_giveItem("&6Item received: "),
    info_NoItem("&cItem not found!"),
    info_NotPlayer("&cOnly players can run that command!"),
    BRUH("hahafunnyendingtodeletelater");

    private final String text;
    Msg(String text) {
        this.text = text;
    }

    public String get() {
        return this.text;
    }

    public String getMsg() {
        return MiscUtils.ccodeToString(this.text);
    }

    public String getFullMsg() {
        return MiscUtils.ccodeToString(prefix.text + this.text);
    }

    @Test
    public String getCoolMsg() {
        String bk1 = ChatColor.WHITE + "[";
        String bk2 = ChatColor.WHITE + "] ";
        String tx = MiscUtils.ccodeToString("&lNClash");
        String name = MiscUtils.getColor("#F2AD35") + tx;

        return bk1 + name + bk2 + MiscUtils.ccodeToString(this.text);
    }
}
