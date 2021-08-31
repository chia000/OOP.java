package prova;
import java.util.Arrays;

public class es_vettore {
    public static void main(String[] args){
        int num_array[]={
                10, 1, 6, 9, 5, 8
        };

        String alfa_array[]={
                "Chiara",
                "Mamma",
                "Papà",
                "Zoe",
                "Dolly"
        };
        System.out.println("Vettore numerico: "+ Arrays.toString(num_array));
        Arrays.sort(num_array);
        System.out.println("Vettore numerico ordinato: "+ Arrays.toString(num_array));
        System.out.println("Vettore di stringhe: "+ Arrays.toString(alfa_array));
        Arrays.sort(alfa_array);
        System.out.println("Vettore di stringhe ordinato: "+ Arrays.toString(alfa_array));
    }
}
