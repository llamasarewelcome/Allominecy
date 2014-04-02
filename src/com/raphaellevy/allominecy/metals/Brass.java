/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author raffa
 */
public class Brass extends StackedMetal implements Listener{
    Allominecy plug;
    public static void burn(Player play,ItemStack soap,Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".brass")) {
            if (!(plug.copp.getBurners().contains(play))) {
                play.setMetadata("burning", new FixedMetadataValue(plug, true));
            }
            UseUp(soap,play);
            List<Entity> ents = play.getNearbyEntities(10, 10, 10);
            List<Creature> mobs = new ArrayList<>();
            for (Entity ent : ents) {
                if (ent instanceof Creature) {
                    plug.brass.sooth((Creature) ent);
                    mobs.add((Creature) ent);
                }
            }
            BrassTask task = new BrassTask(plug, mobs);
            task.runTaskLater(plug, 200);
        }
    }
    public static class BrassTask extends BukkitRunnable {
        private Allominecy plug;
        private List<Creature> mobs;
        public BrassTask(Allominecy plug,List<Creature> mobs) {
            this.plug = plug;
            this.mobs = mobs;
        }

        @Override
        public void run() {
            for (Creature mob : this.mobs) {
                this.plug.brass.unSooth(mob);
            }
        }
    }
    public Brass(Allominecy plug) {
        this.plug = plug;
    }
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (this.plug.brass.getSoothed().contains(event.getDamager())) {
            event.setCancelled(true);
        }
    }
}
