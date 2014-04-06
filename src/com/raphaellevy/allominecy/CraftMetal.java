/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author raffa
 */
public class CraftMetal implements Listener{
    private Allominecy plug;
    public CraftMetal(Allominecy plug) {
        this.plug = plug;
    }
    /*@EventHandler
    public void onCraft(CraftItemEvent event) {
    ItemStack wst = new ItemStack(Material.POTION, 64);
    ItemMeta wmet = wst.getItemMeta();
    ArrayList wlst = new ArrayList();
    wlst.add("Metal Vial");
    wmet.setLore(wlst);
    wst.setItemMeta(wmet);
    ShapedRecipe wrec = new ShapedRecipe(wst);
    wrec.shape("PPP"," N ","   ");
    int i =  0;
    for (char c : new char[]{'P','N'}) {
    wrec.setIngredient(c, new Material[]{Material.POTION, Material.GOLD_NUGGET}[i]);
    i++;
    }
    
    
    
    
    if (event.getRecipe().getResult().getItemMeta().hasLore()) {
    if (event.getRecipe().getResult().getItemMeta().getLore().contains("Metal Vial")) {
    Player play = (Player) event.getWhoClicked();
    for (ItemStack il : event.getInventory().getContents()) {
    il.setType(Material.AIR);
    }
    play.closeInventory();
    play.openInventory(plug.myInv);
    
    }
    }
    
    
    }*/
}
