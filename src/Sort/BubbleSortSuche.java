package Sort;
public class BubbleSortSuche {


    public static void main(String [] args){

        float parameter = 0f;
        
        if (args.length >1) {
            System.out.println("FEHLER: Es muss nur ein Parameter eingegeben werden");
            System.exit(0);
        }

        else if (args.length == 0) {
            System.out.println("FEHLER: Es muss ein Parameter eingegeben werden");
        }
        else {
            try{
                parameter = Float.parseFloat(args[0]); // um Eingabeaufforderung zu erkennen.
            }
            // Es werden einige Fehler , wenn es keine gültige Zahl git.
            catch(NumberFormatException e){
                System.out.println("FEHLER : Es ist nur Ganzzahl erwünscht");
                System.exit(0);
            }
            if(Float.parseFloat(args[0]) < 0){
                System.out.println("FEHLER: Keine gueltige Zahl");
            }
            else {

                double time = 0;
                long tStart, tEnd; // zur Berechnung der Laufzeit.
                int[] arr = new int[1000];
                ausfuelen(arr); // zur Befüllung des Arrays.
                tStart = System.currentTimeMillis();
                bubbleSort(arr); // Zum Sortieren des ausgefüllten Arrays.
                tEnd = System.currentTimeMillis();
                time =  (tEnd - tStart)/1000.0; // Laufzeit in Sekunden ausgegeben.
                System.out.println("Size: " + arr.length + ", " + "Time: " +time+"s");


                while(time < parameter - 0.1f){ // läuft , wenn Time-BubbleSort schneller(<) als die eingegebene Zeit ist.

                    arr = new int[arr.length * 2]; //die Feldgröße wird verdoppelt.
                    ausfuelen(arr); // füllt das neue Array wieder auf.
                    tStart = System.currentTimeMillis();
                    bubbleSort(arr); //Sortiert das aufgefüllte Array.
                    tEnd = System.currentTimeMillis();
                    time =  (tEnd - tStart)/1000.0 ; // Laufzeit in sekonden.

                    System.out.println("Size: " + arr.length + ", " + "Time: " +time+"s");
                }


                tertiareSuche(arr,parameter , arr.length/2 , arr.length);


            }
        }
    }

    public static void ausfuelen (int array[]) {
// es wird das Feld zufällige Zahlen in absteigender Reihenfolge initialisiert.
        java.util.Random random = new java.util.Random();

        array[array.length-1] = random.nextInt(10);
        for(int i = array.length-2; i >= 0; i--){
            array[i] = random.nextInt(10) + array[i+1];
        }

    }

    public static double bubbleSort(int[] array){
        double secs ;
        long tstart, tend; // zur Berechnung der Laufzeit
        int n = array.length;
        tstart = System.currentTimeMillis();

        for (int i =0 ;i<array.length;i++) { // Zum Sortieren des Arrays, aufsteigend.

            for (int j =n-1 ;j>=i+1 ; j--) {
                if( array [j-1] >= array[j]) {
                    int tmp =array[j];
                    array[j]= array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
        tend = System.currentTimeMillis();
        secs = (tend - tstart)/1000.0 ; // gibt den Laufzeit in Sekunden(Hinweise) zurück.
        return secs ;
    }

    public static void tertiareSuche(int[] array, float n, int left, int right){
// Einige Variable werden deklariert, um die Laufzeit zu messen, temporäre Sizen zu speichern ..

        float time = 0;
        long tStart, tEnd;
        int iter3;
        float t = 0;
        int l = 0;
        int count =0;
        int tmp[] = new int [4];
        float tmp1[] = new float [4];
        int iter2 =left;
        tmp[0]=array.length;

        while(time < (n - 0.2f) || time > n){ // Solange die Time wenider als n-0f f .

            iter3=(right-left)/3; // wird der Suchbereich in drei gleichgroße Teile geteilt.
            array = new int[left];
            ausfuelen(array); // füllt das Array im Feld und dann wir die Laufzeit in Sekunden für Sortierung berechnet.
            tStart = System.currentTimeMillis();
            bubbleSort(array);
            tEnd = System.currentTimeMillis();
            time = tEnd - tStart;
            time /= 1000.0;

            if(time < (n - 0.1f)) {
                left =left+iter3;
            }else{
                left = iter2;
                iter3 =iter3/3;
            }

            if (time <= (n - 0.01f) ) {
                l = array.length;
                t=time;}

            if (count<4) {
                tmp[count]=array.length;
                tmp1[count]=time;
                count++;
            }
            if (count==4) { // wenn die 4 Paramerten erfuellt sind, werden die Sizes und Times angeben..

                System.out.print("Sizes: ");
                for (int j =0; j<count ;j++) {
                    if (j!= count-1) {
                        System.out.print(tmp[j] + ", ");
                    }else{
                        System.out.print(tmp[j] );
                    }
                }

                System.out.println();
                System.out.print("Times: ");
                for (int j =0 ; j<=3 ;j++) {
                    if (j!= 3){
                        System.out.print(tmp1[j] +"s" + ", ");
                    }else{
                        System.out.print(tmp1[j] + "s" );
                    }
                }

                System.out.println();
                count=0; // damit es wieder von Anfag für nächsten Durchlauf beginnt.
            }
        }

        if (count>0) {

            System.out.print("Sizes: ");
            for (int j=0 ; j<count; j++) {
                if (j!= count-1) {
                    System.out.print(tmp[j] + ", ");
                }else{
                    System.out.print(tmp[j]);
                }
            }

            System.out.println();
            System.out.print("Times: ");
            for (int j=0 ; j<count;j++) {
                if (j!= count-1) {
                    System.out.print(tmp1[j]+ "s" + ", ");
                }else{
                    System.out.print(tmp1[j] + "s");
                }
            }
            count=0;
            System.out.println();
        }

        System.out.print("Size: "+l + ", "+ "Time: "+t+"s");

    }



}
