/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import com.raphaellevy.allominecy.metals.Brass;
import com.raphaellevy.allominecy.metals.Bronze;
import com.raphaellevy.allominecy.metals.Copper;
import com.raphaellevy.allominecy.metals.Iron;
import com.raphaellevy.allominecy.metals.Pewter;
import com.raphaellevy.allominecy.metals.Steel;
import com.raphaellevy.allominecy.metals.Tin;
import com.raphaellevy.allominecy.metals.Zinc;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
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
    
    public CopperManager copp;
    public BrassManager brass;
    public Recipes reci;
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.myInv.setItem(2, FM.forge("Tin Vial", 64));
        this.myInv.setItem(0, FM.forge("Iron Vial", 64));
        this.myInv.setItem(1, FM.forge("Steel Vial", 64));
        this.myInv.setItem(7, FM.forge("Bronze Vial", 64));
        this.myInv.setItem(4, FM.forge("Zinc Vial", 64));
        this.myInv.setItem(6, FM.forge("Copper Vial", 64));
        this.myInv.setItem(5, FM.forge("Brass Vial", 64));
        this.myInv.setItem(3, FM.forge("Pewter Vial", 64));
        getCommand("metal").setExecutor(new MetCommand(this));
        getCommand("misting").setExecutor(new AddMetals(this));
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new MetMenu(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Brass(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MVial(this), this);
        //Bukkit.getServer().getPluginManager().registerEvents(new CraftMetal(this), this);
        this.copp = new CopperManager();
        this.brass = new BrassManager();
        this.reci = new Recipes();
        reci.add();
        
        
    }
    public class BrassManager {
        public List<Creature> soothed = new ArrayList<>();
        public BrassManager() {
            this.soothed.clear();
        }
        public List<Creature> sooth (Creature play) {
            if (!(this.soothed.contains(play))) {
                this.soothed.add(play);
            }
            return this.soothed;
        }
        public List<Creature> unSooth (Creature play) {
            if (this.soothed.contains(play)) {
                this.soothed.remove(play);
            }
            return this.soothed;
        }
        public List<Creature> getSoothed () {
            return this.soothed;
        }
    }
    public class CopperManager {
        public List<Player> copperBurners = new ArrayList<>();
        public CopperManager() {
            this.copperBurners.clear();
        }
        public List<Player> addBurner (Player play) {
            if (!(this.copperBurners.contains(play))) {
                this.copperBurners.add(play);
            }
            return this.copperBurners;
        }
        public List<Player> removeBurner (Player play) {
            if (this.copperBurners.contains(play)) {
                this.copperBurners.remove(play);
            }
            return this.copperBurners;
        }
        public List<Player> getBurners () {
            return this.copperBurners;
        }
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
                } else if(event.getItem().getItemMeta().getLore().contains("Copper Vial")) {
                    
                    Copper.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Brass Vial")) {
                    
                    Brass.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                } else if(event.getItem().getItemMeta().getLore().contains("Pewter Vial")) {
                    
                    Pewter.burn(event.getPlayer(),event.getPlayer().getItemInHand(), this);
                }
            }
        }
    }
}
