/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author raffa
 */
public class Bronze extends StackedMetal{
    public static void burn(final Player play, ItemStack soap, final Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".bronze")) {
            UseUp(soap, play);
            for (Player pp : Bukkit.getOnlinePlayers()) {
                pp.setMetadata("burning",new FixedMetadataValue(plug,false));
            }
            
            List<MetadataValue> values;
            Boolean pppvalu = false;
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            BukkitTask tt = new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player ppp : Bukkit.getOnlinePlayers()) {
                        List<MetadataValue> values = ppp.getMetadata("burning");
                        Boolean pppvalu = false;
                        pppvalu = values.get(0).asBoolean();
                        if (pppvalu == true) {
                            play.sendMessage(ppp.getPlayerListName() + "is burning metal");
                        }
                        ppp.setMetadata("burning",new FixedMetadataValue(plug,false));
                    }
                }
            }.runTaskTimer(plug, 0, 20);
            SeekTask task2 = new SeekTask(tt);
            task2.runTaskLater(plug, 200);
        }
    }
    static class SeekTask extends BukkitRunnable {
        Boolean dun;
        BukkitTask tt;
        public SeekTask (BukkitTask tt) {
            this.dun = false;
            this.tt = tt;
        }
        @Override
        public void run() {
            tt.cancel();
        }
        
    }
}
