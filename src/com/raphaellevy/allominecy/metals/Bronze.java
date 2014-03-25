/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author raffa
 */
public class Bronze extends StackedMetal{
    public static void burn(Player play, ItemStack soap, Allominecy plug) {
        if (plug.getConfig().getBoolean("players." + play.getPlayerListName() + ".bronze")) {
            plug.resetcurrallo();
            ArrayList<Player> currallop = plug.getcurrallo();
            Seeking sek = new Seeking(plug);
            while (sek.doneseek == false) {
                if (!(currallop == plug.getcurrallo())) {
                    if (!plug.getcurrallo().isEmpty()) {
                    } else {
                        play.sendMessage(plug.getcurrallo().get(0).getPlayerListName() + " is burning metal");
                        plug.resetcurrallo();
                    }
                }
            }
            play.sendMessage("Done seeking");
        }
    }
}
