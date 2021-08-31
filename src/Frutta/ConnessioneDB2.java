package Frutta;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnessioneDB2 {
    //String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
    public static String connectionUrl = "jdbc:sqlserver://DESKTOP-A2PFO05\\SQLEXPRESS:0;databaseName=Prova_OOP;user=chiara;password=chiara2000";

    public static void main(String[] argv){
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "select * from Frutto";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("Tipo") + " " + rs.getString("Codice"));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
