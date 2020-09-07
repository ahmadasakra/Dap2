package Sort;
import java.util.SimpleTimeZone;
import javax.naming.PartialResultException;
import java.util.Arrays;
public class InsertionSort  {
    public static void insertionSort(int [] array) {

        // zur Berechnung der Laufzeit.
        long tStart, tEnd, msecs;
        tStart = System.currentTimeMillis();

        if (array.length <=100) {
            for(int i =0; i<array.length; i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }


        // Das Array wird absteigend sortiert.
        for (int i = 1; i < array.length; i++) {

            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] <= temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        System.out.print(array[i] + ",");
        }
        tEnd = System.currentTimeMillis();
        msecs = tEnd - tStart;
        System.out.println();
        System.out.println ("Laufzeit hat "+ msecs+" ms "+"gedauert");
    }

    // In dieser Methode wird überprüft, ob es absteigend sortiert ist.
    public static boolean isSorted(int[] array){

        for(int i =0; i<array.length-1; i++){
            if (array[i]<array[i+1]){
                return false;
            }
        }
        return true;

    }

    public static void main(String [] args){
        int l = 0;
        //prüft und sichert,ob die Länge 1 oder erwünsct 2 ist.
if(args.length == 1 || args.length ==2) {
    // Es wird die ganze Zahl übernommen und das Array initialisiert.
    try {
        int a = Integer.parseInt(args[0]);
    } catch (Exception e) {
        System.out.print("Fehler: ");
        e.printStackTrace();
    }
    //Es wird sichert,ob die Zahl gütlig ist.
    assert (Integer.parseInt(args[0]) > 0) : "Sie haben eine Ganzzahl anzugeben: java Sortierung Ganzzahl [insert|merge [auf|ab|rand]]";
    int arrOp[] = new int[Integer.parseInt(args[0])];
    int op = args.length;
    // um Zufallszahlen zu generieren
    java.util.Random numberGenerator = new java.util.Random();
    // Zweiter Parameter soll auf , ab oder rand sein.
    if (args.length == 2) {
        if (args[1].equals("auf")) {

            for (int i = 0; i < arrOp.length; i++) {
                arrOp[i] = l;
                l++;
            }
        } else if (args[1].equals("ab")) {
            for (int i = 0; i < arrOp.length; i++) {
                arrOp[i] = op--;
            }
        } else if (args[1].equals("rand")) { // Zufallszahlen kommen von Klasse Random.
            for (int i = 0; i < arrOp.length; i++) {
                arrOp[i] = numberGenerator.nextInt();
            }
        }
    } else if (args.length == 1) { // wenn es weder auf noch ab stehe, kommt direkt zu
        for (int i = 0; i < arrOp.length; i++) {
            arrOp[i] = numberGenerator.nextInt();
        }
    }
    insertionSort(arrOp);
    if (isSorted(arrOp)) {
        System.out.println("Feld ist sortiert.");
    }

}else{
    System.out.print("Fehler: keine gueltige Eingaben.");
}

    }





}