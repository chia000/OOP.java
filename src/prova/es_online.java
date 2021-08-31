/*
L'utente inserisce 4 numeri e il programma dice se sono uguali oppure no.
 */

package prova;
import java.util.Scanner;

public class es_online {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1, n2, n3, n4;
        System.out.println("Immettere il primo numero: ");
        n1=in.nextInt();
        System.out.println("Immettere il secondo numero: ");
        n2=in.nextInt();
        System.out.println("Immettere il terzo numero: ");
        n3=in.nextInt();
        System.out.println("Immettere il quarto numero: ");
        n4=in.nextInt();

        if(n1==n2){
            if(n1==n3){
                if(n1==n4) {
                    System.out.println("I numeri sono uguali!");
                }
                else{
                    System.out.println("I numeri non sono uguali!");
                }
            }
            else{
                System.out.println("I numeri non sono uguali!");
            }
        }
        else{
            System.out.println("I numeri non sono uguali!");
        }
    }
}
