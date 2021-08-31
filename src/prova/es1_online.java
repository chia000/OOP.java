package prova;
import java.util.Scanner;
public class es1_online {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n1, n2;
        System.out.println("Immettere il primo numero: ");
        n1=in.nextInt();
        System.out.println("Immettere il secondo numero: ");
        n2=in.nextInt();

        if(n1>=0 && n1<=1 && n2>=0 && n2<=1 ){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
