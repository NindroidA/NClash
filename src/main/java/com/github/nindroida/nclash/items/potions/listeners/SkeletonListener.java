package com.github.nindroida.nclash.items.potions.listeners;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.ItemSetup;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.Objects;

public class SkeletonListener implements Listener {

    private NClash plugin = NClash.getInstance();
    public SkeletonListener() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPotionSplash(PotionSplashEvent e) {
        if (e.getPotion().getItem().hasItemMeta()) {
            ItemMeta meta = e.getPotion().getItem().getItemMeta();
            if (meta != null) {
                if (meta.hasCustomModelData() && meta.getCustomModelData() == 56313704){
                    Location hitLoc = e.getPotion().getLocation();

                    for (int i = 0; i < 3; i++) {
                        Skeleton skeleton = (Skeleton) Objects.requireNonNull(hitLoc.getWorld()).spawnEntity(hitLoc, EntityType.SKELETON);
                        skeleton.setMetadata("PotionThrower", new FixedMetadataValue(plugin, e.getPotion().getShooter().toString()));
                        skeleton.getEquipment().setItemInMainHand(ItemSetup.createItem(Material.IRON_SWORD));
                        skeleton.getEquipment().setHelmet(ItemSetup.createItem(Material.IRON_HELMET));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        if (e.getEntity() instanceof Skeleton && e.getTarget() instanceof Player) {
            Skeleton s = (Skeleton) e.getEntity();
            Player target = (Player) e.getTarget();

            for (MetadataValue val : s.getMetadata("PotionThrower")) {
                if (val.asString().equals(target.getUniqueId().toString())) {
                    e.setCancelled(true);
                    break;
                }
            }
        }
    }
}
