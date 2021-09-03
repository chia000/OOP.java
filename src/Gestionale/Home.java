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
    JEditorPane editorProd;
    JEditorPane editorClient;
    JEditorPane editorFor;

    JMenu ordine, prodotti, clienti, fornitori;
    JMenuItem aggiungiP, cercaP, aggiungiF, aggiungiC, aggiungiOF,aggiungiOC;
    JMenuItem visualizzaP;
    JMenuItem visualizzaC;
    JMenuItem visualizzaF;
    JMenuItem visualizzaOF, visualizzaOC;
    JMenuItem cercaC;
    JMenuItem cercaF;

    JTextField cod, nome, prezzo, numpezzi;
    JTextField piva, nomeF, luogo, emailF;
    JTextField cf, nomeC, cognome, email;
    JTextField op_numpezzi;  // ORDINE PRODOTTO A FORNITORE
    JTextField tnome;
    JTextField tcognome, tnomeC;
    JTextField tnomeF;

    JComboBox cbmarca;
    JComboBox tcod, tcf, tfor;
    //JComboBox op_prezzo;   // ORDINE PRODOTTO A FORNITORE

    JButton delete, binserisci, bcercap, bchiudiInsProd, bchiudiCercaProd;
    JButton binserisciFor, bchiudiInsFor;
    JButton binserisciCliente, bchiudiInsCliente;
    JButton bchiudiOrdineFor, binserisciOrdineFor;
    JButton binserisciOrdineCliente, bchiudiOrdineCliente;
    JButton chiudiVis;
    JButton okcercaProd;
    JButton newRicercaProd, elimanaProd, modificaProd, nuovoProd, bmodificaProd, bchiudiModifica;
    JButton bOKOrdineFor;
    JButton bBack;
    JButton okcercaClient, elimanaClient, nuovoClient, bchiudiCercaClient;
    JButton newRicercaClient;
    JButton okcercaFor, elimanaFor, nuovoFor, bchiudiCercaFor, newRicercaFor;

    JFrame frame;
    JFrame f;

    JPanel pannelloEsterno;
    JPanel pannelloEsternoCerca;
    JPanel pannelloEsternoInsForn;
    JPanel pannelloEsternoInsClinte;
    JPanel pannelloEsternoInsOrdineForn;
    JPanel pannelloEsternoInsOrdineCliente;
    JPanel panelnord;
    JPanel pannello1;
    JPanel pannelloSud, pannelloCentro;
    JPanel pannelloModificaProd;
    JPanel pannelloEsternoCercaC, pannelloSudc, pannelloCentroC, pannelloComboCf;
    JPanel pannelloEsternoCercaF,pannelloSudF, pannelloCentroF, pannelloComboFor;

    public static void ImpostaFont(JComponent c, int i){
        c.setFont(new Font("Trebuchet MS", Font.CENTER_BASELINE,i));
    }

    public void HomeFrame(){
        frame= new JFrame("GestioniaMO"); //pannello principale (nome)
        frame.setLocation(300,100);


        Image icona = Toolkit.getDefaultToolkit().createImage("iconaProgetto.jpg");
        frame.setIconImage(icona);

        frame.getContentPane().setBackground(new Color(173,196,255));
        //frame.getContentPane().setBackground(Color.pink);


        frame.setPreferredSize(new Dimension(1000,700));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JMenuBar menubar =new JMenuBar(); //barra di menù
        frame.setJMenuBar(menubar);
        prodotti= new JMenu("PRODOTTI"); // nomi menù a tendina
        ImpostaFont(prodotti,15);
        clienti= new JMenu("CLIENTI");
        ImpostaFont(clienti,15);
        fornitori= new JMenu("FORNITORI");
        ImpostaFont(fornitori,15);
        ordine=new JMenu("ORDINE");
        ImpostaFont(ordine,15);
        menubar.add(prodotti);
        menubar.add(clienti);
        menubar.add(fornitori);
        menubar.add(ordine);

        //Prodotti
        visualizzaP= new JMenuItem("Visualizza tutto..."); //Nomi delle selezioni menù a tendina
        ImpostaFont(visualizzaP,14);
        visualizzaP.addActionListener(this);
        aggiungiP= new JMenuItem("Nuovo prodotto");
        ImpostaFont(aggiungiP,14);
        aggiungiP.addActionListener(this);
        cercaP=new JMenuItem("Cerca prodotto");
        ImpostaFont(cercaP,14);
        cercaP.addActionListener(this);
        prodotti.add(visualizzaP);
        prodotti.addSeparator();
        prodotti.add(aggiungiP);
        prodotti.addSeparator();
        prodotti.add(cercaP);

        //Clienti
        visualizzaC= new JMenuItem("Visualizza tutto...");
        ImpostaFont(visualizzaC,14);
        visualizzaC.addActionListener(this);
        aggiungiC= new JMenuItem("Nuovo cliente");
        ImpostaFont(aggiungiC,14);
        aggiungiC.addActionListener(this);
        cercaC=new JMenuItem("Cerca cliente");
        ImpostaFont(cercaC,14);
        cercaC.addActionListener(this);
        clienti.add(visualizzaC);
        clienti.addSeparator();
        clienti.add(aggiungiC);
        clienti.addSeparator();
        clienti.add(cercaC);

        //Fornitori
        visualizzaF= new JMenuItem("Visualizza tutto...");
        ImpostaFont(visualizzaF,14);
        visualizzaF.addActionListener(this);
        aggiungiF= new JMenuItem("Nuovo fornitore");
        ImpostaFont(aggiungiF,14);
        aggiungiF.addActionListener(this);
        cercaF=new JMenuItem("Cerca fornitore");
        ImpostaFont(cercaF,14);
        cercaF.addActionListener(this);
        fornitori.add(visualizzaF);
        fornitori.addSeparator();
        fornitori.add(aggiungiF);
        fornitori.addSeparator();
        fornitori.add(cercaF);

        //Ordini fornitori e Ordini clienti
        visualizzaOF= new JMenuItem("Visualizza tutti gli ordini ai fornitori...");
        ImpostaFont(visualizzaOF,14);
        visualizzaOF.addActionListener(this);
        visualizzaOC= new JMenuItem("Visualizza tutti gli ordini dei clienti...");
        ImpostaFont(visualizzaOC,14);
        visualizzaOC.addActionListener(this);
        aggiungiOF= new JMenuItem("Nuovo ordine per fornitore");
        ImpostaFont(aggiungiOF,14);
        aggiungiOF.addActionListener(this);
        aggiungiOC= new JMenuItem("Nuovo ordine per cliente");
        ImpostaFont(aggiungiOC,14);
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
        CambiaColore(pannelloDelete);
        frame.getContentPane().add(pannelloDelete,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    /*public void ChiudiTutto(){

        if(pannelloEsterno.isVisible()){
            pannelloEsterno.setVisible(false);
        }
        if(pannelloEsternoCerca.isVisible()){
            pannelloEsternoCerca.setVisible(false);
        }
        if(pannelloEsternoInsForn.isVisible()){
            pannelloEsternoInsForn.setVisible(false);
        }
        if(pannelloEsternoInsClinte.isVisible()){
            pannelloEsternoInsClinte.setVisible(false);
        }
        if(pannelloEsternoInsOrdineForn.isVisible()){
            pannelloEsternoInsOrdineForn.setVisible(false);
        }
        if(pannelloEsternoInsOrdineCliente.isVisible()){
            pannelloEsternoInsOrdineCliente.setVisible(false);
        }
        if(pannelloVis.isVisible()){
            pannelloVis.setVisible(false);
        }
        if(labelProd.isVisible()){
            labelProd.setVisible(false);
        }
        if(editor1.isVisible()){
            editor1.setVisible(false);
        }
        if(chiudiVis.isVisible()){
            chiudiVis.setVisible(false);
        }
    }*/

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
        pannelloEsterno.setVisible(true);
        pannelloEsterno.setPreferredSize(new Dimension(400,400));
        pannelloEsterno.setLayout(new FlowLayout()); //disposizione in colonna con flowlayout
        CambiaColore(pannelloEsterno);

        etichettaIniz=new JLabel("      Form per inserimento nuovo prodotto.");
        ImpostaFont(etichettaIniz,17);
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        //pannello piccolo con label e textfield del CODICE
        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcod= new JLabel("Codice");
        ImpostaFont(lcod,14);
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
        ImpostaFont(lnome,14);
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
        ImpostaFont(lmarca,14);
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
        ImpostaFont(lprezzo,14);
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
        ImpostaFont(lpezzi,14);
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
        ImpostaFont(binserisci,16);
        //binserisci.setPreferredSize(new Dimension(100,50));
        binserisci.addActionListener(this); //evento sul tasto INSERISCI
        pannello6.add(binserisci);
        CambiaColore(pannello6);
        pannelloEsterno.add(pannello6);

        //bottone direttamente su pannello grande CHIUDI (va bene perchè settato come flowlayout e non border)
        bchiudiInsProd=new JButton("CHIUDI");
        ImpostaFont(bchiudiInsProd,16);
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
        ImpostaFont(etichettaIniz,17);
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lpiva= new JLabel("Partita IVA");
        ImpostaFont(lpiva,14);
        piva=new JTextField();
        piva.setPreferredSize(new Dimension(250,25));
        pannello1.add(lpiva);
        pannello1.add(piva);
        pannelloEsternoInsForn.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        ImpostaFont(lnome,14);
        nomeF=new JTextField();
        nomeF.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeF);
        pannelloEsternoInsForn.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lluogo= new JLabel("Luogo ");
        ImpostaFont(lluogo,14);
        luogo=new JTextField();
        luogo.setPreferredSize(new Dimension(250,25));
        pannello3.add(lluogo);
        pannello3.add(luogo);
        pannelloEsternoInsForn.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lemail= new JLabel("Email");
        ImpostaFont(lemail,14);
        emailF=new JTextField();
        emailF.setPreferredSize(new Dimension(250,25));
        pannello4.add(lemail);
        pannello4.add(emailF);
        pannelloEsternoInsForn.add(pannello4);
        CambiaColore(pannello4);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciFor= new JButton("INSERISCI");
        ImpostaFont(binserisciFor,16);
        binserisciFor.addActionListener(this);
        pannello6.add(binserisciFor);
        pannelloEsternoInsForn.add(pannello6);
        CambiaColore(pannello6);

        bchiudiInsFor=new JButton("CHIUDI");
        ImpostaFont(bchiudiInsFor,16);
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
        ImpostaFont(etichettaIniz,17);
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello1 =new JPanel();
        pannello1.setLayout(new FlowLayout());
        JLabel lcf= new JLabel("Codice fiscale");
        ImpostaFont(lcf,14);
        cf=new JTextField();
        cf.setPreferredSize(new Dimension(250,25));
        pannello1.add(lcf);
        pannello1.add(cf);
        pannelloEsternoInsClinte.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome ");
        ImpostaFont(lnome,14);
        nomeC=new JTextField();
        nomeC.setPreferredSize(new Dimension(250,25));
        pannello2.add(lnome);
        pannello2.add(nomeC);
        pannelloEsternoInsClinte.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lcognome= new JLabel("Cognome");
        ImpostaFont(lcognome,14);
        cognome=new JTextField();
        cognome.setPreferredSize(new Dimension(250,25));
        pannello3.add(lcognome);
        pannello3.add(cognome);
        pannelloEsternoInsClinte.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lemail= new JLabel("Email");
        ImpostaFont(lemail,14);
        email=new JTextField();
        email.setPreferredSize(new Dimension(250,25));
        pannello4.add(lemail);
        pannello4.add(email);
        pannelloEsternoInsClinte.add(pannello4);
        CambiaColore(pannello4);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciCliente= new JButton("INSERISCI");
        ImpostaFont(binserisciCliente,16);
        binserisciCliente.addActionListener(this);
        pannello6.add(binserisciCliente);
        pannelloEsternoInsClinte.add(pannello6);
        CambiaColore(pannello6);

        bchiudiInsCliente=new JButton("CHIUDI");
        ImpostaFont(bchiudiInsCliente,16);
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
        ImpostaFont(etichettaIniz,17);
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        ImpostaFont(lnome,14);
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
        ImpostaFont(lcod,14);
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineForn.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lfor= new JLabel("Fornitore ");
        ImpostaFont(lfor,14);
        piva_f.setPreferredSize(new Dimension(250,25));
        pannello2.add(lfor);
        pannello2.add(piva_f);
        pannelloEsternoInsOrdineForn.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        ImpostaFont(lnumpezzi,14);
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



        JPanel pannello8=new JPanel();
        pannello8.setLayout(new FlowLayout());
        bOKOrdineFor= new JButton("OK");
        ImpostaFont(bOKOrdineFor,16);
        bOKOrdineFor.setPreferredSize(new Dimension(100,50));
        bOKOrdineFor.addActionListener(this);
        pannello8.add(bOKOrdineFor);
        pannelloEsternoInsOrdineForn.add(pannello8);
        CambiaColore(pannello8);

        bchiudiOrdineFor=new JButton("CHIUDI");
        ImpostaFont(bchiudiOrdineFor,16);
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
        ImpostaFont(etichettaIniz,17);
        frame.getContentPane().add(etichettaIniz,BorderLayout.NORTH);

        JPanel pannello0 =new JPanel();
        pannello0.setLayout(new FlowLayout());
        JLabel lnome= new JLabel("Nome prodotto");
        ImpostaFont(lnome,14);
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
        ImpostaFont(lcod,14);
        of_cod.setPreferredSize(new Dimension(250,25));
        of_cod.addActionListener(this);
        pannello1.add(lcod);
        pannello1.add(of_cod);
        pannelloEsternoInsOrdineCliente.add(pannello1);
        CambiaColore(pannello1);

        JPanel pannello2 =new JPanel();
        pannello2.setLayout(new FlowLayout());
        JLabel lcliet= new JLabel("CF cliente ");
        ImpostaFont(lcliet,14);
        oc_cfClienti.setPreferredSize(new Dimension(250,25));
        oc_cfClienti.addActionListener(this);
        pannello2.add(lcliet);
        pannello2.add(oc_cfClienti);
        pannelloEsternoInsOrdineCliente.add(pannello2);
        CambiaColore(pannello2);

        JPanel pannello4 =new JPanel();
        pannello4.setLayout(new FlowLayout());
        JLabel lnclient= new JLabel("Cliente ");
        ImpostaFont(lnclient,14);
        oc_nomiClienti.setPreferredSize(new Dimension(250,25));
        pannello4.add(lnclient);
        pannello4.add(oc_nomiClienti);
        pannelloEsternoInsOrdineCliente.add(pannello4);
        CambiaColore(pannello4);

        JPanel pannello3 =new JPanel();
        pannello3.setLayout(new FlowLayout());
        JLabel lnumpezzi= new JLabel("Numero dei pezzi ");
        ImpostaFont(lnumpezzi,14);
        oc_numpezzi=new JTextField();
        oc_numpezzi.setPreferredSize(new Dimension(250,25));
        pannello3.add(lnumpezzi);
        pannello3.add(oc_numpezzi);
        pannelloEsternoInsOrdineCliente.add(pannello3);
        CambiaColore(pannello3);

        JPanel pannello6=new JPanel();
        pannello6.setLayout(new FlowLayout());
        binserisciOrdineCliente= new JButton("INSERISCI");
        ImpostaFont(binserisciOrdineCliente,16);
        //binserisciOrdineCliente.setPreferredSize(new Dimension(100,50));
        binserisciOrdineCliente.addActionListener(this);
        pannello6.add(binserisciOrdineCliente);
        pannelloEsternoInsOrdineCliente.add(pannello6);
        CambiaColore(pannello6);

        bchiudiOrdineCliente=new JButton("CHIUDI");
        ImpostaFont(bchiudiOrdineCliente,16);
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
        if(piva.getText().length()==0 && nomeF.getText().length()==0 && luogo.getText().length()==0 && emailF.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
        }
        else {

            int num = ActionsOnDB.InserisciFornitore(piva.getText(), nomeF.getText(), luogo.getText(), emailF.getText());

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
                    fr.setEmail(emailF.getText());
                    piva.setText("");
                    nomeF.setText("");
                    luogo.setText("");
                    emailF.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame();
                    JOptionPane.showMessageDialog(f5, "ERRORE: Partita Iva già presente","ATTENZIONE",0);
                    piva.setText("");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(new JFrame(), "Inserire l'email del fornitore.","ATTENZIONE",0);
                    break;
            }
        }
    }

    public void BinsClienteDB(){
        if(cf.getText().length()==0 && nomeC.getText().length()==0 && cognome.getText().length()==0 && email.getText().length()==0){
            JFrame f0=new JFrame();
            JOptionPane.showMessageDialog(f0,"ERRORE: inserire i dati.","ATTENZIONE",0);
        }
        else {

            int num = ActionsOnDB.InserisciCliente(cf.getText(), nomeC.getText(), cognome.getText(), email.getText());

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
                    cl.setEmail(email.getText());
                    cf.setText("");
                    nomeC.setText("");
                    cognome.setText("");
                    email.setText("");
                    break;
                case 5:
                    JFrame f5 = new JFrame();
                    JOptionPane.showMessageDialog(f5, "ERRORE: Codice Fiscale già presente","ATTENZIONE",2);
                    cf.setText("");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(new JFrame(), "Inserire l'email del cliente.","ATTENZIONE",2);
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

    public void VisualizzaProd(){
        panelnord= new JPanel();
        CambiaColore(panelnord);

        JList elencoPrd=new JList(ActionsOnDB.VisProd());
        panelnord.add(elencoPrd);
        JScrollPane scrol=new JScrollPane(elencoPrd);
        scrol.setPreferredSize(new Dimension(700,400));
        panelnord.add(scrol);

        chiudiVis=new JButton("CHIUDI");
        ImpostaFont(chiudiVis,16);
        chiudiVis.setPreferredSize(new Dimension(70,50));
        chiudiVis.addActionListener(this);

        JPanel panelEti=new JPanel();
        panelEti.setLayout(new FlowLayout());
        panelEti.setPreferredSize(new Dimension(500,100));
        JLabel eti=new JLabel("PRODOTTI REGISTRATI NEL DATABASE");
        ImpostaFont(eti, 17);
        panelEti.add(eti);
        frame.getContentPane().add(panelEti, BorderLayout.NORTH);
        frame.getContentPane().add(panelnord, BorderLayout.CENTER);
        frame.getContentPane().add(chiudiVis, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // testo è etichetta incollata a nord del frame, elenco è la stringa con tutti i dati che voglio visualizzare
    public void Visualizza(String testo, String elenco){

        panelnord= new JPanel();
        panelnord.setLayout(new FlowLayout());
        panelnord.setPreferredSize(new Dimension(100, 50));
        CambiaColore(panelnord);
        labelProd= new JLabel(testo);
        ImpostaFont(labelProd,17);
        panelnord.add(labelProd);
        editor1= new JEditorPane(); //area di testo grande
        editor1.setPreferredSize(new Dimension(25,25));
        ImpostaFont(editor1,14);
        editor1.setText(elenco);
        editor1.setEditable(false); //l'area di testo non può essere modificata
        editor1.setBackground(new Color(173,196,255));

        /*ChiudiTutto();
        labelProd.setVisible(true);
        editor1.setVisible(true);*/

        chiudiVis=new JButton("CHIUDI");
        ImpostaFont(chiudiVis,16);
        chiudiVis.setPreferredSize(new Dimension(70,50));
        chiudiVis.addActionListener(this);

        frame.getContentPane().add(panelnord, BorderLayout.NORTH);
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
        String[] colonne={"CF", "Nome", "Cognome", "Email"};
        Visualizza("Anagrafica di tutti i clienti registrati:", ActionsOnDB.Visualizza("select * from cliente", colonne, 4));
    }

    public void VisualizzaFornitore(){
        String[] colonne={"PIVA", "Nome", "Luogo", "Email"};
        Visualizza("Anagrafica di tutti i fornitori registrati:", ActionsOnDB.Visualizza("select * from fornitore", colonne, 4));
    }

    public void VisualizzaOrdineFornitore(){
        String[] colonne={"Cod_Prodotto", "P_ivaF", "Prezzo", "Nr_Pezzi"};
        Visualizza("Elenco di tutti gli ordini per i fornitori.",ActionsOnDB.Visualizza("select * from ordine_fornitore", colonne, 4));
    }

    public void VisualizzaOrdiniClienti(){
        String[] colonne={"Cod_Prodotto", "Num_Pezzi", "Cf_Cliente"};
        Visualizza("Elenco di tutti gli ordini dei clienti.",ActionsOnDB.Visualizza("select * from ordine_cliente", colonne, 3));

    }

    JPanel pannello3;

    public void CercaProdotto(){
        //frame.setVisible(false);
        pannelloEsternoCerca=new JPanel();
        pannelloEsternoCerca.setPreferredSize(new Dimension(400,400));
        pannelloEsternoCerca.setLayout(new BorderLayout());
        CambiaColore(pannelloEsternoCerca);

        JPanel pannello2=new JPanel();
        pannello2.setLayout(new FlowLayout());
        pannello2.setPreferredSize(new Dimension(400,70));
        pannello2.setAlignmentX(FlowLayout.TRAILING);
        JLabel lnome=new JLabel("Nome");
        ImpostaFont(lnome,14);
        tnome=new JTextField();
        tnome.setPreferredSize(new Dimension(350,25));
        okcercaProd=new JButton("OK");
        ImpostaFont(okcercaProd,16);
        okcercaProd.addActionListener(this);
        pannello2.add(lnome);
        pannello2.add(tnome);
        pannello2.add(okcercaProd);
        pannelloEsternoCerca.add(pannello2,BorderLayout.NORTH);
        CambiaColore(pannello2);

        pannelloSud= new JPanel();
        pannelloSud.setLayout(new FlowLayout());
        pannelloSud.setPreferredSize(new Dimension(100, 100));

        elimanaProd=new JButton("ELIMINA PRODOTTO");
        ImpostaFont(elimanaProd,16);
        elimanaProd.addActionListener(this);
        modificaProd=new JButton("MODIFICA PRODOTTO");
        ImpostaFont(modificaProd,16);
        modificaProd.addActionListener(this);
        nuovoProd=new JButton("NUOVO PRODOTTO");
        ImpostaFont(nuovoProd,16);
        nuovoProd.addActionListener(this);
        bchiudiCercaProd=new JButton("CHIUDI");
        ImpostaFont(bchiudiCercaProd,16);
        bchiudiCercaProd.addActionListener(this);

        pannelloSud.add(elimanaProd);
        pannelloSud.add(modificaProd);
        pannelloSud.add(nuovoProd);
        pannelloSud.add(bchiudiCercaProd);
        CambiaColore(pannelloSud);

        frame.getContentPane().add(pannelloSud, BorderLayout.SOUTH);
        modificaProd.setVisible(false);
        nuovoProd.setVisible(false);
        elimanaProd.setVisible(false);

        frame.getContentPane().add(pannelloEsternoCerca, BorderLayout.NORTH);
        frame.setVisible(true);


    }

    public void CercaCliente(){

        pannelloEsternoCercaC=new JPanel();
        pannelloEsternoCercaC.setPreferredSize(new Dimension(400,400));
        pannelloEsternoCercaC.setLayout(new BorderLayout());
        CambiaColore(pannelloEsternoCercaC);

        JPanel pannello2=new JPanel();
        pannello2.setLayout(new FlowLayout());
        pannello2.setPreferredSize(new Dimension(400,70));
        pannello2.setAlignmentX(FlowLayout.TRAILING);
        JLabel lnome=new JLabel("Nome");
        ImpostaFont(lnome,14);
        tnomeC=new JTextField();
        tnomeC.setPreferredSize(new Dimension(350,25));
        JLabel lcognome=new JLabel("Cognome");
        ImpostaFont(lcognome,14);
        tcognome=new JTextField();
        tcognome.setPreferredSize(new Dimension(350,25));
        okcercaClient=new JButton("OK");
        ImpostaFont(okcercaClient,16);
        okcercaClient.addActionListener(this);
        pannello2.add(lnome);
        pannello2.add(tnomeC);
        pannello2.add(lcognome);
        pannello2.add(tcognome);
        pannello2.add(okcercaClient);
        pannelloEsternoCercaC.add(pannello2,BorderLayout.NORTH);
        CambiaColore(pannello2);

        pannelloCentroC = new JPanel();
        pannelloCentroC.setLayout(new FlowLayout());
        pannelloCentroC.setPreferredSize(new Dimension(900, 250));
        editorClient = new JEditorPane();
        ImpostaFont(editorClient,15);
        editorClient.setPreferredSize(new Dimension(350, 300));
        pannelloCentroC.add(editorClient);
        editorClient.setBackground(new Color(173, 196, 255));
        pannelloEsternoCercaC.add(pannelloCentroC, BorderLayout.SOUTH);
        CambiaColore(pannelloCentroC);
        editorClient.setVisible(false);

        pannelloSudc= new JPanel();
        pannelloSudc.setLayout(new FlowLayout());
        pannelloSudc.setPreferredSize(new Dimension(100, 100));

        elimanaClient=new JButton("ELIMINA CLIENTE");
        ImpostaFont(elimanaClient,16);
        elimanaClient.addActionListener(this);
        nuovoClient=new JButton("NUOVO CLIENTE");
        ImpostaFont(nuovoClient,16);
        nuovoClient.addActionListener(this);
        bchiudiCercaClient=new JButton("CHIUDI");
        ImpostaFont(bchiudiCercaClient,16);
        bchiudiCercaClient.addActionListener(this);

        pannelloSudc.add(elimanaClient);
        pannelloSudc.add(nuovoClient);
        pannelloSudc.add(bchiudiCercaClient);
        CambiaColore(pannelloSudc);

        frame.getContentPane().add(pannelloSudc, BorderLayout.SOUTH);
        nuovoClient.setVisible(false);
        elimanaClient.setVisible(false);

        frame.getContentPane().add(pannelloEsternoCercaC, BorderLayout.NORTH);
        frame.setVisible(true);


    }

    public void CercaFornitore(){

        pannelloEsternoCercaF=new JPanel();
        pannelloEsternoCercaF.setPreferredSize(new Dimension(400,400));
        pannelloEsternoCercaF.setLayout(new BorderLayout());
        CambiaColore(pannelloEsternoCercaF);

        JPanel pannello2=new JPanel();
        pannello2.setLayout(new FlowLayout());
        pannello2.setPreferredSize(new Dimension(400,70));
        pannello2.setAlignmentX(FlowLayout.TRAILING);
        JLabel lnome=new JLabel("Nome fornitore");
        ImpostaFont(lnome,14);
        tnomeF=new JTextField();
        tnomeF.setPreferredSize(new Dimension(350,25));
        okcercaFor=new JButton("OK");
        ImpostaFont(okcercaFor,16);
        okcercaFor.addActionListener(this);
        pannello2.add(lnome);
        pannello2.add(tnomeF);
        pannello2.add(okcercaFor);
        pannelloEsternoCercaF.add(pannello2,BorderLayout.NORTH);
        CambiaColore(pannello2);

        pannelloCentroF = new JPanel();
        pannelloCentroF.setLayout(new FlowLayout());
        pannelloCentroF.setPreferredSize(new Dimension(900, 250));
        editorFor = new JEditorPane();
        ImpostaFont(editorFor,15);
        editorFor.setPreferredSize(new Dimension(350, 300));
        pannelloCentroF.add(editorFor);
        editorFor.setBackground(new Color(173, 196, 255));
        pannelloEsternoCercaF.add(pannelloCentroF, BorderLayout.SOUTH);
        CambiaColore(pannelloCentroF);
        editorFor.setVisible(false);

        pannelloSudF= new JPanel();
        pannelloSudF.setLayout(new FlowLayout());
        pannelloSudF.setPreferredSize(new Dimension(100, 100));

        elimanaFor=new JButton("ELIMINA FORNITORE");
        ImpostaFont(elimanaFor,16);
        elimanaFor.addActionListener(this);
        nuovoFor=new JButton("NUOVO FORNITORE");
        ImpostaFont(nuovoFor,16);
        nuovoFor.addActionListener(this);
        bchiudiCercaFor=new JButton("CHIUDI");
        ImpostaFont(bchiudiCercaFor,16);
        bchiudiCercaFor.addActionListener(this);

        pannelloSudF.add(elimanaFor);
        pannelloSudF.add(nuovoFor);
        pannelloSudF.add(bchiudiCercaFor);
        CambiaColore(pannelloSudF);

        pannelloSudF.setVisible(true);

        frame.getContentPane().add(pannelloSudF, BorderLayout.SOUTH);
        bchiudiCercaFor.setVisible(true);
        nuovoFor.setVisible(false);
        elimanaFor.setVisible(false);

        frame.getContentPane().add(pannelloEsternoCercaF, BorderLayout.NORTH);
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

    public void ChiudiCercaProd(){
        pannelloEsternoCerca.setVisible(false);
    }

    public void ChiudiCercaClient(){
        pannelloEsternoCercaC.setVisible(false);
    }

    public void ChiudiCercaFor(){
        pannelloEsternoCercaF.setVisible(false);
    }

    public void ModificaProdotto(String tmp_codice, String tmp_nome){

        ProdottoInsFrame();
        cod.setEditable(false);
        cod.setText(tmp_codice);
        nome.setEditable(false);
        nome.setText(tmp_nome);
        cbmarca.removeAllItems();
        String[] e=ActionsOnDB.trovaParametro(tmp_codice);
        cbmarca.addItem(e[0]);

        binserisci.setVisible(false);
        bchiudiInsProd.setVisible(false);

        pannelloModificaProd=new JPanel();
        pannelloModificaProd.setLayout(new FlowLayout());
        pannelloModificaProd.setPreferredSize(new Dimension(100,100));
        bmodificaProd=new JButton("MODIFICA");
        ImpostaFont(bmodificaProd,16);
        bmodificaProd.addActionListener(this);
        pannelloModificaProd.add(bmodificaProd);
        bchiudiModifica=new JButton("CHIUDI");
        ImpostaFont(bchiudiModifica,16);
        bchiudiModifica.addActionListener(this);
        pannelloModificaProd.add(bchiudiModifica);
        CambiaColore(pannelloModificaProd);
        pannelloModificaProd.setVisible(true);

        frame.getContentPane().add(pannelloModificaProd, BorderLayout.SOUTH);

        frame.setVisible(true);

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
        // BOTTONE CHIUDI IN INSERIMENTO PRODOTTO (per ora)
        if(e.getSource()==bchiudiInsProd){
            ChiudiInsProdotto();
            bchiudiInsProd.setVisible(false);
        }
        // BOTTONE CHIUDI CERCA PRODOTTO
        if(e.getSource()==bchiudiCercaProd){
            ChiudiCercaProdotto();
            pannelloSud.setVisible(false);
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
            f.setVisible(false);
            frame.setVisible(true);
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
            VisualizzaProd();
            //VisualizzaProdotti();
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
            panelnord.setVisible(false);
            editor1.setVisible(false);
            chiudiVis.setVisible(false);
        }
        // BOTTONE OK CERCA PRODOTTO
        if(e.getSource()==okcercaProd){

            // controllo se abbiamo inserito il prodotto cercato
            if(tnome.getText().length()==0){
                JOptionPane.showMessageDialog(new JFrame(), "Inserisci un testo valido.", "ATTENZIONE", 2);
            }
            else {
                boolean chk=ActionsOnDB.CercaNomeProdottodb(tnome.getText());
                if(chk==true) {
                    String[] elencoCodiciProd = ActionsOnDB.elencoCodProdottoSelezionato(tnome.getText());
                    // lo 0 di elencoCodiciProd è "Seleziona..."
                    if (elencoCodiciProd.length == 1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Il codice inserito non è stato trovato.", "ERRORE", 0);
                        tnome.setText("");
                    } else {
                        pannello1 = new JPanel();
                        pannello1.setLayout(new FlowLayout());
                        pannello1.setPreferredSize(new Dimension(400, 100));
                        //pannello1.setPreferredSize(new Dimension(25,25));
                        JLabel lcod = new JLabel("Codice");
                        ImpostaFont(lcod,14);
                        tcod = new JComboBox(codProdotti);
                        tcod.setPreferredSize(new Dimension(250, 25));
                        tcod.addActionListener(this);
                        newRicercaProd = new JButton("NUOVA RICERCA");
                        ImpostaFont(newRicercaProd,16);
                        newRicercaProd.addActionListener(this);
                        pannello1.add(lcod);
                        pannello1.add(tcod);
                        pannello1.add(newRicercaProd);
                        pannelloEsternoCerca.add(pannello1, BorderLayout.CENTER);

                        pannelloCentro = new JPanel();
                        pannelloCentro.setLayout(new FlowLayout());
                        pannelloCentro.setPreferredSize(new Dimension(900, 250));
                        editorProd = new JEditorPane();
                        ImpostaFont(editorProd,15);
                        editorProd.setPreferredSize(new Dimension(250, 200));
                        pannelloCentro.add(editorProd);
                        //FlowLayout ciao=(FlowLayout) pannello1.getLayout();
                        //ciao.setAlignmentX(FlowLayout.TRAILING);
                        //editorProd.setPreferredSize(new Dimension(400,100));
                        editorProd.setBackground(new Color(173, 196, 255));
                        pannelloEsternoCerca.add(pannelloCentro, BorderLayout.SOUTH);
                        CambiaColore(pannelloCentro);
                        editorProd.setVisible(false);

                        nuovoProd.setVisible(true);
                        modificaProd.setVisible(true);
                        elimanaProd.setVisible(true);

                        frame.setVisible(true);
                        okcercaProd.removeActionListener(this);
                        CambiaColore(pannello1);

                        tcod.removeAllItems();
                        int i = ActionsOnDB.Conta(tnome.getText());
                        int c = 0;
                        while (c <= i) {
                            tcod.addItem(elencoCodiciProd[c]);
                            ++c;
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Questo articolo non esiste.", "ATTENZIONE", 2);
                    tnome.setText("");
                }
            }
        }
        // TROVA DESCRIZIONE PRODOTTO DATO CODICE E NOME PRODOTTO (CERCA PRODOTTO)
        if(e.getSource()==tcod){
            editorProd.setVisible(true);
            editorProd.setText(ActionsOnDB.elencoProdottoSelezionato((String) tcod.getSelectedItem()));
            //editorProd.setBackground(Color.MAGENTA);
            editorProd.setEditable(false);//l'area di testo non può essere modificata
            frame.setVisible(true);
        }
        // BOTTONE NUOVA RICERCA PRODOTTO
        if(e.getSource()==newRicercaProd){
            tnome.setText("");
            tcod.removeAllItems();
            pannello1.setVisible(false);
            pannelloCentro.setVisible(false);
            okcercaProd.addActionListener(this);
        }
        // BOTTONE NUOVO PRODOTTO DA CERCA PRODOTTO
        if(e.getSource()==nuovoProd){
            ChiudiCercaProd();
            pannelloSud.setVisible(false);
            ProdottoInsFrame();
        }
        // BOTTONE ELIMINA PRODOTTO DA CERCA PRODOTTO
        if(e.getSource()==elimanaProd){
            if(tcod.getSelectedItem()!="Seleziona..." || tcod.getSelectedItem()!="") {
                boolean val= ActionsOnDB.EliminaProdotto((String) tcod.getSelectedItem());
                if(val==true){
                    JOptionPane.showMessageDialog(new JFrame(), "Il prodotto selezionato è stato eliminato correttamente.", "ELIMINAZIONE",1);
                    pannelloCentro.setVisible(false);
                    nuovoProd.setVisible(false);
                    modificaProd.setVisible(false);
                    elimanaProd.setVisible(false);
                    pannello1.setVisible(false);
                    tnome.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "ERRORE, il prodotto non è stato eliminato correttamente poiché è presente in un'altra struttura.", "ATTENZIONE",0);
                    pannelloCentro.setVisible(false);
                    nuovoProd.setVisible(false);
                    modificaProd.setVisible(false);
                    elimanaProd.setVisible(false);
                    pannello1.setVisible(false);
                    tnome.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "ERRORE RIPROVA", "ATTENZIONE",0);
            }
        }
        // BOTTONE MODIFICA QUANTITA' (NUMERO PEZZI) e PREZZO PRODOTTO
        if(e.getSource()==modificaProd){
            ChiudiCercaProd();
            pannelloSud.setVisible(false);
            ModificaProdotto((String) tcod.getSelectedItem(), tnome.getText());
        }
        // BOTTONE OK INTERFACCIA INSERISCI NUOVO ORDINE PER FORNITORE
        if(e.getSource()==bOKOrdineFor){
            if(of_nome.getSelectedItem()=="Seleziona..." && of_cod.getSelectedItem()=="Seleziona..." && (piva_f.getSelectedItem()=="" ||piva_f.getSelectedItem()=="Seleziona...") &&
                    op_numpezzi.getText().length()==0) {
                JFrame f0 = new JFrame();
                JOptionPane.showMessageDialog(f0, "ERRORE: inserire i dati.", "ATTENZIONE", 0);
            }
            else {
                if(of_nome.getSelectedItem()!="Seleziona..." && of_cod.getSelectedItem()!="Seleziona..."
                        && op_numpezzi.getText().length()!=0)
                {
                    frame.setVisible(false);
                    f = new JFrame("PREZZO TOTALE");
                    f.setLocation(600, 200);
                    f.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    f.getContentPane().setLayout(new BorderLayout());


                    JPanel pannello7 = new JPanel();
                    pannello7.setLayout(new FlowLayout());
                    JLabel lprezzoTotale = new JLabel("PREZZO TOTALE");
                    ImpostaFont(lprezzoTotale,14);
                    pannello7.add(lprezzoTotale);
                    JTextField tPrezzoTotale = new JTextField();
                    tPrezzoTotale.setEditable(false);
                    tPrezzoTotale.setPreferredSize(new Dimension(250, 25));
                    double tmp_prezzo = ActionsOnDB.CalcolaPrezzo((String) of_cod.getSelectedItem(), Integer.parseInt(op_numpezzi.getText()));
                    tPrezzoTotale.setText(tmp_prezzo + " euro");
                    pannello7.add(tPrezzoTotale);
                    f.getContentPane().add(pannello7, BorderLayout.NORTH);
                    CambiaColore(pannello7);

                    JPanel pannello6 = new JPanel();
                    pannello6.setLayout(new FlowLayout());
                    binserisciOrdineFor = new JButton("INSERISCI");
                    ImpostaFont(binserisciOrdineFor,16);
                    //binserisciOrdineFor.setPreferredSize(new Dimension(100, 50));
                    binserisciOrdineFor.addActionListener(this);
                    bBack = new JButton("Torna indietro");
                    bBack.addActionListener(this);
                    pannello6.add(binserisciOrdineFor);
                    pannello6.add(bBack);
                    f.getContentPane().add(pannello6, BorderLayout.CENTER);

                    f.pack();
                    f.setVisible(true);
                    CambiaColore(pannello6);
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "ERRORE: inserire i dati.", "ATTENZIONE", 0);
                }
            }
        }
        // BOTTONE TORNA INDIETRO A INTERFACCIA NUOVO ORDINE PER FORNITORE
        if(e.getSource()==bBack){
            frame.setVisible(true);
        }
        // BOTTONE CERCA CLIENTE DA TENDINA
        if(e.getSource()==cercaC){
            CercaCliente();
        }
        // BOTTONE CHIUDI INTERFACCIA CERCA CLIENTE
        if(e.getSource()==bchiudiCercaClient){
            ChiudiCercaClient();
            pannelloSudc.setVisible(false);
        }
        // BOTTONE OK IN CERCA CLIENTE IN INTERFACCIA (NOME, COGNOME)
        if(e.getSource()==okcercaClient){
            if(tnomeC.getText().length()==0 && tcognome.getText().length()==0){
                JOptionPane.showMessageDialog(new JFrame(), "Prego, inserire i dati per la ricerca.", "ATTENZIONE", 2);
            }
            else {
                if(tnomeC.getText().length()==0 || tcognome.getText().length()==0){
                    JOptionPane.showMessageDialog(new JFrame(), "Prego, inserire i dati per la ricerca.", "ATTENZIONE", 2);
                }
                else{
                    String[] elenco_cf=ActionsOnDB.CercaCliente(tnomeC.getText(), tcognome.getText());
                    if(elenco_cf[0]=="error"){
                        JOptionPane.showMessageDialog(new JFrame(), "I dati inseriti non sono stati trovati. RIPROVARE.", "ERRORE", 0);
                        nuovoClient.setVisible(true);
                        tnomeC.setText("");
                        tcognome.setText("");
                    }
                    else{
                        pannelloComboCf = new JPanel();
                        pannelloComboCf.setLayout(new FlowLayout());
                        pannelloComboCf.setPreferredSize(new Dimension(400, 100));
                        JLabel lcf = new JLabel("CODICE FISCALE");
                        ImpostaFont(lcf,14);
                        tcf = new JComboBox(elenco_cf);
                        tcf.setPreferredSize(new Dimension(250, 25));
                        tcf.addActionListener(this);
                        newRicercaClient = new JButton("NUOVA RICERCA");
                        ImpostaFont(newRicercaClient,16);
                        newRicercaClient.addActionListener(this);
                        pannelloComboCf.add(lcf);
                        pannelloComboCf.add(tcf);
                        pannelloComboCf.add(newRicercaClient);
                        CambiaColore(pannelloComboCf);
                        pannelloEsternoCercaC.add(pannelloComboCf, BorderLayout.CENTER);

                        pannelloCentroC.setVisible(true);
                        okcercaClient.removeActionListener(this);

                        nuovoClient.setVisible(true);
                        elimanaClient.setVisible(true);

                        frame.setVisible(true);
                    }
                }
            }
        }
        // BOTTONE CONFERMA MODIFICA PRODOTTO DA CERCA PRODOTTO
        if(e.getSource()==bmodificaProd){
            if(prezzo.getText().length()!=0 && numpezzi.getText().length()!=0) {
                boolean chk = ActionsOnDB.ModificaProd(Double.parseDouble(prezzo.getText()), Integer.parseInt(numpezzi.getText()), cod.getText());
                if(chk==true){
                    JOptionPane.showMessageDialog(new JFrame(), "I dati sono stati modificati correttamente", "ACCESSO RIUSCITO", 1);
                    ChiudiInsProdotto();
                    pannelloModificaProd.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "I dati NON sono stati modificati. RIPROVARE", "ERRORE", 0);
                }
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "Prego inserire i dati.", "ATTENZIONE", 2);
            }
        }
        // BOTTONE CHIUDI MODIFICA DA MODIFICA PRODOTTO IN CERCA PRODOTTO
        if(e.getSource()==bchiudiModifica){
            ChiudiInsProdotto();
            pannelloModificaProd.setVisible(false);
        }
        // BOTTONE NUOVA RICERCA CLIENTE
        if(e.getSource()==newRicercaClient){
            tnomeC.setText("");
            tcognome.setText("");
            tcf.removeAllItems();
            pannelloComboCf.setVisible(false);
            pannelloCentroC.setVisible(false);
            nuovoClient.setVisible(false);
            elimanaClient.setVisible(false);
            okcercaClient.addActionListener(this);
        }
        // TROVA DESCRIZIONE CLIENTE DATO NOME, COGNOME, CF, email CLIENTE (CERCA CLIENTE)
        if(e.getSource()==tcf){
            editorClient.setVisible(true);
            editorClient.setText(ActionsOnDB.RiepilogoCliente((String) tcf.getSelectedItem()));
            editorClient.setEditable(false);
            frame.setVisible(true);
        }
        // BOTTONE NUOVO CLIENTE DA CERCA CLIENTE
        if(e.getSource()==nuovoClient){
            ChiudiCercaClient();
            pannelloSudc.setVisible(false);
            ClienteInsFrame();
        }
        //BOTTONE ELIMINA CLIENTE DA CERCA CLIENTE
        if(e.getSource()==elimanaClient){
            if(tcf.getSelectedItem()!="Seleziona..." || tcf.getSelectedItem()!="") {
                boolean val= ActionsOnDB.EliminaClient((String) tcf.getSelectedItem());
                if(val==true){
                    JOptionPane.showMessageDialog(new JFrame(), "Il cliente selezionato è stato eliminato correttamente.", "ELIMINAZIONE",1);
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "ERRORE, il cliente selezionato non è stato eliminato correttamente poiché è presente in un'altra struttura.", "ATTENZIONE",0);
                }
                pannelloCentroC.setVisible(false);
                nuovoClient.setVisible(false);
                elimanaClient.setVisible(false);
                pannelloComboCf.setVisible(false);
                tnomeC.setText("");
                tcognome.setText("");
                okcercaClient.addActionListener(this);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "ERRORE RIPROVA", "ATTENZIONE",0);
            }
        }
        // BOTTONE CERCA FORNITORE DA TENDINA
        if(e.getSource()==cercaF){
            CercaFornitore();
        }
        // BOTTONE CHIUDI CERCA FORNITORE
        if(e.getSource()==bchiudiCercaFor){
            ChiudiCercaFor();
            pannelloSudF.setVisible(false);
        }
        // BOTTONE OK CERCA FORNITORE DA TENDINA
        if(e.getSource()==okcercaFor){
            if(tnomeF.getText().length()!=0){
                String[] elenco_iva=ActionsOnDB.CercaFornitore(tnomeF.getText());
                if(elenco_iva[0]=="error"){
                    JOptionPane.showMessageDialog(new JFrame(), "I dati inseriti non sono stati trovati. RIPROVARE.", "ERRORE", 0);
                    nuovoFor.setVisible(true);
                    tnomeF.setText("");
                }
                else{
                    pannelloComboFor = new JPanel();
                    pannelloComboFor.setLayout(new FlowLayout());
                    pannelloComboFor.setPreferredSize(new Dimension(400, 100));
                    JLabel liva = new JLabel("PARTITA IVA");
                    ImpostaFont(liva,14);
                    tfor = new JComboBox(elenco_iva);
                    tfor.setPreferredSize(new Dimension(250, 25));
                    tfor.addActionListener(this);
                    newRicercaFor = new JButton("NUOVA RICERCA");
                    ImpostaFont(newRicercaFor,16);
                    newRicercaFor.addActionListener(this);
                    pannelloComboFor.add(liva);
                    pannelloComboFor.add(tfor);
                    pannelloComboFor.add(newRicercaFor);
                    CambiaColore(pannelloComboFor);
                    pannelloEsternoCercaF.add(pannelloComboFor, BorderLayout.CENTER);

                    pannelloCentroF.setVisible(true);
                    okcercaFor.removeActionListener(this);

                    nuovoFor.setVisible(true);
                    elimanaFor.setVisible(true);

                    frame.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "Prego, inserire i dati per la ricerca.", "ATTENZIONE", 2);
            }
        }
        // BOTTONE NUOVA RICERCA FORNITORE
        if(e.getSource()==newRicercaFor){
            tnomeF.setText("");
            tfor.removeAllItems();
            pannelloComboFor.setVisible(false);
            pannelloCentroF.setVisible(false);
            nuovoFor.setVisible(false);
            elimanaFor.setVisible(false);
            okcercaFor.addActionListener(this);
        }
        // BOTTONE NUOVO FORNITORE DA CERCA FORNITORE
        if(e.getSource()==nuovoFor){
            ChiudiCercaFor();
            pannelloSudF.setVisible(false);
            FornitoreInsFrame();
        }
        //BOTTONE ELIMINA FORNITORE DA CERCA FORNITORE
        if(e.getSource()==elimanaFor){
            if(tfor.getSelectedItem()!="Seleziona..." || tcod.getSelectedItem()!="") {
                boolean val= ActionsOnDB.EliminaFor((String) tfor.getSelectedItem());
                if(val==true){
                    JOptionPane.showMessageDialog(new JFrame(), "Il fornitore selezionato è stato eliminato correttamente.", "ELIMINAZIONE",1);
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "ERRORE, il fornitore selezionato non è stato eliminato correttamente poiché è presente in un'altra struttura.", "ATTENZIONE",0);
                }
                pannelloCentroF.setVisible(false);
                nuovoFor.setVisible(false);
                elimanaFor.setVisible(false);
                pannelloComboFor.setVisible(false);
                tnomeF.setText("");
                okcercaFor.addActionListener(this);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "ERRORE RIPROVA", "ATTENZIONE",0);
            }
        }
        // TROVA DESCRIZIONE FONRITORE DATO NOME, PIVA FORNITORE (CERCA FORNITORE)
        if(e.getSource()==tfor){
            editorFor.setVisible(true);
            editorFor.setText(ActionsOnDB.RiepilogoFornitore((String) tfor.getSelectedItem()));
            editorFor.setEditable(false);
            frame.setVisible(true);
        }

    }

    public static void main(String[] argv){
            Home hm= new Home();
            hm.HomeFrame();
    }
}