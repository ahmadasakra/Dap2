    package Sort;
    import java.util.Arrays;
    public class Sortierung extends InsertionSort{


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

        public static void main(String [] args){
            assert (args.length==1 || args.length==2 || args.length==3):"Sie haben keine Zahl gegeben";
            try {
                int a = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

            assert (Integer.parseInt(args[0]) >= 0) : "java Sortierung -Ganzzahl- [insert|merge [auf|ab|rand]]";

            int arrOp1 [] = new int[Integer.parseInt(args[0])];
            int op1 = args.length;
            java.util.Random numberGenerator = new java.util.Random();

            if (args.length==1)
            {
                for(int i =0; i<arrOp1.length; i++)  {
                    arrOp1[i] =  numberGenerator.nextInt();
                }
           //     mergeSort(arrOp1);
            }
            else if(args.length ==2 ){
                assert(args[1].equals("insert") || args[1].equals("merge")):"Der erste optionale Parameter soll nur [merge|insert] sein";

                for(int i =0; i<arrOp1.length; i++)  {
                    arrOp1[i] =  numberGenerator.nextInt();
                }

                if(args[1].equals("insert")){
                    insertionSort(arrOp1);
                }else if (args[1].equals("merge")){
                    mergeSort(arrOp1);
                }}

            if (args.length==3)
            { assert (args[2].equals("ab") || args[2].equals("auf") || args[2].equals("rand")):"der naechste Parameter soll nur [ab|auf|rand] sein";
                assert(args[1].equals("insert") || args[1].equals("merge")):"Der erste optionale Parameter soll nur [merge|insert] sein";
                if(args[2].equals("auf")) {
                    for(int i =0; i<arrOp1.length;i++){
                        arrOp1[i] = i;
                    }
                }else if(args[2].equals("ab")){
                    for(int i =0; i<arrOp1.length;i++){
                        arrOp1[i] = op1--;
                    }
                }else if(args[2].equals("rand")){
                    for(int i =0; i<arrOp1.length; i++)  {
                        arrOp1[i] =  numberGenerator.nextInt();
                    }}
                if(args[1].equals("insert")){
                    insertionSort(arrOp1);
                }else if (args[1].equals("merge")){
                    mergeSort(arrOp1);
                }
            }
            // Es wird bestaetigt, ob es sortiert ist.
            assert(isSorted(arrOp1)): "Fehler: nicht sortiert";
            System.out.println("Feld ist sortiert");

        }


    }