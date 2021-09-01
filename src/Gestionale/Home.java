package Gestionale;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {

    JLabel etichettaIniz;
    JLabel labelProd;
    JEditorPane editor1;

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
    JPanel pannelloVis;


    public void HomeFrame(){
        frame= new JFrame("GestioniaMO"); //pannello principale (nome)
        frame.setLocation(300,100);

        Image icona = Toolkit.getDefaultToolkit().createImage("iconaProgetto.jpg");
        frame.setIconImage(icona);

        frame.getContentPane().setBackground(new Color(173,196,255));
        //frame.getContentPane().setBackground(Color.pink);


        frame.setPreferredSize(new Dimension(1000,500));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JMenuBar menubar =new JMenuBar(); //barra di menù
        frame.setJMenuBar(menubar);
        prodotti= new JMenu("PRODOTTI"); // nomi menù a tendina
        prodotti.setFont(new Font("Gabriola", Font.CENTER_BASELINE,18));
        clienti= new JMenu("CLIENTI");
        clienti.setFont(new Font("Gabriola", Font.CENTER_BASELINE,18));
        fornitori= new JMenu("FORNITORI");
        fornitori.setFont(new Font("Gabriola", Font.CENTER_BASELINE,18));
        ordine=new JMenu("ORDINE");
        ordine.setFont(new Font("Gabriola", Font.CENTER_BASELINE,18));
        menubar.add(prodotti);
        menubar.add(clienti);
        menubar.add(fornitori);
        menubar.add(ordine);

        //Prodotti
        visualizzaP= new JMenuItem("Visualizza tutto..."); //Nomi delle selezioni menù a tendina
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

        //Clienti
        visualizzaC= new JMenuItem("Visualizza tutto...");
        visualizzaC.addActionListener(this);
        aggiungiC= new JMenuItem("Nuovo cliente");
        aggiungiC.addActionListener(this);
        clienti.add(visualizzaC);
        clienti.addSeparator();
        clienti.add(aggiungiC);

        //Fornitori
        visualizzaF= new JMenuItem("Visualizza tutto...");
        visualizzaF.addActionListener(this);
        aggiungiF= new JMenuItem("Nuovo fornitore");
        aggiungiF.addActionListener(this);
        fornitori.add(visualizzaF);
        fornitori.addSeparator();
        fornitori.add(aggiungiF);

        //Ordini fornitori e Ordini clienti
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

    public void CambiaColore(JPanel p){
        p.setBackground(new Color(173,196,255));
    }

    public void ProdottoInsFrame() {
        /*
         * Creo un pannello esterno che incollo al frame iniziale;
         * sul pannello esterno applico i pannelli su cui ci sono altri componenti;
         * mi ricordo di rendere il frame visibile (=true).
         * */

        pannelloEsterno =new JPanel(); //pannello grande
        pannelloEsterno.setPreferredSize(new Dimension(400,400));
        pannelloEsterno.setLayout(new FlowLayout()); //disposizione in colonna con flowlayout
        CambiaColore(pannelloEsterno);

        etichettaIniz=new JLabel("      Form per inserimento nuovo prodotto.");
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        //pannello piccolo con label e textfield del CODICE
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice");
        cod=new JTextField();
        cod.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcod);
        pannello1.add(cod);
        CambiaColore(pannello1);
        pannelloEsterno.add(pannello1);

        //pannello piccolo con label e textfield del NOME
        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nome=new JTextField();
        nome.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nome);
        CambiaColore(pannello2);
        pannelloEsterno.add(pannello2);

        //pannello piccolo con label e combobox(menù a tendina) della MARCA
        String[] nomeFornitori=ActionsOnDB.elencoFornitori();
        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lmarca= new JLabel("Marca ");
        cbmarca=new JComboBox(nomeFornitori);
        cbmarca.setPreferredSize(new Dimension(250,25));
        pannello3.add(lmarca);
        pannello3.add(cbmarca);
        CambiaColore(pannello3);
        pannelloEsterno.add(pannello3);

        //pannello piccolo con label e textfield del PREZZO
        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lprezzo= new JLabel("Prezzo");
        prezzo=new JTextField();
        prezzo.setPreferredSize(new Dimension(250,25));
        pannello4.add(lprezzo);
        pannello4.add(prezzo);
        CambiaColore(pannello4);
        pannelloEsterno.add(pannello4);

        //pannello piccolo con label e textfield del N PEZZI
        JPanel pannello5 =new JPanel();
        pannello5.setLayout(new FlowLayout());
        JLabel lpezzi= new JLabel("Nr.° pezzi");
        numpezzi=new JTextField();
        numpezzi.setPreferredSize(new Dimension(250,25));
        pannello5.add(lpezzi);
        pannello5.add(numpezzi);
        CambiaColore(pannello5);
        pannelloEsterno.add(pannello5);

        //pannello piccolo con INSERISCI
        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisci= new JButton("INSERISCI");
        binserisci.setPreferredSize(new Dimension(100,50));
        binserisci.addActionListener(this); //evento sul tasto INSERISCI
        pannello6.add(binserisci);
        CambiaColore(pannello6);
        pannelloEsterno.add(pannello6);

        //bottone direttamente su pannello grande CHIUDI (va bene perchè settato come flowlayout e non border)
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
        CambiaColore(pannelloEsternoInsForn);

        etichettaIniz=new JLabel("      Form per inserimento nuovo fornitore.");
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lpiva= new JLabel("Partita IVA");
        piva=new JTextField();
        piva.setPreferredSize(new Dimension(250,25));
        pannello1.add(lpiva);
        pannello1.add(piva);
        pannelloEsternoInsForn.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nomeF=new JTextField();
        nomeF.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeF);
        pannelloEsternoInsForn.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lluogo= new JLabel("Luogo ");
        luogo=new JTextField();
        luogo.setPreferredSize(new Dimension(250,25));
        pannello3.add(lluogo);
        pannello3.add(luogo);
        pannelloEsternoInsForn.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciFor= new JButton("INSERISCI");
        binserisciFor.setPreferredSize(new Dimension(100,50));
        binserisciFor.addActionListener(this);
        pannello6.add(binserisciFor);
        pannelloEsternoInsForn.add(pannello6);
        CambiaColore(pannello6);

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
        CambiaColore(pannelloEsternoInsClinte);

        etichettaIniz=new JLabel("      Form per inserimento nuovo cliente.");
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcf= new JLabel("Codice fiscale");
        cf=new JTextField();
        cf.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcf);
        pannello1.add(cf);
        pannelloEsternoInsClinte.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        nomeC=new JTextField();
        nomeC.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeC);
        pannelloEsternoInsClinte.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lcognome= new JLabel("Cognome");
        cognome=new JTextField();
        cognome.setPreferredSize(new Dimension(250,25));
        pannello3.add(lcognome);
        pannello3.add(cognome);
        pannelloEsternoInsClinte.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciCliente= new JButton("INSERISCI");
        binserisciCliente.setPreferredSize(new Dimension(100,50));
        binserisciCliente.addActionListener(this);
        pannello6.add(binserisciCliente);
        pannelloEsternoInsClinte.add(pannello6);
        CambiaColore(pannello6);

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
        CambiaColore(pannelloEsternoInsOrdineForn);

        etichettaIniz=new JLabel("      Form per inserimento nuovo ordine per fornitore.");
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        of_nome.setPreferredSize(new Dimension(250,25));
        pannello0.add(lnome);
        pannello0.add(of_nome);
        of_nome.addActionListener(this);
        pannelloEsternoInsOrdineForn.add(pannello0);
        CambiaColore(pannello0);

        //String[] codProdotto ={"Seleziona..."};
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice prodotto");
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineForn.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lfor= new JLabel("Fornitore ");
        piva_f.setPreferredSize(new Dimension(250,25));
        pannello2.add(lfor);
        pannello2.add(piva_f);
        pannelloEsternoInsOrdineForn.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        op_numpezzi=new JTextField();
        op_numpezzi.setPreferredSize(new Dimension(250,25));
        pannello3.add(lnumpezzi);
        pannello3.add(op_numpezzi);
        pannelloEsternoInsOrdineForn.add(pannello3);
        CambiaColore(pannello3);

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
        CambiaColore(pannello6);

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
        CambiaColore(pannelloEsternoInsOrdineCliente);

        etichettaIniz=new JLabel("      Form per inserimento nuovo ordine per cliente.");
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        of_nome.setPreferredSize(new Dimension(250,25));
        pannello0.add(lnome);
        pannello0.add(of_nome);
        of_nome.addActionListener(this);
        pannelloEsternoInsOrdineCliente.add(pannello0);
        CambiaColore(pannello0);

        //String[] codProdotto ={"Seleziona..."};
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice prodotto");
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineCliente.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lcliet= new JLabel("CF cliente ");
        oc_cfClienti.setPreferredSize(new Dimension(250,25));
        oc_cfClienti.addActionListener(this);
        pannello2.add(lcliet);
        pannello2.add(oc_cfClienti);
        pannelloEsternoInsOrdineCliente.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lnclient= new JLabel("Cliente ");
        oc_nomiClienti.setPreferredSize(new Dimension(250,25));
        pannello4.add(lnclient);
        pannello4.add(oc_nomiClienti);
        pannelloEsternoInsOrdineCliente.add(pannello4);
        CambiaColore(pannello4);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        oc_numpezzi=new JTextField();
        oc_numpezzi.setPreferredSize(new Dimension(250,25));
        pannello3.add(lnumpezzi);
        pannello3.add(oc_numpezzi);
        pannelloEsternoInsOrdineCliente.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciOrdineCliente= new JButton("INSERISCI");
        binserisciOrdineCliente.setPreferredSize(new Dimension(100,50));
        binserisciOrdineCliente.addActionListener(this);
        pannello6.add(binserisciOrdineCliente);
        pannelloEsternoInsOrdineCliente.add(pannello6);
        CambiaColore(pannello6);

        bchiudiOrdineCliente=new JButton("CHIUDI");
        pannelloEsternoInsOrdineCliente.add(bchiudiOrdineCliente);
        bchiudiOrdineCliente.addActionListener(this);

        frame.getContentPane().add(pannelloEsternoInsOrdineCliente, BorderLayout.WEST);
        frame.setVisible(true);

    }

    public void BinsProdottoDB(){

        if(cod.getText().length()==0 && nome.getText().length()==0 && cbmarca.getSelectedItem()=="Seleziona..."
        && prezzo.getText().length()==0 && numpezzi.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
            // MessageType = 0 --> icona messaggio errore (fino a 5 possibilità: da 0 a 4)
        }
        else {
            //controlli su textfield se vuote
            if (prezzo.getText().length() == 0) {
                JFrame f7 = new JFrame();
                JOptionPane.showMessageDialog(f7, "ERRORE: manca il prezzo","ATTENZIONE",0);
            }

            if (numpezzi.getText().length() == 0) {
                JFrame f2 = new JFrame();
                JOptionPane.showMessageDialog(f2, "ERRORE: inserire il NUMERO dei PEZZI.","ATTENZIONE",0);
            }
            //num è risultato di inserimento nel DB, double.parsedouble è per convertire a double (x tutti a parte string)
            int num = ActionsOnDB.InserisciProdotto(cod.getText(), nome.getText(), (String) cbmarca.getSelectedItem(),
                    Double.parseDouble(prezzo.getText()), Integer.parseInt(numpezzi.getText()));

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame();
                    JOptionPane.showMessageDialog(f1, "ERRORE: selezionare una MARCA.","ATTENZIONE",2);
                    break;
                case 3:
                    JFrame f3 = new JFrame();
                    JOptionPane.showMessageDialog(f3, "ERRORE: il CODICE inserito è già presente.","ATTENZIONE",2);
                    cod.setText("");
                    break;
                case 4:
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!","ACCESSO RIUSCITO",1);
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
                    JFrame f5 = new JFrame();
                    JOptionPane.showMessageDialog(f5, "ERRORE: inserire il NOME del prodotto.","ATTENZIONE",2);
                    break;
                case 6:
                    JFrame f6 = new JFrame();
                    JOptionPane.showMessageDialog(f6, "ERRORE: il codice non è stato inserito.","ATTENZIONE",2);
                    break;
            }
        }
    }

    public void BinsFornitoreDB(){
        if(piva.getText().length()==0 && nomeF.getText().length()==0 && luogo.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
        }
        else {

            int num = ActionsOnDB.InserisciFornitore(piva.getText(), nomeF.getText(), luogo.getText());

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame();
                    JOptionPane.showMessageDialog(f1, "ERRORE: inserimento errato della Partita Iva","ATTENZIONE",2);
                    piva.setText("");
                    break;
                case 2:
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "ERRORE: inserire il nome del fornitore.","ATTENZIONE",2);
                    break;
                case 3:
                    JFrame f3 = new JFrame();
                    JOptionPane.showMessageDialog(f3, "ERRORE: inserire il luogo","ATTENZIONE",2);
                    break;
                case 4:
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!","ACCESSO RIUSCITO",1);
                    Fornitore fr = new Fornitore();
                    fr.setP_iva(piva.getText());
                    fr.setNome(nomeF.getText());
                    fr.setLuogo(luogo.getText());
                    piva.setText("");
                    nomeF.setText("");
                    luogo.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame();
                    JOptionPane.showMessageDialog(f5, "ERRORE: Partita Iva già presente","ATTENZIONE",0);
                    piva.setText("");
                    break;
            }
        }
    }

    public void BinsClienteDB(){
        if(cf.getText().length()==0 && nomeC.getText().length()==0 && cognome.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
        }
        else {

            int num = ActionsOnDB.InserisciCliente(cf.getText(), nomeC.getText(), cognome.getText());

            switch (num) {
                case 1:
                    JFrame f1 = new JFrame();
                    JOptionPane.showMessageDialog(f1, "ERRORE: inserimento errato del Codice Fiscale","ATTENZIONE",2);
                    cf.setText("");
                    break;
                case 2:
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "ERRORE: inserire il nome del cliente.","ATTENZIONE",2);
                    break;
                case 3:
                    JFrame f3 = new JFrame();
                    JOptionPane.showMessageDialog(f3, "ERRORE: inserire il cognome","ATTENZIONE",2);
                    break;
                case 4:
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!","ACCESSO RIUSCITO CON SUCCESSO",1);
                    Cliente cl = new Cliente();
                    cl.setCf(cf.getText());
                    cl.setNome(nomeC.getText());
                    cl.setCognome(cognome.getText());
                    cf.setText("");
                    nomeC.setText("");
                    cognome.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame();
                    JOptionPane.showMessageDialog(f5, "ERRORE: Codice Fiscale già presente","ATTENZIONE",2);
                    cf.setText("");
                    break;
            }
        }
    }

    public void BinsNuovoOrdineFornitoreDB(){
        if(of_nome.getSelectedItem()=="Seleziona..." && of_cod.getSelectedItem()=="Seleziona..." && (piva_f.getSelectedItem()=="" ||piva_f.getSelectedItem()=="Seleziona...") &&
                op_numpezzi.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
            of_nome.setSelectedIndex(0);
            of_cod.setSelectedIndex(0);
            piva_f.setSelectedIndex(0);
            op_numpezzi.setText("");
        }
        else {

            if(op_numpezzi.getText().length()==0){
                JFrame f1=new JFrame();
                JOptionPane.showMessageDialog(f1,"ERRORE: inserire il numero dei pezzi da ordinare.","ATTENZIONE",0);
            }

            int num = ActionsOnDB.InserisciOrdineFornitore((String) of_nome.getSelectedItem(), (String) of_cod.getSelectedItem(),
                    (String) piva_f.getSelectedItem(), Integer.parseInt(op_numpezzi.getText()));

            if(num==1) {
                JFrame f4 = new JFrame();
                JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!","ACCESSO RIUSCITO",1);
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
                JFrame f1 = new JFrame();
                JOptionPane.showMessageDialog(f1, "SI E' VERIFICATO UN ERRORE","ATTENZIONE",0);
            }
        }
    }

    public void BinsNuovoOrdineClienteDB(){
        if(of_nome.getSelectedItem()=="Seleziona..." && of_cod.getSelectedItem()=="Seleziona..." && (oc_cfClienti.getSelectedItem()=="" ||oc_cfClienti.getSelectedItem()=="Seleziona...") &&
                (oc_nomiClienti.getSelectedItem()=="" ||oc_nomiClienti.getSelectedItem()=="Seleziona...") &&
                oc_numpezzi.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
            of_nome.setSelectedIndex(0);
            of_cod.setSelectedIndex(0);
            oc_cfClienti.setSelectedIndex(0);
            oc_nomiClienti.setSelectedIndex(0);
            oc_numpezzi.setText("");
        }
        else {

            if(oc_numpezzi.getText().length()==0){
                JFrame f1=new JFrame();
                JOptionPane.showMessageDialog(f1,"ERRORE: inserire il numero dei pezzi da ordinare.","ATTENZIONE",2);
            }

            int num = ActionsOnDB.InserisciOrdineCliente((String) of_nome.getSelectedItem(), (String) of_cod.getSelectedItem(),
                    (String) oc_cfClienti.getSelectedItem(), Integer.parseInt(oc_numpezzi.getText()));

            switch(num) {
                case 1:
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "L'inserimento dei dati è avvenuto con successo!","ACCESSO CONSENTITO",1);
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
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "ERRORE: non ci sono abbastanza pezzi il magazzino del prodotto desiderato","ATTENZIONE",2);
                    break;

            }
        }
    }

    // testo è etichetta incollata a nord del frame, elenco è la stringa con tutti i dati che voglio visualizzare
    public void Visualizza(String testo, String elenco){

        labelProd= new JLabel(testo);
        editor1= new JEditorPane(); //area di testo grande
        editor1.setPreferredSize(new Dimension(25,25));
        editor1.setText(elenco);
        editor1.setEditable(false); //l'area di testo non può essere modificata
        editor1.setBackground(new Color(173,196,255));

        chiudiVis=new JButton("CHIUDI");
        chiudiVis.setPreferredSize(new Dimension(70,50));
        chiudiVis.addActionListener(this);

        frame.getContentPane().add(labelProd, BorderLayout.NORTH);
        frame.getContentPane().add(editor1, BorderLayout.CENTER);
        frame.getContentPane().add(chiudiVis, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    //richiamo la funzione per tutti i tasti di visualizza
    public void VisualizzaProdotti(){
        String[] colonne={"Codice", "Nome", "Marca", "Prezzo", "Num_pezzi"};
        Visualizza("Elenco di tutti i prodotti presenti in magazzino.", ActionsOnDB.Visualizza("select * from prodotto", colonne, 5));
    }

    public void VisualizzaClienti(){
        String[] colonne={"CF", "Nome", "Cognome"};
        Visualizza("Anagrafica di tutti i clienti registrati:", ActionsOnDB.Visualizza("select * from cliente", colonne, 3));
    }

    public void VisualizzaFornitore(){
        String[] colonne={"PIVA", "Nome", "Luogo"};
        Visualizza("Anagrafica di tutti i fornitori registrati:", ActionsOnDB.Visualizza("select * from fornitore", colonne, 3));
    }

    public void VisualizzaOrdineFornitore(){
        String[] colonne={"Cod_Prodotto", "P_ivaF", "Prezzo", "Nr_Pezzi"};
        Visualizza("Elenco di tutti gli ordini per i fornitori.",ActionsOnDB.Visualizza("select * from ordine_fornitore", colonne, 4));
    }

    public void VisualizzaOrdiniClienti(){
        String[] colonne={"Cod_Prodotto", "Num_Pezzi", "Cf_Cliente"};
        Visualizza("Elenco di tutti gli ordini dei clienti.",ActionsOnDB.Visualizza("select * from ordine_cliente", colonne, 3));

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

    //tasti chiudi usano la funzione che rende invisibile il pannello che le viene passato
    public void Chiudi(JPanel p){
        p.setVisible(false);
    }

    public void ChiudiInsProdotto(){
        Chiudi(pannelloEsterno);
        etichettaIniz.setVisible(false);
    }

    public void ChiudiInsFornitore(){
        Chiudi(pannelloEsternoInsForn);
        etichettaIniz.setVisible(false);
    }

    public void ChiudiInsCliente(){
        Chiudi(pannelloEsternoInsClinte);
        etichettaIniz.setVisible(false);
    }

    public void ChiudiCercaProdotto(){
        Chiudi(pannelloEsternoCerca);
        delete.setVisible(false);
    }

    public void ChiudiOrdineFornitore(){
        Chiudi(pannelloEsternoInsOrdineForn);
        etichettaIniz.setVisible(false);
    }

    public void ChiudiOrdineCliente(){
        Chiudi(pannelloEsternoInsOrdineCliente);
        etichettaIniz.setVisible(false);
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

    //Creata in automatico quando aggiunto Actionlistener, creati if per ogni inserimento
    @Override
    public void actionPerformed(ActionEvent e) {
        // INTERFACCIA AGGIUNGI PRODOTTO
        if(e.getSource()==aggiungiP){ //aggiungiP è azione sul tasto "Nuovo prodotto"
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
        // BOTTONE CHIUDI TUTTE LE VISUALIZZAZIONI DI PRODOTTI, CLIENTI, FORNITORI, ORDINI da TENDINA
        if(e.getSource()==chiudiVis){
            labelProd.setVisible(false);
            editor1.setVisible(false);
            chiudiVis.setVisible(false);
        }

    }

    public static void main(String[] argv){
            Home hm= new Home();
            hm.HomeFrame();
    }
}