package com.github.nindroida.nclash.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.Bat;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;

public class ClashBat extends Bat {

    public ClashBat(Location loc) {
        super(EntityType.BAT, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
    }
}
