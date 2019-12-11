package com.gmail.madivoso.commands;

import com.gmail.madivoso.TestingMySQL;
import com.gmail.madivoso.enums.Perm;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestingMySQLReloadCommand implements CommandExecutor {

    private TestingMySQL plugin;

    public TestingMySQLReloadCommand(TestingMySQL plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission(Perm.TESTING_MY_SQL_RELOAD.getPermission())) {
            plugin.reloadDB();
            sender.sendMessage(ChatColor.GREEN + "Reload successful.");
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission.");
        }
        return true;
    }

}
