/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author raffa
 */
public abstract class StackedMetal {
    public static void UseUp(ItemStack soap, Player player) {
        if (Integer.parseInt(soap.getItemMeta().getLore().get(1)) > 1) {
            ItemMeta smeta = soap.getItemMeta();
            ArrayList lora = (ArrayList) smeta.getLore();
            lora.set(1, String.valueOf(Integer.parseInt(soap.getItemMeta().getLore().get(1)) - 1));
            smeta.setLore(lora);
            soap.setItemMeta(smeta);
            player.getInventory().setItemInHand(soap);
        } else {
            ItemMeta smeta = soap.getItemMeta();
            ArrayList lora = new ArrayList();
            smeta.setLore(lora);
            soap.setItemMeta(smeta);
            player.getInventory().setItemInHand(new ItemStack(Material.GLASS_BOTTLE));
        }
    }
}
