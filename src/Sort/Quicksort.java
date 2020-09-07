package Sort;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Quicksort {

    public static void main(String [] args){

        int parameter = 0;  // fuer die erste Parameter, die angegeben werden muss.
        long tStart, tEnd, mSecs; // Zur Berechnung der Laufzeit.

        if(args.length >1 || args.length<1){
            System.out.print("FEHLER: Keine gueltige Parameter eingegeben , bitte Geben Sie nur eine Zahl ein.");
        }else {
            try {
                parameter = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Keine gueltige Eingabe !");
                System.exit(0);
            }

            if(parameter>=1){

                int arr[] = new int[parameter];

                // Es werden zufaelige Zahlen in das Array arr hinzufuegt.
                Random random = new Random();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = random.nextInt();
                }

                tStart = System.currentTimeMillis();
                Quicksort(arr, 0, parameter - 1);
                tEnd = System.currentTimeMillis();
                mSecs = tEnd - tStart;

                assert isSorted(arr) : "Das Feld ist aufsteigend nicht sortiert !";

                System.out.println("Das Feld ist sortiert");
                System.out.println("Das Feld hat " + mSecs + "ms gedauert.");

                /* Wenn Sie die Laufzeit vom MergeSort-,InsertionSort- und BubbleSort-Algorithmus
                vergleichen will, können Sie die Methoden (insertionSort, bubbleSort, mergeSort)
                in derselben Klasse aufrufen.
                */

            }else{
                System.out.println("FEHLER: Bitte geben Sie eine Zahl groesser als 0 !");
                System.exit(0);
            }
        }
    }

    public static int med3(int arr[], int l, int r){
        return Median(arr[l],arr[(l+r)/2],arr[r]);
    }

    public static int ninther(int arr[], int l, int r){

        int m1,m2;
        m1 = l+(r-l)*1/3;
        m2 = l+(r-l)*2/3;

        return Median(med3(arr,l,m1),med3(arr,m1,m2),med3(arr,m2,r));

    }

    public static int Median(int a, int b, int c){ // Es wird den Wert des Median zurueckgegeben.

        int median = a;

        if((a <= b && b <= c) || (c <= b && b <= a)){
            median = b;
        }
        else if ((a <= c && c <= b) || (b <= c && c <= a)){
            median = c;
        }
        return median;
    }

    public static void Quicksort(int arr[], int l, int r){ // Diese Methode wird das Feld per QuickSort sortieren.

        int i = l, j = r;
        int tmp = 0;
        if(l<r){
            i = l;
            j = r;
            int pivot = ninther(arr,l,r);
            while (i<=j){
                while (arr[i]<pivot){
                    i+=1;
                }
                while (arr[j]>pivot){
                    j -= 1;
                }
                if(i<=j){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i +=1;
                    j-=1;

                }
            }
            Quicksort(arr,l,j);
            Quicksort(arr,i,r);

        }
    }

    public static boolean isSorted(int[] array){ // Diese Methode prüft, ob das Feld aufsteigend sortiert oder nicht.

        for(int i =1; i<array.length; i++){
            if (array[i]<array[i-1]){
                return false;
            }
        }
        return true;

    }


// ---------------     ---------------    ---------------

    // Zum Vergleich der anderen Sortierung-Algorithmen kannst du in main-Methode irgendwelches Algorithmus aufrufen.

//---------------     ---------------    ---------------

    // Die BubbleSort Algorithmus wird die Methode "bubbleSort" aufgerufen .
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

    // Die InsertionSort Algorithmus wird die Methode "insertionSort" aufgerufen .
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

    // Die Merge-Sort Algorithmus wird die Methode "mergeSort" aufgerufen .
    public static void mergeSort(int[] array) {
        // zur Berechnung der Laufzeit.
        long tStart, tEnd, msecs;
        tStart = System.currentTimeMillis();

        if (array.length <=100) {
            System.out.println(Arrays.toString(array));
        }

        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);

        tEnd = System.currentTimeMillis();
        msecs = tEnd-tStart;

        System.out.println(Arrays.toString(array));
        System.out.println("Laufzeit hat  " + msecs + " gedauert");
        //  isSorted sichert, ob das Array sortiert ist.
        assert isSorted(array);

    }
    public static void mergeSort(int[] array, int[] tmpArray, int left, int right){

        if(left<right){
            int q = (left+right)/2; //Mittelwertder der Zahlen.
            mergeSort(array,tmpArray,left,q);
            mergeSort(array,tmpArray,q+1,right);
            // Zusammenführen des Arrays
            MergeSort(array,tmpArray,left,q+1,right);
        }

    }
    public static void MergeSort(int[] array, int[] tmpArray, int left, int center, int right) {

        int i, j;

        // Von der linken Grenze bis zur Mitte werden die in temporaren tmpArray gespeichert.
        for(i = left; i < center; i++){
            tmpArray[i] = array[i];
        }

        //Von der Mitte zu letzter Zahl in temporären tmpArray gespeichert.
        for(j = center; j <= right; j++){
            tmpArray[right + center - j] = array[j];
        }

        i = left;
        j = right;

        for(int k = left; k <= right; k++){
            if(tmpArray[i] >= tmpArray[j]){
                array[k] = tmpArray[i++];
            }
            else{
                array[k] = tmpArray[j--];
            }
        }
    }



}
