package com.gmail.madivoso;

import com.gmail.madivoso.db.LemonDB;
import org.bukkit.plugin.java.JavaPlugin;

public class TestingMySQL extends JavaPlugin {

    private String host;
    private String databaseName;
    private int port;
    private String username;
    private String password;

    private LemonDB db;

    @Override
    public void onEnable() {
        initConfig();
        if(getConfig().getBoolean("enabled")) {
            initDBInfo();
            db = new LemonDB(host, databaseName, port, username, password);
        }
    }

    /**
     * Obtains the database info from the config.yml
     */
    private void initDBInfo() {
//        host = "localhost";
//        databaseName = "lemon";
//        username = "root";
//        password = "";
//        port = 3306;

         host = getConfig().getString("host");
         databaseName = getConfig().getString("database");
         port = getConfig().getInt("port");
         username = getConfig().getString("username");
         password = getConfig().getString("password");
    }

    /**
     * Initializes default config
     */
    private void initConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
