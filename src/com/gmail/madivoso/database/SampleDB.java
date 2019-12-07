package com.gmail.madivoso.database;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleDB {

    private Connection connection;

    /**
     * Instantiate the database
     *
     * @param host         - eg: localhost
     * @param databaseName - eg: lemon
     * @param port         - eg: 3306
     * @param username     - eg: root
     * @param password     - eg: password
     */
    public SampleDB(String host, String databaseName, int port, String username, String password) {
        if (!isConnectionValid()) { //if the connection is not valid..
            openConnection(getSQLConnectionURL(host, databaseName, port), username, password); //open the connection!
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Database already connected.");
        }
    }

    /**
     * Check if the connection to the database is valid.
     *
     * @return true if connection is valid.
     */
    private boolean isConnectionValid() {
        try {
            return connection != null && !connection.isClosed(); //returns true (connection is valid) if connection is not null and connection is open
        } catch (SQLException e) {
            return false; //if connection is null, the connection is not valid.
        }
    }

    /**
     * Opens the connection (makes 'connection' not null)
     *
     * @param url      - url of the database
     * @param username - username (eg: default = root)
     * @param password - password (eg: password or "" if there is no password)
     */
    private void openConnection(String url, String username, String password) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Attempting to form SQL connection...");
        if (!isConnectionValid()) { //if there isn't a connection already...
            try {
                this.connection = DriverManager.getConnection(url, username, password == "" ? null : password);
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "SQL Connection successful!");
            } catch (SQLException e) {
                e.printStackTrace();
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "SQL Connection unsuccessful.");
            }
        }
    }


    /**
     * Returns an SQL URL given the host, database name and port.
     *
     * @param host         - host name (localhost)
     * @param databaseName - database name (eg: lemon)
     * @param port         - port (defualt port = 3306)
     * @return SQL URL
     */
    private String getSQLConnectionURL(String host, String databaseName, int port) {
        return "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
    }

}