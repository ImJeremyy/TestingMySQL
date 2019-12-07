package com.gmail.madivoso;

import com.gmail.madivoso.commands.TestCommand;
import com.gmail.madivoso.database.SampleDB;
import com.gmail.madivoso.listeners.JoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestingMySQL extends JavaPlugin {


    private SampleDB db;

    @Override
    public void onEnable() {
        initConfig();
        initDB();
        initListeners();
        initCommands();
    }

    public SampleDB getSampleDB() {
        return db;
    }

    /**
     * Initializes SampleDB object.
     */
    private void initDB() {
        if(getConfig().getBoolean("enabled")) { //if enabled: true
            String host = getConfig().getString("host");
            String databaseName = getConfig().getString("database");
            int port = getConfig().getInt("port");
            String username = getConfig().getString("username");
            String password = getConfig().getString("password");
            db = new SampleDB(host, databaseName, port, username, password);
        }
    }

    /**
     * Initializes default config
     */
    private void initConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void initCommands() {
        getCommand("test").setExecutor(new TestCommand(this));
    }

    private void initListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(this), this);
    }

}
