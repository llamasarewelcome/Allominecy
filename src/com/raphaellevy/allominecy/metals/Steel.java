/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import static com.raphaellevy.allominecy.metals.StackedMetal.UseUp;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

/**
 *
 * @author raffa
 */
public class Steel extends StackedMetal{
    public static void burn(Player play, ItemStack soap, Allominecy plug) {
        if (play.getTargetBlock(null, 40).getType() == Material.IRON_BLOCK) {
            
            if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".steel")) {
                if (!plug.copp.getBurners().contains(play)) {
                    play.setMetadata("burning", new FixedMetadataValue(plug, true));
                }

                Vector vec = play.getLocation().getDirection().multiply(-2);
                play.setVelocity(vec);
            }
            UseUp(soap, play);
        }
    }
}
