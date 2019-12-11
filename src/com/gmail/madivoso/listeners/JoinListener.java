package com.gmail.madivoso.listeners;

import com.gmail.madivoso.TestingMySQL;
import com.gmail.madivoso.database.SampleDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Handles event when player joins.
 */
public class JoinListener implements Listener {

    private SampleDB sdb;

    public JoinListener(TestingMySQL plugin) {
       sdb = plugin.getSampleDB();
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(sdb != null) {
            Player player = event.getPlayer();
            sdb.registerNewPlayer(player);
        }
    }

}
