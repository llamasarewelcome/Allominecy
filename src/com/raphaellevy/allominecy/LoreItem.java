/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author raffa
 */
public class LoreItem {
    public static ItemStack r(Material mat, String lore, int amount) {
        ItemStack cook = new ItemStack(mat);
        ItemMeta cmet = cook.getItemMeta();
        ArrayList lor = new ArrayList();
        lor.add(lore);
        cmet.setLore(lor);
        cook.setItemMeta(cmet);
        return cook;
    }
    public static ItemStack r(Material mat, String name, String lore, int amount) {
        ItemStack cook = new ItemStack(mat);
        ItemMeta cmet = cook.getItemMeta();
        ArrayList lor = new ArrayList();
        lor.add(lore);
        cmet.setLore(lor);
        cmet.setDisplayName(name);
        cook.setItemMeta(cmet);
        return cook;
    }
}
