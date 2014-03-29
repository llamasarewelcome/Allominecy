/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author raffa
 */
public class Copper extends StackedMetal{
    public static void burn(Player play, ItemStack soap, Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".copper")) {
            plug.copp.addBurner(play);
            CopperTask task = new CopperTask(play, plug);
            task.runTaskLater(plug, 200);
        }
        UseUp(soap,play);
        
    }
    public static class CopperTask extends BukkitRunnable {
        public Player play;
        public Allominecy plug;
        public CopperTask(Player play, Allominecy plug) {
            this.play = play;
            this.plug = plug;
        }
        @Override
        public void run() {
            plug.copp.removeBurner(play);
        }
        
    }
}