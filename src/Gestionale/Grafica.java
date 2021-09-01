package Gestionale;

import javax.swing.*;
import java.awt.*;

public class Grafica extends JPanel {

    public static void main(String[]argv){
        String[] fontina=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for(int i=0;i< fontina.length; ++i){
            System.out.println(fontina[i]);
        }
    }
}
