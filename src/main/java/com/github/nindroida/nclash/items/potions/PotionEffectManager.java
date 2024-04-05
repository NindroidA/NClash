package com.github.nindroida.nclash.items.potions;

import com.github.nindroida.nclash.utils.MiscUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Objects;

public class PotionEffectManager {

    public static void lightning(Location loc, int level, Player victim) {
        int dA;
        int dD;
        switch (level) {
            case 1:
                dA = 2;
                dD = 1;
                break;

            case 2:
                dA = 4;
                dD = 1;
                break;

            case 3:
                dA = 6;
                dD = 1;
                break;

            default: return;
        }

        Objects.requireNonNull(loc.getWorld()).strikeLightningEffect(loc);
        if (victim != null) {
            victim.addPotionEffect(new PotionEffect(PotionEffectType.HARM, dD, dA));
        }
    }

    public static void healing(int level, Player drinker) {
        int aA;
        int aD;
        int rA;
        int rD;
        switch (level) {
            case 1:
                aA = 1;
                aD = 4;
                rA = 2;
                rD = 4;
                break;
            case 2:
                aA = 2;
                aD = 6;
                rA = 3;
                rD = 6;
                break;
            case 3:
                aA = 2;
                aD = 7;
                rA = 4;
                rD = 7;
                break;
            case 4:
                aA = 3;
                aD = 8;
                rA = 4;
                rD = 8;
                break;
            default: return;
        }

        drinker.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, aD, aA));
        drinker.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, rD, rA));
    }

    public static void rage(int level, Player drinker) {
        int stA;
        int stD;
        int spA;
        int spD;

        switch (level) {
            case 1:
                stA = 2;
                stD = 4;
                spA = 1;
                spD = 4;
                break;
            case 2:
                stA = 3;
                stD = 6;
                spA = 2;
                spD = 6;
                break;
            case 3:
                stA = 4;
                stD = 8;
                spA = 2;
                spD = 8;
                break;
            default: return;
        }

        drinker.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, stD, stA));
        drinker.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, spD, spA));
    }

    public static void jump(int level, Player drinker) {
        int jA;
        int jD;
        switch (level) {
            case 1:
                jA = 1;
                jD = 5;
                break;
            case 2:
                jA = 2;
                jD = 7;
                break;
            default: return;
        }

        drinker.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, jD, jA));
    }

    public static void freeze(Location loc, int level, Player victim) {
        int jA;
        int jD;
        int sA;
        int sD;
        switch (level) {
            case 1:
                jA = 250;
                jD = 3;
                sA = 255;
                sD = 3;
                break;
            case 2:
                jA = 250;
                jD = 4;
                sA = 255;
                sD = 4;
                break;
            case 3:
                jA = 250;
                jD = 5;
                sA = 255;
                sD = 5;
                break;
            default: return;
        }

        if (victim != null) {
            victim.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, jD, jA));
            victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, sD, sA));
        }

        ArrayList<Block> toChange = MiscUtils.getBlocks(loc.getBlock(), 2);
        for (Block block : toChange) {
            block.setType(Material.PACKED_ICE);
        }
    }

    public static void clone(int level, Player drinker) {
        int hA;
        int hD;
        switch (level) {
            case 1:
                hA = 5;
                hD = 6;
                break;
            case 2:
                hA = 5;
                hD = 10;
                break;
            default: return;
        }

        drinker.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, hD, hA));
    }

    public static void invisibility(int level, Player drinker) {
        int iA;
        int iD;
        switch (level) {
            case 1:
                iA = 1;
                iD = 5;
                break;
            case 2:
                iA = 1;
                iD = 8;
                break;
            default: return;
        }

        drinker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, iD, iA, true, false));
    }
}
