/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import com.raphaellevy.allominecy.metals.Bronze;
import com.raphaellevy.allominecy.metals.Iron;
import com.raphaellevy.allominecy.metals.Steel;
import com.raphaellevy.allominecy.metals.Tin;
import com.raphaellevy.allominecy.metals.Zinc;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author raffa
 */
public class Allominecy extends JavaPlugin implements Listener{
    public Inventory myInv = Bukkit.createInventory(null, 9, "Choose a metal");
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.myInv.setItem(0, FM.forge("Tin Vial", 64));
        this.myInv.setItem(1, FM.forge("Iron Vial", 64));
        this.myInv.setItem(2, FM.forge("Steel Vial", 64));
        this.myInv.setItem(3, FM.forge("Bronze Vial", 64));
        this.myInv.setItem(4, FM.forge("Zinc Vial", 64));
        getCommand("metal").setExecutor(new MetCommand(this));
        getCommand("misting").setExecutor(new AddMetals(this));
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new MetMenu(), this);
        
        
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) { //define event
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && event.getPlayer().getInventory().getItemInHand().getType() == Material.POTION) {
            if(event.getItem().getItemMeta().hasLore() == true) {
                if(event.getItem().getItemMeta().getLore().contains("Tin Vial")) {
                    
                    Tin.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Iron Vial")) {
                    
                    Iron.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Steel Vial")) {
                    
                    Steel.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Bronze Vial")) {
                    
                    Bronze.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Zinc Vial")) {
                    
                    Zinc.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                }
            }
        }
    }
}
