/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import java.util.List;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author raffa
 */
public class Zinc extends StackedMetal{
    public static void burn(Player play, ItemStack soap, Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".zinc")) {
            List<Entity> mobs = play.getNearbyEntities(10, 10, 10);
            for (Entity ent : mobs) {
                if ((!(ent instanceof LivingEntity)) || (ent instanceof Player)) {
                    mobs.remove(ent);
                }
            }
            LivingEntity llent;
            Tameable tent;
            Wolf went;
            Enderman oent;
            for (Entity lent : mobs) {
                llent = (LivingEntity) lent;
                if (llent instanceof Tameable) {
                    tent = (Tameable) llent;
                    tent.setTamed(false);
                }
                if (llent instanceof Wolf) {
                    went = (Wolf) llent;
                    went.setAngry(true);
                }
                if (llent instanceof Enderman) {
                    oent = (Enderman) lent;
                    oent.setTarget(play);
                }
            }
        }
    }
}
