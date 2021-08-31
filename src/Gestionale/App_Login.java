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
        this.setPreferredSize(new Dimension(300,150));
        this.setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JLabel l1=new JLabel("Username: ");
        t1=new JTextField();
        t1.setPreferredSize(new Dimension(150,20));
        JLabel l2=new JLabel("Password: ");
        t2=new JPasswordField();
        t2.setPreferredSize(new Dimension(150,20));

        JPanel nord=new JPanel();
        nord.setLayout(new FlowLayout());
        nord.add(l1);
        nord.add(t1);
        this.getContentPane().add(nord,BorderLayout.NORTH);

        JPanel central=new JPanel();
        central.setLayout(new FlowLayout());
        central.add(l2);
        central.add(t2);
        this.getContentPane().add(central,BorderLayout.CENTER);

        bInsert=new JButton("OK");
        bInsert.addActionListener(this);
        this.getContentPane().add(bInsert,BorderLayout.SOUTH);

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