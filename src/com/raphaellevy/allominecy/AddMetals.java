/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author raffa
 */
public class AddMetals implements CommandExecutor{
    Allominecy plug;
    public AddMetals(Allominecy plug) {
        this.plug = plug;
    }
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (this.plug.lperm.hasPerm((Player) cs, "Allominecy", "misting")) {
            if (!(strings.length == 3)) {
                return false;
            }
            Player play = Bukkit.getPlayer(strings[0]);
            if (play == null) {
                cs.sendMessage("Cant find player");
                return false;
            }
            plug.getConfig().set("players." + play.getPlayerListName() + "." + strings[1], Boolean.parseBoolean(strings[2]));
            plug.saveConfig();
            return true;
        } else {
            cs.sendMessage("No perm");
            return true;
        }
        
    }
    
}
