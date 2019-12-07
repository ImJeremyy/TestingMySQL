package com.gmail.madivoso.commands;

import com.gmail.madivoso.TestingMySQL;
import com.gmail.madivoso.database.SampleDB;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {

    private SampleDB db;

    public TestCommand(TestingMySQL plugin) {
        db = plugin.getSampleDB();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        return true;
    }

}
