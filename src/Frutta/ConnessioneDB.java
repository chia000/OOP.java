package Frutta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnessioneDB {
 //   public class ConnectURL {
 public static String connectionUrl = "jdbc:sqlserver://DESKTOP-A2PFO05\\SQLEXPRESS:0;databaseName=Prova_OOP;user=chiara;password=chiara2000";

    public static void main(String[] args) {

            // Create a variable for the connection string.
            //String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
           // String connectionUrl = "jdbc:sqlserver://DESKTOP-A2PFO05\\SQLEXPRESS:0;databaseName=Prova_OOP;user=chiara;password=chiara2000";
            //String connectionUrl = "jdbc:sqlserver://DESKTOP-A2PFO05;instanceName=SQLEXPRESS:0;databaseName=Prova_OOP;user=chiara;password=chiara2000";
            // jdbc:sqlserver://[serverName[\instanceName][:portNumber]]
            // jdbc:sqlserver://localhost;instanceName=instance1;integratedSecurity=true;<more properties as required>;
            try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
                String SQL = "select * from Frutto";
                ResultSet rs = stmt.executeQuery(SQL);

                // Iterate through the data in the result set and display it.
                while (rs.next()) {
                    System.out.println(rs.getString("Tipo") + " " + rs.getString("Codice"));
                }
            }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static void Inserisci(){
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO Frutto (Tipo, Codice) VALUES ('PESCA', 5)");

                String SQL = "select * from Frutto";
                ResultSet rs = stmt.executeQuery(SQL);

                // Iterate through the data in the result set and display it.
                while (rs.next()) {
                    System.out.println(rs.getString("Tipo") + " " + rs.getString("Codice"));
                }
            }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//}
