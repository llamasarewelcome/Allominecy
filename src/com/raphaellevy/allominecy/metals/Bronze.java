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
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author raffa
 */
public class Bronze extends StackedMetal{
    public static void burn(Player play, ItemStack soap, Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".bronze")) {
            for (Player pp : Bukkit.getOnlinePlayers()) {
                pp.setMetadata("burning",new FixedMetadataValue(plug,false));
            }
            SeekTask task2 = new SeekTask();
            task2.runTaskLater(plug, 200);
            List<MetadataValue> values;
            Boolean pppvalu = false;
            while (task2.dun == false) {
                for (Player ppp : Bukkit.getOnlinePlayers()) {
                    values = ppp.getMetadata("burning");
                    pppvalu = false;
                    for (MetadataValue value : values) {
                        if (value.getOwningPlugin() == plug) {
                            pppvalu = (Boolean) value.value();
                        }
                    }
                    if (pppvalu = true) {
                        play.sendMessage(ppp.getPlayerListName() + "is burning metal");
                    }
                    ppp.setMetadata("burning",new FixedMetadataValue(plug,false));
                }
            }
            
        }
    }
    static class SeekTask extends BukkitRunnable {
        Boolean dun;
        public SeekTask () {
            this.dun = false;
        }
        @Override
        public void run() {
            this.dun = true;
        }
        
    }
}
