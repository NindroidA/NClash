package com.github.nindroida.nclash.entities;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;

public class ClashSkeleton extends Skeleton implements ClashEntity {

    public ClashSkeleton(Location loc) {
        super(EntityType.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.setCustomName(Component.literal("Clash Skeleton"));
    }

    @Override
    public Item item(String name) {
        Item i = null;
        switch (name) {
            case "s1": i = Items.STONE_SWORD; break;
            case "s2": i = Items.IRON_SWORD; break;
            case "s3": i = Items.DIAMOND_SWORD; break;

            case "h1": i = Items.CHAINMAIL_HELMET; break;
            case "h2": i = Items.IRON_HELMET; break;
            case "h3": i = Items.DIAMOND_HELMET; break;

            case "c": i = Items.IRON_CHESTPLATE; break;
            case "l": i = Items.IRON_LEGGINGS; break;
            case "b": i = Items.IRON_BOOTS; break;
        }
        return i;
    }

    @Override
    public void giveItem(String n) {
        InteractionHand mh = InteractionHand.MAIN_HAND;
        this.setItemInHand(mh, new ItemStack(item(n)));
    }

    /**
     * giveH
     * gives skeleton a specific helmet
     * @param m helmet material (chainmail, iron, diamond)
     */
    @Override
    public void giveH(String m) {
        EquipmentSlot h = EquipmentSlot.HEAD;
        this.setItemSlot(h, new ItemStack(item(m)));
    }

    /**
     * giveA
     * gives skeleton either a chestplate, leggings, or boots
     * @param a the desired armor piece
     */
    @Override
    public void giveA(String a) {
        EquipmentSlot c = EquipmentSlot.CHEST;
        EquipmentSlot l = EquipmentSlot.LEGS;
        EquipmentSlot b = EquipmentSlot.FEET;

        switch (a) {
            case "chest": this.setItemSlot(c, new ItemStack(item("c")));
            case "leg": this.setItemSlot(l, new ItemStack(item("l")));
            case "boot": this.setItemSlot(b, new ItemStack(item("b")));
        }
    }

    @Override
    public void initEquipment(int level) {
        switch (level) {
            case 1:
                giveItem("s1");
                giveH("h1");
                break;

            case 2:
                giveItem("s2");
                giveH("h1");
                giveA("chest");
                break;

            case 3:
                giveItem("s2");
                giveH("h2");
                giveA("chest");
                break;

            case 4:
                giveItem("s3");
                giveH("h2");
                giveA("chest");
                giveA("leg");
                giveA("boot");
                break;

            case 5:
                giveItem("s3");
                giveH("h3");
                giveA("chest");
                giveA("leg");
                giveA("boot");
                break;
        }

    }

    /**
     * handler
     * spawns ClashSkeletons with respective items and armor
     * @param loc location for skeletons to spawn
     * @param level level of potion
     */
    public static void handler(Location loc, int level) {
        int n;
        if (level == 1 || level == 2) {
            n = 2;
        } else if (level == 3 || level == 4) {
            n = 3;
        } else if (level == 5) {
            n = 4;
        } else {
            return;
        }
        for (int i = 0; i < n; i++) {
            ClashSkeleton skel = new ClashSkeleton(loc);
            skel.initEquipment(level);
            ((CraftWorld) loc.getWorld()).getHandle().addFreshEntity(skel);
        }
    }

    /*@Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new Pathfinder);
        this.goalSelector.addGoal(0, new PathfinderGoalFloat(this));
        this.goalSelector.addGoal(4, new PathfinderGoalMeleeAttack(this, 1.0D, true));
        this.goalSelector.addGoal(5, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.addGoal(1, new PathfinderGoalHurtByTarget(this));
        this.targetSelector.addGoal(2, new PathfinderGoalAvoidSpecificPlayer(this, potionThrower));
    }*/
}
