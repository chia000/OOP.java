package Gestionale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {

    JMenu ordine, prodotti, clienti, fornitori;
    JMenuItem aggiungiP, cercaP, aggiungiF, aggiungiC, aggiungiOF,aggiungiOC;
    JMenuItem visualizzaP;
    JMenuItem visualizzaC;
    JMenuItem visualizzaF;
    JMenuItem visualizzaOF, visualizzaOC;

    JTextField cod, nome, prezzo, numpezzi, tcod;
    JTextField piva, nomeF, luogo;
    JTextField cf, nomeC, cognome;
    JTextField op_numpezzi;  // ORDINE PRODOTTO A FORNITORE

    JComboBox cbmarca;
    //JComboBox op_prezzo;   // ORDINE PRODOTTO A FORNITORE

    JButton delete, binserisci, bcercap, bchiudiInsProd, bchiudiCercaProd;
    JButton binserisciFor, bchiudiInsFor;
    JButton binserisciCliente, bchiudiInsCliente;
    JButton bchiudiOrdineFor, binserisciOrdineFor;
    JButton binserisciOrdineCliente, bchiudiOrdineCliente;
    JButton chiudiVis;

    JFrame frame;

    JPanel pannelloEsterno;
    JPanel pannelloEsternoCerca;
    JPanel pannelloEsternoInsForn;
    JPanel pannelloEsternoInsClinte;
    JPanel pannelloEsternoInsOrdineForn;
    JPanel pannelloEsternoInsOrdineCliente;

    public void HomeFrame(){
        frame= new JFrame("Home");
        frame.setLocation(0,0);

        frame.setPreferredSize(new Dimension(1500,690));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JMenuBar menubar =new JMenuBar();
        frame.setJMenuBar(menubar);
        prodotti= new JMenu("PRODOTTI");
        clienti= new JMenu("CLIENTI");
        fornitori= new JMenu("FORNITORI");
        ordine=new JMenu("ORDINE");
        menubar.add(prodotti);
        menubar.add(clienti);
        menubar.add(fornitori);
        menubar.add(ordine);

        visualizzaP= new JMenuItem("Visualizza tutto...");
        visualizzaP.addActionListener(this);
        aggiungiP= new JMenuItem("Nuovo prodotto");
        aggiungiP.addActionListener(this);
        cercaP=new JMenuItem("Cerca prodotto");
        cercaP.addActionListener(this);
        prodotti.add(visualizzaP);
        prodotti.addSeparator();
        prodotti.add(aggiungiP);
        prodotti.addSeparator();
        prodotti.add(cercaP);

        visualizzaC= new JMenuItem("Visualizza tutto...");
        visualizzaC.addActionListener(this);
        aggiungiC= new JMenuItem("Nuovo cliente");
        aggiungiC.addActionListener(this);
        clienti.add(visualizzaC);
        clienti.addSeparator();
        clienti.add(aggiungiC);

        visualizzaF= new JMenuItem("Visualizza tutto...");
        visualizzaF.addActionListener(this);
        aggiungiF= new JMenuItem("Nuovo fornitore");
        aggiungiF.addActionListener(this);
        fornitori.add(visualizzaF);
        fornitori.addSeparator();
        fornitori.add(aggiungiF);

        visualizzaOF= new JMenuItem("Visualizza tutti gli ordini ai fornitori...");
        visualizzaOF.addActionListener(this);
        visualizzaOC= new JMenuItem("Visualizza tutti gli ordini dei clienti...");
        visualizzaOC.addActionListener(this);
        aggiungiOF= new JMenuItem("Nuovo ordine per fornitore");
        aggiungiOF.addActionListener(this);
        aggiungiOC= new JMenuItem("Nuovo ordine per cliente");
        aggiungiOC.addActionListener(this);
        ordine.add(visualizzaOF);
        ordine.addSeparator();
        ordine.add(visualizzaOC);
        ordine.addSeparator();
        ordine.add(aggiungiOF);
        ordine.addSeparator();
        ordine.add(aggiungiOC);

        // Creazione Bottone Elimina dati, si attiva quando vuoi eliminare un oggetto.
        JPanel pannelloDelete=new JPanel();
        pannelloDelete.setLayout(new FlowLayout());
        delete=new JButton("ELIMINA");
        delete.setVisible(false);
        pannelloDelete.add(delete);
        pannelloDelete.setVisible(true);
        frame.getContentPane().add(pannelloDelete,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public void ProdottoInsFrame() {
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsterno =new JPanel();
        pannelloEsterno.setPreferredSize(new Dimension(400,400));
        pannelloEsterno.setLayout(new FlowLayout());

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice");
        cod=new JTextField();
        cod.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcod);
        pannello1.add(cod);
        pannelloEsterno.add(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nome=new JTextField();
        nome.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nome);
        pannelloEsterno.add(pannello2);

        String[] nomeFornitori=ActionsOnDB.elencoFornitori();
        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lmarca= new JLabel("Marca ");
        cbmarca=new JComboBox(nomeFornitori);
        cbmarca.setPreferredSize(new Dimension(250,25));
        pannello3.add(lmarca);
        pannello3.add(cbmarca);
        pannelloEsterno.add(pannello3);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lprezzo= new JLabel("Prezzo");
        prezzo=new JTextField();
        prezzo.setPreferredSize(new Dimension(250,25));
        pannello4.add(lprezzo);
        pannello4.add(prezzo);
        pannelloEsterno.add(pannello4);

        JPanel pannello5 =new JPanel();
        pannello5.setLayout(new FlowLayout());
        JLabel lpezzi= new JLabel("Nr.° pezzi");
        numpezzi=new JTextField();
        numpezzi.setPreferredSize(new Dimension(250,25));
        pannello5.add(lpezzi);
        pannello5.add(numpezzi);
        pannelloEsterno.add(pannello5);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisci= new JButton("INSERISCI");
        binserisci.setPreferredSize(new Dimension(100,50));
        binserisci.addActionListener(this);
        pannello6.add(binserisci);
        //frame.getContentPane().add(pannello6, BorderLayout.CENTER);
        pannelloEsterno.add(pannello6);

        bchiudiInsProd=new JButton("CHIUDI");
        pannelloEsterno.add(bchiudiInsProd);
        bchiudiInsProd.addActionListener(this);

        frame.getContentPane().add(pannelloEsterno, BorderLayout.WEST);
        frame.setVisible(true);

    }

    public void FornitoreInsFrame() {
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsternoInsForn =new JPanel();
        pannelloEsternoInsForn.setPreferredSize(new Dimension(400,400));
        pannelloEsternoInsForn.setLayout(new FlowLayout());

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lpiva= new JLabel("Partita IVA");
        piva=new JTextField();
        piva.setPreferredSize(new Dimension(250,25));
        pannello1.add(lpiva);
        pannello1.add(piva);
        pannelloEsternoInsForn.add(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nomeF=new JTextField();
        nomeF.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeF);
        pannelloEsternoInsForn.add(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lluogo= new JLabel("Luogo ");
        luogo=new JTextField();
        luogo.setPreferredSize(new Dimension(250,25));
        pannello3.add(lluogo);
        pannello3.add(luogo);
        pannelloEsternoInsForn.add(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciFor= new JButton("INSERISCI");
        binserisciFor.setPreferredSize(new Dimension(100,50));
        binserisciFor.addActionListener(this);
        pannello6.add(binserisciFor);
        pannelloEsternoInsForn.add(pannello6);

        bchiudiInsFor=new JButton("CHIUDI");
        pannelloEsternoInsForn.add(bchiudiInsFor);
        bchiudiInsFor.addActionListener(this);

        frame.getContentPane().add(pannelloEsternoInsForn, BorderLayout.WEST);
        frame.setVisible(true);

    }

    public void ClienteInsFrame(){
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsternoInsClinte =new JPanel();
        pannelloEsternoInsClinte.setPreferredSize(new Dimension(400,400));
        pannelloEsternoInsClinte.setLayout(new FlowLayout());

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcf= new JLabel("Codice fiscale");
        cf=new JTextField();
        cf.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcf);
        pannello1.add(cf);
        pannelloEsternoInsClinte.add(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nomeC=new JTextField();
        nomeC.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeC);
        pannelloEsternoInsClinte.add(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lcognome= new JLabel("Cognome");
        cognome=new JTextField();
        cognome.setPreferredSize(new Dimension(250,25));
        pannello3.add(lcognome);
        pannello3.add(cognome);
        pannelloEsternoInsClinte.add(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciCliente= new JButton("INSERISCI");
        binserisciCliente.setPreferredSize(new Dimension(100,50));
        binserisciCliente.addActionListener(this);
        pannello6.add(binserisciCliente);
        pannelloEsternoInsClinte.add(pannello6);

        bchiudiInsCliente=new JButton("CHIUDI");
        pannelloEsternoInsClinte.add(bchiudiInsCliente);
        bchiudiInsCliente.addActionListener(this);

        frame.getContentPane().add(pannelloEsternoInsClinte, BorderLayout.WEST);
        frame.setVisible(true);
    }

    String[] nomiProdotto =ActionsOnDB.elencoProdotti();
    JComboBox of_nome =new JComboBox(nomiProdotto);
    String[] codProdotti={"Seleziona..."};
    JComboBox of_cod =new JComboBox(codProdotti);

    String[] nomiFornitori = ActionsOnDB.elencoFornitori();
    JComboBox piva_f=new JComboBox(nomiFornitori);

    public void OrdineForInsFrame() {
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsternoInsOrdineForn =new JPanel();
        pannelloEsternoInsOrdineForn.setPreferredSize(new Dimension(400,400));
        pannelloEsternoInsOrdineForn.setLayout(new FlowLayout());

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        of_nome.setPreferredSize(new Dimension(250,25));
        pannello0.add(lnome);
        pannello0.add(of_nome);
        of_nome.addActionListener(this);
        pannelloEsternoInsOrdineForn.add(pannello0);

        String[] codProdotto ={"Seleziona..."};
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice prodotto");
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineForn.add(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lfor= new JLabel("Fornitore ");
        piva_f.setPreferredSize(new Dimension(250,25));
        pannello2.add(lfor);
        pannello2.add(piva_f);
        pannelloEsternoInsOrdineForn.add(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        op_numpezzi=new JTextField();
        op_numpezzi.setPreferredSize(new Dimension(250,25));
        pannello3.add(lnumpezzi);
        pannello3.add(op_numpezzi);
        pannelloEsternoInsOrdineForn.add(pannello3);

        /*double prezzi=ActionsOnDB.CalcolaPrezzo((String)op_cod.getSelectedItem(), Integer.parseInt(op_numpezzi.getText()));
        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lprezzo= new JLabel("Prezzo Totale ");
        op_prezzo=new JComboBox(prezzi);
        op_prezzo.setPreferredSize(new Dimension(250,25));
        pannello4.add(lprezzo);
        pannello4.add(op_prezzo);
        pannelloEsternoInsOrdineForn.add(pannello4);*/

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciOrdineFor= new JButton("INSERISCI");
        binserisciOrdineFor.setPreferredSize(new Dimension(100,50));
        binserisciOrdineFor.addActionListener(this);
        pannello6.add(binserisciOrdineFor);
        pannelloEsternoInsOrdineForn.add(pannello6);

        bchiudiOrdineFor=new JButton("CHIUDI");
        pannelloEsternoInsOrdineForn.add(bchiudiOrdineFor);
        bchiudiOrdineFor.addActionListener(this);

        frame.getContentPane().add(pannelloEsternoInsOrdineForn, BorderLayout.WEST);
        frame.setVisible(true);

    }

    //JComboBox oc_nome =new JComboBox(nomiProdotto);
    //JComboBox oc_cod =new JComboBox(codProdotti);
    String[] cfClienti=ActionsOnDB.elencoClienti();
    JComboBox oc_cfClienti=new JComboBox(cfClienti);
    JComboBox oc_nomiClienti= new JComboBox();
    JTextField oc_numpezzi;

    public void OrdineClienteInsFrame() {
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsternoInsOrdineCliente =new JPanel();
        pannelloEsternoInsOrdineCliente.setPreferredSize(new Dimension(400,400));
        pannelloEsternoInsOrdineCliente.setLayout(new FlowLayout());

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        of_nome.setPreferredSize(new Dimension(250,25));
        pannello0.add(lnome);
        pannello0.add(of_nome);
        of_nome.addActionListener(this);
        pannelloEsternoInsOrdineCliente.add(pannello0);

        String[] codProdotto ={"Seleziona..."};
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice prodotto");
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineCliente.add(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lcliet= new JLabel("CF cliente ");
        oc_cfClienti.setPreferredSize(new Dimension(250,25));
        oc_cfClienti.addActionListener(this);
        pannello2.add(lcliet);
        pannello2.add(oc_cfClienti);
        pannelloEsternoInsOrdineCliente.add(pannello2);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lnclient= new JLabel("Cliente ");
        oc_nomiClienti.setPreferredSize(new Dimension(250,25));
        pannello4.add(lnclient);
        pannello4.add(oc_nomiClienti);
        pannelloEsternoInsOrdineCliente.add(pannello4);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        oc_numpezzi=new JTextField();
        oc_numpezzi.setPreferredSize(new Dimension(250,25));
        pannello3.add(lnumpezzi);
        pannello3.add(oc_numpezzi);
        pannelloEsternoInsOrdineCliente.add(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciOrdineCliente= new JButton("INSERISCI");
        binserisciOrdineCliente.setPreferredSize(new Dimension(100,50));
        binserisciOrdineCliente.addActionListener(this);
        pannello6.add(binserisciOrdineCliente);
        pannelloEsternoInsOrdineCliente.add(pannello6);

        bchiudiOrdineCliente=new JButton("CHIUDI");
        pannelloEsternoInsOrdineCliente.add(bchiudiOrdineCliente);
        bchiudiOrdineCliente.addActionListener(this);

        frame.getContentPane().add(pannelloEsternoInsOrdineCliente, BorderLayout.WEST);
        frame.setVisible(true);

    }

    public void BinsProdottoDB(){

        if(cod.getText().length()==0 && nome.getText().length()==0 && cbmarca.getSelectedItem()=="Seleziona..."
        && prezzo.getText().length()==0 && numpezzi.getText().length()==0){
            JFrame f0=new JFrame("ATTENZIONE");
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.");
        }
        else {
            if (prezzo.getText().length() == 0) {
                JFrame f7 = new JFrame("ATTENZIONE");
                JOptionPane.showMessageDialog(f7, "ERRORE: manca il prezzo");
            }

            if (numpezzi.getText().length() == 0) {
                JFrame f2 = new JFrame("ATTENZIONE");
                JOptionPane.showMessageDialog(f2, "ERRORE: inserire il NUMERO dei PEZZI.");
            }

            int num = ActionsOnDB.InserisciProdotto(cod.getText(), nome.getText(), (String) cbmarca.getSelectedItem(),
                    Double.parseDouble(prezzo.getText()), Integer.parseInt(numpezzi.getText()));

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f1, "ERRORE: selezionare una MARCA.");
                    break;
                case 3:
                    JFrame f3 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f3, "ERRORE: il CODICE inserito è già presente.");
                    cod.setText("");
                    break;
                case 4:
                    JFrame f4 = new JFrame("ACCESSO");
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!");
                    Prodotto pr = new Prodotto();
                    pr.setCodice(cod.getText());
                    pr.setNome(nome.getText());
                    String tmp = (String) cbmarca.getSelectedItem();
                    pr.setMarca(tmp);
                    pr.setPrezzo(Double.parseDouble(prezzo.getText()));
                    pr.setNum_pezzi(Integer.parseInt(numpezzi.getText()));
                    cod.setText("");
                    nome.setText("");
                    cbmarca.setSelectedIndex(0);
                    prezzo.setText("");
                    numpezzi.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f5, "ERRORE: inserire il NOME del prodotto.");
                    break;
                case 6:
                    JFrame f6 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f6, "ERRORE: il codice non è stato inserito.");
                    break;
            }
        }
    }

    public void BinsFornitoreDB(){
        if(piva.getText().length()==0 && nomeF.getText().length()==0 && luogo.getText().length()==0){
            JFrame f0=new JFrame("ATTENZIONE");
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.");
        }
        else {

            int num = ActionsOnDB.InserisciFornitore(piva.getText(), nomeF.getText(), luogo.getText());

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f1, "ERRORE: inserimento errato della Partita Iva");
                    piva.setText("");
                    break;
                case 2:
                    JFrame f2 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f2, "ERRORE: inserire il nome del fornitore.");
                    break;
                case 3:
                    JFrame f3 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f3, "ERRORE: inserire il luogo");
                    break;
                case 4:
                    JFrame f4 = new JFrame("ACCESSO");
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!");
                    Fornitore fr = new Fornitore();
                    fr.setP_iva(piva.getText());
                    fr.setNome(nomeF.getText());
                    fr.setLuogo(luogo.getText());
                    piva.setText("");
                    nomeF.setText("");
                    luogo.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f5, "ERRORE: Partita Iva già presente");
                    piva.setText("");
                    break;
            }
        }
    }

    public void BinsClienteDB(){
        if(cf.getText().length()==0 && nomeC.getText().length()==0 && cognome.getText().length()==0){
            JFrame f0=new JFrame("ATTENZIONE");
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.");
        }
        else {

            int num = ActionsOnDB.InserisciCliente(cf.getText(), nomeC.getText(), cognome.getText());

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f1, "ERRORE: inserimento errato del Codice Fiscale");
                    cf.setText("");
                    break;
                case 2:
                    JFrame f2 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f2, "ERRORE: inserire il nome del cliente.");
                    break;
                case 3:
                    JFrame f3 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f3, "ERRORE: inserire il cognome");
                    break;
                case 4:
                    JFrame f4 = new JFrame("ACCESSO");
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!");
                    Cliente cl = new Cliente();
                    cl.setCf(cf.getText());
                    cl.setNome(nomeC.getText());
                    cl.setCognome(cognome.getText());
                    cf.setText("");
                    nomeC.setText("");
                    cognome.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f5, "ERRORE: Codice Fiscale già presente");
                    cf.setText("");
                    break;
            }
        }
    }

    public void BinsNuovoOrdineFornitoreDB(){
        if(of_nome.getSelectedItem()=="Seleziona..." && of_cod.getSelectedItem()=="Seleziona..." && (piva_f.getSelectedItem()=="" ||piva_f.getSelectedItem()=="Seleziona...") &&
                op_numpezzi.getText().length()==0){
            JFrame f0=new JFrame("ATTENZIONE");
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.");
            of_nome.setSelectedIndex(0);
            of_cod.setSelectedIndex(0);
            piva_f.setSelectedIndex(0);
            op_numpezzi.setText("");
        }
        else {

            if(op_numpezzi.getText().length()==0){
                JFrame f1=new JFrame("ATTENZIONE");
                JOptionPane.showMessageDialog(f1,"ERRORE: inserire il numero dei pezzi da ordinare.");
            }

            int num = ActionsOnDB.InserisciOrdineFornitore((String) of_nome.getSelectedItem(), (String) of_cod.getSelectedItem(),
                    (String) piva_f.getSelectedItem(), Integer.parseInt(op_numpezzi.getText()));

            if(num==1) {
                JFrame f4 = new JFrame("ACCESSO");
                JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!");
                OrdineFornitore ord_for= new OrdineFornitore();
                ord_for.setNomeProdotto((String) of_nome.getSelectedItem());
                ord_for.setCodice((String) of_cod.getSelectedItem());
                ord_for.setFornitore((String) piva_f.getSelectedItem());
                ord_for.setNum_pezzi(Integer.parseInt(op_numpezzi.getText()));

                of_nome.setSelectedIndex(0);
                of_cod.setSelectedIndex(0);
                piva_f.setSelectedIndex(0);
                op_numpezzi.setText("");

            }
            else{
                JFrame f1 = new JFrame("ATTENZIONE");
                JOptionPane.showMessageDialog(f1, "SI E' VERIFICATO UN ERRORE");
            }
        }
    }

    public void BinsNuovoOrdineClienteDB(){
        if(of_nome.getSelectedItem()=="Seleziona..." && of_cod.getSelectedItem()=="Seleziona..." && (oc_cfClienti.getSelectedItem()=="" ||oc_cfClienti.getSelectedItem()=="Seleziona...") &&
                (oc_nomiClienti.getSelectedItem()=="" ||oc_nomiClienti.getSelectedItem()=="Seleziona...") &&
                oc_numpezzi.getText().length()==0){
            JFrame f0=new JFrame("ATTENZIONE");
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.");
            of_nome.setSelectedIndex(0);
            of_cod.setSelectedIndex(0);
            oc_cfClienti.setSelectedIndex(0);
            oc_nomiClienti.setSelectedIndex(0);
            oc_numpezzi.setText("");
        }
        else {

            if(oc_numpezzi.getText().length()==0){
                JFrame f1=new JFrame("ATTENZIONE");
                JOptionPane.showMessageDialog(f1,"ERRORE: inserire il numero dei pezzi da ordinare.");
            }

            int num = ActionsOnDB.InserisciOrdineCliente((String) of_nome.getSelectedItem(), (String) of_cod.getSelectedItem(),
                    (String) oc_cfClienti.getSelectedItem(), Integer.parseInt(oc_numpezzi.getText()));

            switch(num) {
                case 1:
                    JFrame f4 = new JFrame("ACCESSO");
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!");
                    OrdineCliente ord_client= new OrdineCliente();
                    ord_client.setNomeProdotto((String) of_nome.getSelectedItem());
                    ord_client.setCodice((String) of_cod.getSelectedItem());
                    ord_client.setCf((String) oc_cfClienti.getSelectedItem());
                    ord_client.setNum_pezzi(Integer.parseInt(oc_numpezzi.getText()));

                    of_nome.setSelectedIndex(0);
                    of_cod.setSelectedIndex(0);
                    oc_cfClienti.setSelectedIndex(0);
                    oc_nomiClienti.setSelectedIndex(0);
                    oc_numpezzi.setText("");
                    break;

                case 2:
                    JFrame f2 = new JFrame("ATTENZIONE");
                    JOptionPane.showMessageDialog(f2, "ERRORE: non ci sono abbastanza pezzi il magazzino del prodotto desiderato");
                    break;

            }
        }
    }

    public void Visualizza(String testo, String elenco){
        JLabel labelProd= new JLabel(testo);
        JEditorPane editor1= new JEditorPane();
        editor1.setPreferredSize(new Dimension(25,25));
        editor1.setText(elenco);
        editor1.setEditable(false);
        chiudiVis=new JButton("CHIUDI");
        chiudiVis.setPreferredSize(new Dimension(70,50));
        chiudiVis.addActionListener(this);

        frame.getContentPane().add(labelProd, BorderLayout.NORTH);
        frame.getContentPane().add(editor1, BorderLayout.CENTER);
        frame.getContentPane().add(chiudiVis, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void VisualizzaProdotti(){

        Visualizza("Elenco di tutti i prodotti presenti in magazzino.", ActionsOnDB.visualizzaProdotti());
    }

    public void VisualizzaClienti(){

        Visualizza("Anagrafica di tutti i clienti registrati:", ActionsOnDB.visualizzaCliente());
    }

    public void VisualizzaFornitore(){

        Visualizza("Anagrafica di tutti i fornitori registrati:", ActionsOnDB.visualizzaFornitore());
    }

    public void VisualizzaOrdineFornitore(){

        Visualizza("Elenco di tutti gli ordini per i fornitori.",ActionsOnDB.visualizzaOrdiniFornitore() );
    }

    public void VisualizzaOrdiniClienti(){

        Visualizza("Elenco di tutti gli ordini dei clienti.", ActionsOnDB.visualizzaOrdiniClienti());

    }

    public void CercaProdotto(){
        frame.setVisible(false);
        pannelloEsternoCerca=new JPanel();
        pannelloEsternoCerca.setPreferredSize(new Dimension(400,400));
        pannelloEsternoCerca.setLayout(new FlowLayout());

        JPanel pannello1=new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod=new JLabel("Codice");
        tcod=new JTextField();
        bcercap=new JButton("CERCA");
        bcercap.addActionListener(this);
        tcod.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcod);
        pannello1.add(tcod);
        pannello1.add(bcercap);
        pannelloEsternoCerca.add(pannello1);

        /*JPanel pannello2=new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome=new JLabel("Nome");
        JTextField tnome=new JTextField();
        tnome.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(tnome);
        pannelloEsternoCerca.add(pannello2);*/

        bchiudiCercaProd=new JButton("CHIUDI");
        pannelloEsternoCerca.add(bchiudiCercaProd);
        bchiudiCercaProd.addActionListener(this);
        delete.setVisible(true);

        frame.getContentPane().add(pannelloEsternoCerca, BorderLayout.WEST);
        frame.setVisible(true);


    }

    public void Chiudi(JPanel p){
        p.setVisible(false);
    }

    public void ChiudiInsProdotto(){
        Chiudi(pannelloEsterno);
    }

    public void ChiudiInsFornitore(){
        Chiudi(pannelloEsternoInsForn);
    }

    public void ChiudiInsCliente(){
        Chiudi(pannelloEsternoInsClinte);
    }

    public void ChiudiCercaProdotto(){
        Chiudi(pannelloEsternoCerca);
        delete.setVisible(false);
    }

    public void ChiudiOrdineFornitore(){
        Chiudi(pannelloEsternoInsOrdineForn);
    }

    public void ChiudiOrdineCliente(){
        Chiudi(pannelloEsternoInsOrdineCliente);
    }

    public void DeleteProd(){
        /*System.out.println("ok");
        if(tcod.getText().length()==0){
            JOptionPane.showMessageDialog(new JFrame(),"ERRORE: non è stato inserito nessun dato nella barra di ricerca. RIPROVA.");
        }

        boolean val=ActionsOnDB.CancellaProdotto(tcod.getText());
        if(val==true){
            JOptionPane.showMessageDialog(new JFrame(),"La cancellazione del prodotto con codice: "+ tcod.getText()+
                    " è avvenuta con SUCCESSO.");
            tcod.setText("");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Non è stato trovato nessun articolo con il seguente codice: "+ tcod.getText());
            tcod.setText("");
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // INTERFACCIA AGGIUNGI PRODOTTO
        if(e.getSource()==aggiungiP){
            ProdottoInsFrame();
        }
        //BOTTONE BINSERISCI --> INSERISCI PRODOTTO IN DB
        if(e.getSource()==binserisci){
            BinsProdottoDB();
        }
        // BOTTONE CERCA PRODOTTO
        if(e.getSource()==cercaP){
            CercaProdotto();
        }
        // BOTTONE CANCELLA PRODOTTO
        if(e.getSource()==delete){
            DeleteProd();
        }
        // BOTTONE CHIUDI IN INSERIMENTO PRODOTTO (per ora)
        if(e.getSource()==bchiudiInsProd){
            ChiudiInsProdotto();
            bchiudiInsProd.setVisible(false);
        }
        // BOTTONE CHIUDI CERCA PRODOTTO
        if(e.getSource()==bchiudiCercaProd){
            ChiudiCercaProdotto();
        }
        // AGGIUNGI FORNITORI JMENUITEM
        if(e.getSource()==aggiungiF){
            FornitoreInsFrame();
        }
        // BOTTONE INSERISCI NUOVO FORNITORE
        if(e.getSource()==binserisciFor){
            BinsFornitoreDB();
        }
        // BOTTONE CHIUDI INSERIMENTO FORNITORE
        if(e.getSource()==bchiudiInsFor){
            ChiudiInsFornitore();
        }
        // AGGIUNGI NUOVO CLIENTE JMENUITEM
        if(e.getSource()==aggiungiC){
            ClienteInsFrame();
        }
        // BOTTONE INSERIMENTO NUOVO CLIENTE
        if(e.getSource()==binserisciCliente){
            BinsClienteDB();
        }
        // BOTTONE CHIUDI INSERIMENTO CLIENTE
        if(e.getSource()==bchiudiInsCliente){
            ChiudiInsCliente();
        }
        // AGGIUNGI ORDINE PER FORNITORE
        if(e.getSource()==aggiungiOF){
            OrdineForInsFrame();
        }
        // BOTTONE TROVA CODICE DATO IL PRODOTTO IN NUOVO ORDINE PER FORNITORE
        if(e.getSource()==of_nome){
            of_cod.removeAllItems();
            String[] elencoCodiciProd= ActionsOnDB.elencoCodProdottoSelezionato((String) of_nome.getSelectedItem());
            int i=ActionsOnDB.Conta((String) of_nome.getSelectedItem());
            int c=0;
            while(c<=i){
                of_cod.addItem(elencoCodiciProd[c]);
                ++c;
            }
        }
        // BOTTONE TROVA FORNITORE DATO CODICE PRODOTTO IN NUOVO ORDINE PER FORNITORE
        if(e.getSource()==of_cod){
            piva_f.removeAllItems();
            String marca= ActionsOnDB.elencoFornitoriProdottoSelezionato((String) of_cod.getSelectedItem());
            piva_f.addItem(marca);
        }
        // BOTTONE CHIUDI FINESTRA ORDINE PER FORNITORI
        if(e.getSource()==bchiudiOrdineFor){
            ChiudiOrdineFornitore();
        }
        // BOTTONE INSERISCI NUOVO ORDINE PER FORNITORE
        if(e.getSource()==binserisciOrdineFor){
            BinsNuovoOrdineFornitoreDB();
        }
        // BOTTONE INSERISCI NUOVO ORDINE PER CLIENTE
        if(e.getSource()==aggiungiOC){
            OrdineClienteInsFrame();
        }
        // BOTTONE CHIUDI INSERIMENTO NUOVO ORDINE PER CLIENTE
        if(e.getSource()==bchiudiOrdineCliente){
            ChiudiOrdineCliente();
        }
        // BOTTONE TROVA NOME E COGNOME CLIENTE DATO CF IN COMBOBOX IN ORDINE PER CLIENTE
        if(e.getSource()==oc_cfClienti){
            oc_nomiClienti.removeAllItems();
            oc_nomiClienti.addItem(ActionsOnDB.trovaNomeCognome((String) oc_cfClienti.getSelectedItem()));
        }
        // BOTTONE INSERISCI NUOVO ORDINE PER CLIENTE
        if(e.getSource()==binserisciOrdineCliente){
            BinsNuovoOrdineClienteDB();
        }
        // BOTTONE VISUALIZZA TUTTI I PRODOTTI DA TENDINA
        if(e.getSource()==visualizzaP){
            VisualizzaProdotti();
        }
        // BOTTONE VISUALIZZA TUTTI I CLIENTI DA TENDINA
        if(e.getSource()==visualizzaC){
            VisualizzaClienti();
        }
        // BOTTONE VISUALIZZA TUTTI I FORNITORI DA TENDINA
        if(e.getSource()==visualizzaF){
            VisualizzaFornitore();
        }
        // BOTTONE VISUALIZZA TUTTI GLI ORDINI PER I FORNITORI DA TENDINA
        if(e.getSource()==visualizzaOF){
            VisualizzaOrdineFornitore();
        }
        // BOTTONE VISUALIZZA TUTTI GLI ORDINI DEI CLIENTI DA TENDINA
        if(e.getSource()==visualizzaOC){
            VisualizzaOrdiniClienti();
        }

    }

    public static void main(String[] argv){
            Home hm= new Home();
            hm.HomeFrame();
    }
}