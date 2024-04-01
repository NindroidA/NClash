package com.github.nindroida.nclash.entities;

import net.minecraft.world.item.Item;

import javax.xml.stream.Location;

public interface ClashEntity{

    /**
     * item
     * @param name the name of the item
     * @return the item wanted
     */
    Item item(String name);

    /**
     * giveItem
     * gives entity a specific item
     * @param n the item name (s1, s2, s3)
     */
    void giveItem(String n);

    /**
     * giveH
     * gives entity a specific helmet
     * @param m helmet material (chainmail, iron, diamond)
     */
    void giveH(String m);

    /**
     * giveA
     * gives entity either a chestplate, leggings, or boots
     * @param a the desired armor piece
     */
    void giveA(String a);

    /**
     * initEquipment
     * gives entity items/armor based on what level the potion is
     * @param level level of the potion
     */
    void initEquipment(int level);

}
