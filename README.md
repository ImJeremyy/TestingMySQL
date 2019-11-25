# TestingMySQL
 MySQL connection with Bukkit plugins example
 
# Required Arguments (#1)
The following arguments are required for a connection:
```
String host; 		//host address (eg: "localhost")
String database; 	//name of database (eg: "lemon")
int port; 			//port (eg: 3306)
String username; 	//username for database priveleges (eg: "root")
String password; 	//password for database priveleges (eg: "password" or null)
```

# Checking the Connection (#2)
Before making a connection to the database, check if a connection is already made.
```
//returns true if connection is open
public boolean connectionExists(Connection con) {
	retrun con != null && !con.isClosed();
}
```

# Make URL (#3)
```
//returns SQL URL
public String getSQLURL(String host, int port, String databaseName) {
	String url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
	return url;
}
```

# Set connection (#4)
```
//opens the connection with the SQL database.
private void openConnection(String url, String username, String password) {
	try {
		this.connection = DriverManager.getConnecton(url, username, password == "" ? null : password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
```

