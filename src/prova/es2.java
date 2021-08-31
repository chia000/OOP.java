package prova;
import java.util.Scanner;

public class es2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n;
        System.out.println("Inserisci un numero: ");
        n=in.nextInt();
        if(n>0){
            System.out.println("Questo numero è positivo");
        }
        else{
            System.out.println("Questo numero è negativo");
        }
    }
}
