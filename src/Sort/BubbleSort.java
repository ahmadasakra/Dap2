package Sort;
import java.util.Arrays;
import java.util.Random;
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j > i + 1; j--) {
                if (array[j - 1] >= array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        if(args.length>0){
            System.out.print("FEHLER: Es gibt zu viele Parametren ");
        }
        else {
            // Es wird die Laufzeit der Befuellung
            long tStart, tEnd;
            double secs;
            int feld[] = new int[50000];
            tStart = System.currentTimeMillis();
            befuellung(feld);
            tEnd = System.currentTimeMillis();
            secs = (tEnd - tStart) / 1000.0;
            // bubbleSort(feld),wenn es den Feld sortiert gefragt wurde, wird die Methode bubbleSort aufgerufen.
            System.out.print(secs + "s");

        }

    }

    public static void befuellung(int[] array){
        java.util.Random random = new java.util.Random();
        array[array.length-1] = random.nextInt(10);
        for(int i = array.length-2; i >= 0; i--){
            array[i] = random.nextInt(10) + array[i+1];
        }
    }

}