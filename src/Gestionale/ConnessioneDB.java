package Gestionale;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnessioneDB {



   // public static String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
    //public static String connectionUrl = "jdbc:mysql://localhost:3306/Gestionale?user=Leti&password=Letiziacar";
    public static String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Gestionale;user=Letizia;password=qwerty;";
    
    //public static String connectionUrl = "jdbc:sqlserver://DESKTOP-A2PFO05\\SQLEXPRESS:0;databaseName=Gestionale;user=chiara;password=chiara2000";

    public static void main(String[] argv){
       /* try{
            Class.forName("com.mysql.jdbc.Driver");
        }
         catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            System.out.println("ACCESSO RIUSCITO");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
