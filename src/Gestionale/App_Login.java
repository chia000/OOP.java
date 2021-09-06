package Gestionale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App_Login extends JFrame implements ActionListener {

    JTextField t1;
    JPasswordField t2;
    JButton bInsert;

    App_Login(){
        super("Login");
        this.setPreferredSize(new Dimension(300,200));
        this.setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image icona = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Claudio\\Desktop\\OOP.java\\src\\Gestionale\\IconaProgettoBlu.jpg");
        this.setIconImage(icona);
        this.getContentPane().setLayout(new BorderLayout());

        JLabel l1=new JLabel("Username: ");
        Home.ImpostaFont(l1,14);
        t1=new JTextField();
        t1.setPreferredSize(new Dimension(150,20));
        JLabel l2=new JLabel("Password: ");
        Home.ImpostaFont(l2,14);
        t2=new JPasswordField();
        t2.setPreferredSize(new Dimension(150,20));

        JPanel nord=new JPanel();
        nord.setLayout(new FlowLayout());
        nord.setPreferredSize(new Dimension(250,50));
        Home.CambiaColore(nord);
        JLabel lbenvenuto= new JLabel("Benvenuto/a su GestioniaMO!");
        JLabel lins=new JLabel("Inserisci le tue credenziali di accesso:");
        nord.add(lbenvenuto);
        nord.add(lins);
        this.getContentPane().add(nord,BorderLayout.NORTH);

        JPanel central=new JPanel();
        central.setLayout(new FlowLayout());
        Home.CambiaColore(central);
        central.add(l1);
        central.add(t1);
        this.getContentPane().add(central,BorderLayout.CENTER);

        JPanel sud= new JPanel();
        sud.setLayout(new FlowLayout());
        sud.setPreferredSize(new Dimension(250,80));
        Home.CambiaColore(sud);
        bInsert=new JButton("OK");
        bInsert.addActionListener(this);
        sud.add(l2);
        sud.add(t2);
        sud.add(bInsert);
        this.getContentPane().add(sud, BorderLayout.SOUTH);
        //this.getContentPane().add(bInsert,BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bInsert) {
            String utente=t1.getText();
            boolean press=ActionsOnDB.OkUser(utente, t2.getText());
            if(press==true){
                JFrame dialog=new JFrame();
                JOptionPane.showMessageDialog(dialog,"ACCESSO CONSENTITO. Benvenuto utente "+utente);
                this.setVisible(false);
                Home hm= new Home();
                hm.HomeFrame();
            }
            else{
                JFrame dialog=new JFrame();
                JOptionPane.showMessageDialog(dialog,"ACCESSO NEGATO. Riprova.");
                t1.setText("");
                t2.setText("");
            }
        }
    }


    public static void main(String[] argv){

        App_Login frame=new App_Login();
    }

}