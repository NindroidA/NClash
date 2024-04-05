package com.github.nindroida.nclash.items.potions;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.entities.ClashSkeleton;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class PotionListener implements Listener {

    private final NClash plugin = NClash.getInstance();

    public PotionListener() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * pID
     * gets the potion ID for the first potion level (every level has the same ID)
     * @param name the name of the potion (e.g. lightning, clone, freeze, etc.)
     * @return the potion ID
     */
    private int pID(String name) {
        return PotionManager.getID(name + 1);
    }

    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e) {
        if (e.getItem().isSimilar(new ItemStack(Material.POTION))) {
            if (e.getItem().hasItemMeta()) {
                PotionMeta meta = (PotionMeta) e.getItem().getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    String lname = meta.getLocalizedName();
                    int gID = meta.getCustomModelData();
                    int level = PotionManager.getLevel(lname);
                    Player drinker = e.getPlayer();

                    // healing logic
                    if (gID == pID("healing")) {
                        PotionEffectManager.healing(level, drinker);
                    }

                    // rage logic
                    if (gID == pID("rage")) {
                        PotionEffectManager.rage(level, drinker);
                    }

                    // jump logic
                    if (gID == pID("jump")) {
                        PotionEffectManager.jump(level, drinker);
                    }

                    // clone logic
                    if (gID == pID("clone")) {
                        PotionEffectManager.clone(level, drinker);
                    }

                    //invis logic
                    if (gID == pID("invisibility")) {
                        PotionEffectManager.invisibility(level, drinker);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSplash(PotionSplashEvent e) {
        if (e.getPotion().getItem().hasItemMeta()) {
            PotionMeta meta = (PotionMeta) e.getPotion().getItem().getItemMeta();
            if (meta != null && meta.hasCustomModelData()) {
                String lname = meta.getLocalizedName();
                int gID = meta.getCustomModelData();
                Location loc = e.getPotion().getLocation();
                int level = PotionManager.getLevel(lname);
                Player thrower = (Player) e.getPotion().getShooter(); // player who threw the potion
                Player victim = (Player) e.getHitEntity(); // player who gets hit from the potion

                // lightning logic
                if (gID == pID("lightning")) {
                    PotionEffectManager.lightning(loc, level, victim);
                }

                // freeze logic
                if (gID == pID("freeze")) {
                    PotionEffectManager.freeze(loc, level, victim);
                }

                // skeleton logic
                if (gID == pID("skeleton")) {
                    ClashSkeleton.handler(loc, level);
                }
            }
        }
    }
}
