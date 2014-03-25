/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author raffa
 */
public abstract class ExpendableMetal {
    public static void UseUp(ItemStack soap,Player play) {
        play.setItemInHand(new ItemStack(Material.GLASS_BOTTLE));
    }
}
