/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author raffa
 */
public class MetCommand implements CommandExecutor{
    public Allominecy plug;
    public MetCommand(Allominecy plug) {
        this.plug = plug;
    }
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (this.plug.lperm.hasPerm((Player) cs, "Allominecy", "metal")) {
            Player play = (Player) cs;
            play.openInventory(plug.myInv);
            return true;
        } else {
            cs.sendMessage("no perm");
            return true;
        }
    }
}
