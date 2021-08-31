package Frutta;

import java.sql.*;

public class Inserimento extends ConnessioneDB2{

    public static Boolean Inserisci(String tipo, Integer cod){
        boolean check=false;
        try {
            Connection con = DriverManager.getConnection(ConnessioneDB2.connectionUrl);
            Statement stmt = con.createStatement();

            String query="INSERT INTO Frutto(Tipo, Codice) VALUES(?,?)";
            try{
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1,tipo);
                statement.setInt(2,cod);
                statement.executeUpdate();
                check=true;
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    public static boolean Delete(String tipo, Integer cod){
        boolean check=false;
        try {
            Connection con = DriverManager.getConnection(ConnessioneDB2.connectionUrl);
            Statement stmt = con.createStatement();

            String SQL = "select * from Frutto";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                if((rs.getString("Tipo")!=tipo || rs.getInt("Codice")!= cod)
                || (rs.getString("Tipo")!=tipo && rs.getInt("Codice")!= cod)){
                    check=false;
                }
                else{
                    check=true;
                    break;
                }
            }
            if(check==true){
            String query="delete from frutto where codice=? and tipo=? ";
            try{
                PreparedStatement statement = con.prepareStatement(query);
                statement.setInt(1,cod);
                statement.setString(2,tipo);
                statement.executeUpdate();
                check=true;
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            }
        return check;
    }

    public static void main(String[] argv){
        Frutto frutto=new Frutto();
        Inserisci(frutto.getTipo(),frutto.getCodice());
    }
}
