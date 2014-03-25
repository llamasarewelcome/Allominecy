/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.allominecy.metals;

import com.raphaellevy.allominecy.Allominecy;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author raffa
 */
public class Seeking {
    boolean doneseek;
    public Seeking(Allominecy plug) {
        this.doneseek = false;
        SeekTask task1 = new SeekTask(this);
        task1.runTaskLater(plug, 200);
    }
    public void fin() {
        this.doneseek = true;
    }

    private class SeekTask extends BukkitRunnable{
        private Seeking see;
        public SeekTask(Seeking see) {
            this.see = see;
        }
        @Override
        public void run() {
            see.fin();
        }
    }
}
