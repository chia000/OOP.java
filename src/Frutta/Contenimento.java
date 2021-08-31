package Frutta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Contenimento {

    public static void Premi(JButton b){
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b){
                    System.out.println("Riuscito!");
                    ConnessioneDB.Inserisci();

                }
            }
        });
    }

    public static void main(String[] argv){
        JFrame f=new JFrame();
        JButton b=new JButton("Inserisci");
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(b);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Premi(b);
    }
}
