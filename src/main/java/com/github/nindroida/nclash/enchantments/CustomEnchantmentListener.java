package com.github.nindroida.nclash.enchantments;

import com.github.nindroida.nclash.NClash;
import com.github.nindroida.nclash.items.weapons.TestItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CustomEnchantmentListener implements Listener {
    private final NClash plugin = NClash.getInstance();

    /*@EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack item = event.getPlayer().getItemInUse();
            if (item != null && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                assert meta != null;
                if (meta.hasLore()) {
                    List<String> lore = meta.getLore();
                    for (CustomEnchantment enchant : CustomEnchantmentManager.getEnchants()) {
                        for (int level = 1; level <= enchant.getMaxLevel(); level++) {
                            if (lore.containsAll(enchant.getLore(level))) {
                                enchant.applyEffect(event, level);
                                event.getPlayer().sendMessage("KABOOM!");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }*/


    public CustomEnchantmentListener() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = TestItem.getItem();
        ItemStack itemIU = e.getPlayer().getItemInUse();
        if (itemIU == item && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            player.sendMessage("KABOOM BITCH");
        }
    }

}
