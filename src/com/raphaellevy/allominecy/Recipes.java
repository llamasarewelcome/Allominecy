/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author raffa
 */
public class Recipes {
    public void add() {
        String[] rec = {"PPP"," N ","   "};
        char[] abvs = {'P','N'};
        Material[] mats = {Material.POTION,Material.GOLD_NUGGET};
        ShapedRecipe addRecipec = addRecipe(rec, "Metal Vial", abvs, mats);
        Bukkit.addRecipe(addRecipec);
        
    }
    public ShapedRecipe addRecipe(String[] rec, String lore, char[] abr, Material[] mats) {
       ItemStack wst = new ItemStack(Material.POTION, 64);
       ItemMeta wmet = wst.getItemMeta();
       ArrayList wlst = new ArrayList();
       wlst.add(lore);
       wmet.setLore(wlst);
       wst.setItemMeta(wmet);
       ShapedRecipe wrec = new ShapedRecipe(wst);
       wrec.shape(rec);
       int i =  0;
       for (char c : abr) {
           wrec.setIngredient(c, mats[i]);
           i++;
       }
       return wrec;
    }
}
