package com.gmail.madivoso.listeners;

import com.gmail.madivoso.TestingMySQL;
import com.gmail.madivoso.database.SampleDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

/**
 * Handles when event when player joins.
 */
public class JoinListener implements Listener {

    private SampleDB sdb;

    public JoinListener(TestingMySQL plugin) {
       sdb = plugin.getSampleDB();
    }

    @EventHandler (priority = EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String name = player.getName();


    }

}
