/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author raffa
 */
public class Tin extends StackedMetal{
    public static void burn(Player play,ItemStack soap,Allominecy plug) {
        if(plug.getConfig().getBoolean("players."+ play.getPlayerListName() + ".tin")) {
            if (!(plug.copp.getBurners().contains(play))) {
                play.setMetadata("burning", new FixedMetadataValue(plug, true));
            }

            play.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,100,1),true);
        }
        UseUp(soap,play);
        
    }
}