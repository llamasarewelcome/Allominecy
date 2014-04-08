/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author raffa
 */
public class Lerasium implements Listener{
    private Allominecy plug;
    public Lerasium(Allominecy plug) {
        this.plug = plug;
    }
    @EventHandler
    public void onLerasium(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && event.getPlayer().getInventory().getItemInHand().getType() == Material.QUARTZ) {
            if(event.getItem().getItemMeta().hasLore() == true) {
                if(event.getItem().getItemMeta().getLore().contains("Lerasium Bead")) {
                    Inventory inv = Bukkit.createInventory(null, 9, "Select your metal");
                    ItemStack ia = LoreItem.r(Material.NETHER_STAR, "Iron", "Lurcher", 1);
                    inv.setItem(0, ia);
                    ItemStack ib = LoreItem.r(Material.NETHER_STAR, "Steel", "Coinshot", 1);
                    inv.setItem(1, ib);
                    ItemStack ic = LoreItem.r(Material.NETHER_STAR, "Tin", "Tineye", 1);
                    inv.setItem(2, ic);
                    ItemStack id = LoreItem.r(Material.NETHER_STAR, "Pewter", "Pewterarm", 1);
                    inv.setItem(3, id);
                    ItemStack ie = LoreItem.r(Material.NETHER_STAR, "Brass", "Soother", 1);
                    inv.setItem(4, ie);
                    ItemStack iff = LoreItem.r(Material.NETHER_STAR, "Zinc", "Rioter", 1);
                    inv.setItem(5, iff);
                    ItemStack ig = LoreItem.r(Material.NETHER_STAR, "Bronze", "Seeker", 1);
                    inv.setItem(6, ig);
                    ItemStack ih = LoreItem.r(Material.NETHER_STAR, "Copper", "Coppercloud", 1);
                    inv.setItem(7, ih);
                    new Tak(event.getPlayer()).runTaskLater(plug, 1);
                    event.getPlayer().openInventory(inv);
                }
            }
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle() == "Select your metal") {
            event.setCancelled(true);
            if (event.getRawSlot() < 9) {
                switch(event.getRawSlot()) {
                    case 0:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "iron", true);
                        break;
                    case 1:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "steel", true);
                        break;
                    case 2:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "tin", true);
                        break;
                    case 3:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "pewter", true);
                        break;
                    case 4:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "brass", true);
                        break;
                    case 5:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "zinc", true);
                        break;
                    case 6:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "bronze", true);
                        break;
                    case 7:
                        plug.getConfig().set("players." + ((Player)event.getWhoClicked()).getPlayerListName() + "." + "copper", true);
                        break;
                    
                }
                event.getWhoClicked().closeInventory();
            }
        }
    }
    private static class Tak extends BukkitRunnable {
        private Player play;
        public Tak(Player play) {
            this.play = play;
        }
        @Override
        public void run() {
            this.play.getInventory().setItemInHand(null);
        }
        
    }
}
