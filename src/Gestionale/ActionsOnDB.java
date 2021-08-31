package Gestionale;

import java.sql.*;
import java.util.Map;

public class ActionsOnDB extends ConnessioneDB{
    public static Boolean OkUser(String username, String u_password){
        // Se ritorna false --> ACCESSO NEGATO
        // Se ritorna true --> ACCSSO CONSENTITO

        boolean check=false;

        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="SELECT * FROM LoginUser";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if(rs.getString("Username").equals(username)
                        && rs.getString("Password").equals(u_password)){
                    check=true;
                    break;
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    public static String visualizzaProdotti(){
        String elenco=new String();
        elenco="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="select * from prodotto";
            ResultSet rs= stmt.executeQuery(query);
            int i =1;
            while(rs.next()){
                elenco=elenco+i+") CODICE: "+rs.getString("Codice")+"; NOME: "+rs.getString("Nome")+ "; MARCA: "+ rs.getString("Marca")+
                        "; PREZZO: "+ rs.getDouble("Prezzo")+ " Euro; NUMERO PEZZI: "+rs.getInt("Num_Pezzi")+"."+'\n'+'\n';
                ++i;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return elenco;
    }

    public static String visualizzaCliente(){
        String elenco=new String();
        elenco="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="select * from cliente";
            ResultSet rs= stmt.executeQuery(query);
            int i =1;
            while(rs.next()){
                elenco=elenco+i+") CODICE FISCALE: "+rs.getString("cf")+"; NOME: "+rs.getString("Nome")+ "; COGNOME: "
                        + rs.getString("Cognome")+"."+'\n'+'\n';
                ++i;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return elenco;
    }

    public static String visualizzaFornitore(){
        String elenco=new String();
        elenco="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="select * from fornitore";
            ResultSet rs= stmt.executeQuery(query);
            int i =1;
            while(rs.next()){
                elenco=elenco+i+") PARTITA IVA: "+rs.getString("p_iva")+"; NOME: "+rs.getString("Nome")+ "; LUOGO: "
                        + rs.getString("luogo")+"."+'\n'+'\n';
                ++i;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return elenco;
    }

    public static String visualizzaOrdiniFornitore(){
        String elenco=new String();
        elenco="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="select * from ordine_fornitore";
            ResultSet rs= stmt.executeQuery(query);
            int i =1;
            while(rs.next()){
                elenco=elenco+i+") CODICE PRODOTTO: "+rs.getString("cod_prod")+"; PARTITA IVA: "+rs.getString("p_iva_fornitore")+ "; PREZZO: "
                        + rs.getDouble("Prezzo")+"; NUMERO PEZZI: "+rs.getInt("Nr_pezzi")+"."+'\n'+'\n';
                ++i;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return elenco;
    }

    public static String visualizzaOrdiniClienti(){
        String elenco=new String();
        elenco="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String query="select * from ordine_cliente";
            ResultSet rs= stmt.executeQuery(query);
            int i =1;
            while(rs.next()){
                elenco=elenco+i+") CODICE PRODOTTO: "+rs.getString("cod_prod")+"; NUMERO PEZZI: "+rs.getInt("Num_pezzi")+
                        "; CODICE FISCALE: "+rs.getString("cf_cliente")+"."+'\n'+'\n';
                ++i;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return elenco;
    }

    public static String[] elencoFornitori(){
        String[] risultato=new String[50];
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select count(nome) as quanti from fornitore";
            ResultSet rsCount= stmt.executeQuery(count);
            int c=0;
            while(rsCount.next()){
                c=rsCount.getInt("quanti");
            }
            risultato=new String[c+1];
            String query="select nome from Fornitore";
            ResultSet rs = stmt.executeQuery(query);
            risultato[0]="Seleziona...";
            c=1;
            while(rs.next()){
                risultato[c]=rs.getString("Nome");
                //System.out.println(rs.getString("Nome"));
                ++c;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

    public static int Conta(String nomep){
        int conta=0;
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select count(nome) as quanti from prodotto where nome = '"+nomep+"'";
            ResultSet rsCount= stmt.executeQuery(count);
            while(rsCount.next()){
                conta=rsCount.getInt("quanti");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conta;
    }

    public static String[] elencoCodProdottoSelezionato(String nomep){
        String[] risultato=new String[50];
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select count(nome) as quanti from prodotto where nome = '"+nomep+"'";
            ResultSet rsCount= stmt.executeQuery(count);
            int c=0;
            while(rsCount.next()){
                c=rsCount.getInt("quanti");
            }
            risultato=new String[c+1];
            String query="select codice from prodotto where nome = '"+nomep+"'";
            ResultSet rs = stmt.executeQuery(query);
            risultato[0]="Seleziona...";
            c=1;
            while(rs.next()){
                risultato[c]=rs.getString("Codice");
                //System.out.println(risultato[c]);
                ++c;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

    public static String elencoFornitoriProdottoSelezionato(String codp){
        String risultato="";
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select marca from prodotto where codice = '"+codp+"'";
            ResultSet rsCount= stmt.executeQuery(count);
            while(rsCount.next()){
                risultato=rsCount.getString("Marca");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

    public static String[] elencoProdotti(){
        String[] risultato=new String[50];
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select count(codice) as quanti from prodotto";
            ResultSet rsCount= stmt.executeQuery(count);
            int c=0;
            while(rsCount.next()){
                c=rsCount.getInt("quanti");
            }
            risultato=new String[c+1];
            String query="select distinct nome from prodotto";
            ResultSet rs = stmt.executeQuery(query);
            risultato[0]="Seleziona...";
            c=1;
            while(rs.next()){
                risultato[c]=rs.getString("Nome");
                //System.out.println(rs.getString("Nome"));
                ++c;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

    public static String[] elencoClienti(){
        String[] risultato=new String[200];
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select count(cf) as quanti from cliente";
            ResultSet rsCount= stmt.executeQuery(count);
            int c=0;
            while(rsCount.next()){
                c=rsCount.getInt("quanti");
            }
            risultato=new String[c+1];
            String query="select cf from cliente";
            ResultSet rs = stmt.executeQuery(query);
            risultato[0]="Seleziona...";
            c=1;
            while(rs.next()){
                risultato[c]=rs.getString("cf");
                ++c;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

    public static String trovaNomeCognome(String cf){
        String ris="";

        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){
            String count="select nome, cognome from cliente where cf='"+cf+"'";
            ResultSet rs= stmt.executeQuery(count);
            while(rs.next()){
                ris= rs.getString("Nome")+" "+ rs.getString("Cognome");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return ris;
    }

    public static double CalcolaPrezzo(String cod, int numpezzi){
        double error=0;
        double ris=1;
        try(Connection con= DriverManager.getConnection(connectionUrl); Statement stmt=con.createStatement();){

            String ok_pezzi="select Num_Pezzi from prodotto where codice = '"+ cod+"'";
            ResultSet rspezzi= stmt.executeQuery(ok_pezzi);
            int tmp=0;
            while (rspezzi.next()){
                tmp=rspezzi.getInt("Num_Pezzi");
            }
            if(numpezzi>tmp){
                return error;
            }

            String count="select Prezzo from prodotto where codice = '"+ cod+"'";
            ResultSet rsCount= stmt.executeQuery(count);
            while(rsCount.next()){
                ris=rsCount.getInt("Prezzo");
            }
            ris=ris*numpezzi;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ris;
    }

    public static int InserisciProdotto(String cod, String nome, String marca, double prezzo, int num_pezzi){
        int num1=1; // Messaggio di marca="Seleziona..."
        int num3=3; // Messaggio per codice già presente
        int num4=4; // Messaggio INSERIMENTO RIUSCITO
        int num5=5; // Messaggio manca nome
        int num6=6; // Messaggio manca codice

        if(cod.length()==0){
            return num6;
        }

        if(nome.length()==0){
            return num5;
        }

        if(marca=="Seleziona...") {
            return num1;
        }

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){

            boolean check=true;
            String sql="Select codice from prodotto";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("Codice").equals(cod)){
                    check=false;
                    break;
                }
            }

            if(check==false){
                return num3;
            }

            String query="insert into Prodotto (Codice, Nome, Marca, Prezzo, Num_Pezzi) values" +
                      "(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,cod);
            statement.setString(2,nome);
            statement.setString(3,marca);
            statement.setDouble(4,prezzo);
            statement.setInt(5,num_pezzi);
            statement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return num4;
    }

    public static int InserisciFornitore(String piva, String nome, String luogo){
        int num1=1; // Messaggio errore piva
        int num2=2; // Messaggio errore nome
        int num3=3; // Messaggio errore luogo
        int num4=4; // Messaggio INSERIMENTO RIUSCITO
        int num5=5; // Messaggio errore piva già presente


        if(piva.length()==0 || piva.length()<=10 || piva.length()>=12){
            return num1;
        }

        if(nome.length()==0){
            return num2;
        }

        if(luogo.length()==0){
            return num3;
        }

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){

            boolean check=true;
            String sql="Select P_IVA from fornitore";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("P_IVA").equals(piva)){
                    check=false;
                    break;
                }
            }

            if(check==false){
                return num5;
            }

            String query="insert into Fornitore (P_IVA, Nome, Luogo) values" +
                    "(?,?,?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,piva);
            statement.setString(2,nome);
            statement.setString(3,luogo);
            statement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return num4;
    }

    public static int InserisciCliente(String cf, String nome, String cognome){
        int num1=1; // Messaggio errore cf
        int num2=2; // Messaggio errore nome
        int num3=3; // Messaggio errore cognome
        int num4=4; // Messaggio INSERIMENTO RIUSCITO
        int num5=5; // Messaggio errore cf già presente


        if(cf.length()==0 || cf.length()<=15 || cf.length()>=17){
            return num1;
        }

        if(nome.length()==0){
            return num2;
        }

        if(cognome.length()==0){
            return num3;
        }

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){

            boolean check=true;
            String sql="Select cf from cliente";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("CF").equals(cf)){
                    check=false;
                    break;
                }
            }

            if(check==false){
                return num5;
            }

            String query="insert into Cliente (CF, Nome, Cognome) values" +
                    "(?,?,?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,cf);
            statement.setString(2,nome);
            statement.setString(3,cognome);
            statement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return num4;
    }

    public static int InserisciOrdineFornitore(String prod, String cod, String fornitore, int pezzi){
        int num1=1; // Messaggio INSERIMENTO RIUSCITO

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){

            /*int n=0;
            String sql="Select Num_Pezzi from prodotto where codice ='"+cod+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                n=rs.getInt("Num_Pezzi");
            }*/

            String piva="";
            String query1="select p_iva from fornitore where nome='"+fornitore+"'";
            ResultSet rs1= stmt.executeQuery(query1);
            while (rs1.next()){
                piva=rs1.getString("p_iva");
            }

            double prezzo=1;
            String query2="select prezzo from prodotto where codice = '"+cod+"'";
            ResultSet rs2= stmt.executeQuery(query2);
            while (rs2.next()){
                prezzo=rs2.getDouble("Prezzo");
            }
            prezzo=prezzo*pezzi;

            String query3="INSERT INTO Ordine_Fornitore (Cod_Prod, P_iva_fornitore, prezzo, nr_pezzi)" +
                        "VALUES (?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(query3);
            statement.setString(1,cod);
            statement.setString(2,piva);
            statement.setDouble(3,prezzo);
            statement.setInt(4, pezzi);
            statement.executeUpdate();


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return num1;
    }

    public static int InserisciOrdineCliente(String prod, String cod, String cfcliente, int pezzi){
        int num1=1; // Messaggio INSERIMENTO RIUSCITO
        int num2=2; // Messaggio di errore per il numero dei pezzi

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){

            int n=0;
            String sql="Select Num_Pezzi from prodotto where codice ='"+cod+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                n=rs.getInt("Num_Pezzi");
            }

            if(pezzi<=n) {

                String query0="update prodotto set num_pezzi= num_pezzi-"+pezzi+" where codice ='"+cod+"'";
                int rs0= stmt.executeUpdate(query0);

                String query3 = "INSERT INTO Ordine_Cliente (Cod_Prod, Num_Pezzi, Cf_Cliente)" +
                        "VALUES (?,?,?)";
                PreparedStatement statement = con.prepareStatement(query3);
                statement.setString(1, cod);
                statement.setInt(2, pezzi);
                statement.setString(3, cfcliente);
                statement.executeUpdate();
            }
            else{
                return num2;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return num1;
    }

    public static String CercaProdottodb (String cod){
        // Se ritorna true --> prodotto cancellato
        // Se ritorna false --> prodotto non trovato

        boolean check=false;
        String ris=new String();
        ris="";

        try(Connection con=DriverManager.getConnection(connectionUrl); Statement stmt =con.createStatement();){
            String sql="Select codice from prodotto";
            ResultSet rs1= stmt.executeQuery(sql);
            while(rs1.next()){
                if(rs1.getString("Codice").equals(cod)){
                    check=true;
                    break;
                }
            }
            if(check==true) {
                int i=1;
                String query= "select * from prodotto where codice = '"+ cod+"'";
                ResultSet rs2= stmt.executeQuery(sql);
                while(rs2.next()){
                   //ris=rs2.getString("Nome");
                }
            }
            else{
                ris="no";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ris;
    }


    public static void main(String[] argv){
        //OkUser("Chiara", "0809");
        String val=CercaProdottodb("01");
        System.out.println(val);
    }
}
