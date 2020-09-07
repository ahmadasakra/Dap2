package Sort;

public class SelectionSort {

    void sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }


    int max(int arr[]) {

        int max = arr[0];

        if (arr.length == 0) return 0;
        else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }


    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64, 25, 12, 22, 11};
        ob.printArray(arr);
        ob.sort(arr);
        System.out.println("Feld sortiert ist: ");
        ob.printArray(arr);
        System.out.println("Maximum ist: " + arr[arr.length-1]);
    }


}
