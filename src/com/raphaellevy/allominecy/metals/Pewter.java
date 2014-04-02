/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import static com.raphaellevy.allominecy.metals.StackedMetal.UseUp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author raffa
 */
public class Pewter extends StackedMetal{
    public static void burn(Player play,ItemStack soap,Allominecy plug) {
        if(plug.getConfig().getBoolean("players."+ play.getPlayerListName() + ".pewter")) {
            if (!(plug.copp.getBurners().contains(play))) {
                play.setMetadata("burning", new FixedMetadataValue(plug, true));
            }

            play.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,2),true);
            play.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,200,2),true);
            play.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,400,1),true);
            play.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,200,2),true);
        }
        UseUp(soap,play);
    }
}
