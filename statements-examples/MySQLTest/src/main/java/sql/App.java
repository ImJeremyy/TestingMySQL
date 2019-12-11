package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public final class App {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lemon", "root", null);
            System.out.println("Connection successful!");

            PreparedStatement st = con.prepareStatement("SELECT * FROM people;");
            ResultSet rs = st.executeQuery();
            displayResultSet(rs);

            Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            st.execute("INSERT INTO people (last_name, first_name, balance) VALUES (\'Tubongbanua\', \'Rolando\', 250);");
         


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection unsuccessful!");
        }
    }

    private static void displayResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int columnsNumber = meta.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + meta.getColumnName(i));
            }
            System.out.println("");
        }

    }

}
