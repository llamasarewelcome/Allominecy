/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import com.raphaellevy.allominecy.Allominecy;
import com.raphaellevy.allominecy.metals.Brass;
import com.raphaellevy.allominecy.metals.Bronze;
import com.raphaellevy.allominecy.metals.Copper;
import com.raphaellevy.allominecy.metals.Iron;
import com.raphaellevy.allominecy.metals.Pewter;
import com.raphaellevy.allominecy.metals.Steel;
import com.raphaellevy.allominecy.metals.Tin;
import com.raphaellevy.allominecy.metals.Zinc;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author raffa
 */
public class MVial implements Listener{
    private Allominecy plug;
    public MVial(Allominecy plug) {
        this.plug = plug;
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && event.getPlayer().getInventory().getItemInHand().getType() == Material.POTION) {
            if(event.getItem().getItemMeta().hasLore() == true) {
                if(event.getItem().getItemMeta().getLore().contains("Metal Vial")) {
                    
                    event.getPlayer().openInventory(this.plug.myInv);
                    new Taskk(event).runTaskLater(plug, 1);
                    
                }
            }
        }
    }
    public class Taskk extends BukkitRunnable {
        private final PlayerInteractEvent event;
        public Taskk(Event event) {
            this.event = (PlayerInteractEvent) event;
        }
        @Override
        public void run() {
            event.getPlayer().getInventory().setItem(event.getPlayer().getInventory().getHeldItemSlot(), null);
        }
        
    }
}
