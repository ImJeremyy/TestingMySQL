package com.gmail.madivoso;

import com.gmail.madivoso.database.SampleDB;
import org.bukkit.plugin.java.JavaPlugin;

public class TestingMySQL extends JavaPlugin {


    private SampleDB db;

    @Override
    public void onEnable() {
        initConfig();
        initDB();
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

}
