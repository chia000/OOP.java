package Frutta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton bI,bD;

    App(){
        super("FRUTTI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());

        JLabel l1=new JLabel("Tipo");
        t1=new JTextField();
        t1.setPreferredSize(new Dimension(150,20));
        JLabel l2=new JLabel("Codice");
        t2=new JTextField();
        t2.setPreferredSize(new Dimension(150,20));
        bI =new JButton("INSERISCI");
        bI.addActionListener(this);
        bD =new JButton("CANCELLA");
        bD.addActionListener(this);

        this.getContentPane().add(l1);
        this.getContentPane().add(t1);
        this.getContentPane().add(l2);
        this.getContentPane().add(t2);
        this.getContentPane().add(bI);
        this.getContentPane().add(bD);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bI){
            Frutto frutto=new Frutto();
            frutto.setCodice(Integer.parseInt(t2.getText()));
            frutto.setTipo(t1.getText());
            Boolean val= Inserimento.Inserisci(frutto.getTipo(),frutto.getCodice());
            if(val==true)
            {
                System.out.println("Inserimento di: "+ frutto.getTipo() + " "+ frutto.getCodice()+" RIUSCITO CORREMAMENTE");
                JFrame frame=new JFrame();
                JOptionPane.showMessageDialog(frame,"Inserimento riuscito correttamente");
            }
            else{
                JFrame frame=new JFrame();
                JOptionPane.showMessageDialog(frame,"Inserimento NON è riuscito correttamente");
            }
        }
        if (e.getSource() == bD) {
            Frutto frutto = new Frutto();
            frutto.setCodice(Integer.parseInt(t2.getText()));
            frutto.setTipo(t1.getText());
            boolean val=Inserimento.Delete(frutto.getTipo(), frutto.getCodice());
            if(val==true) {
                System.out.println("Cancellazione di: " + frutto.getTipo() + " " + frutto.getCodice() + " RIUSCITO CORREMAMENTE");
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Cancellazione riuscita correttamente");
            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Cancellazione NON è riuscita correttamente");
            }
        }
    }


public static void main(String[] argv){
        App frame=new App();
}
}
