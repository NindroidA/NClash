package com.github.nindroida.nclash.items.potions;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.entities.ClashSkeleton;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class SplashListener implements Listener {

    private final NClash plugin = NClash.getInstance();

    public SplashListener() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private final int skel = PotionManager.getID("skeleton1");

    @EventHandler
    public void onSplash(PotionSplashEvent e) {
        if (e.getPotion().getItem().hasItemMeta()) {
            PotionMeta meta = (PotionMeta) e.getPotion().getItem().getItemMeta();
            if (meta != null && meta.hasCustomModelData()) {
                String lname = meta.getLocalizedName();
                int gID = meta.getCustomModelData();
                if (gID == skel) {
                    int level = PotionManager.getLevel(lname);
                    Location loc = e.getPotion().getLocation();
                    ClashSkeleton.handler(loc, level);
                }
            }
        }
    }
}
