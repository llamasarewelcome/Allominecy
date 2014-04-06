/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author raffa
 */
public class MetMenu implements Listener{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getInventory().getName() == "Choose a metal") {
            if (event.getRawSlot() <= 8) {
                event.getWhoClicked().getInventory().addItem(new ItemStack(event.getCurrentItem()));
                
                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}
