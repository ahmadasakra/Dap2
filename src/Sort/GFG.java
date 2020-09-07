package Sort;
// Java program to find shortest superstring using Greedy
// Approximate Algorithm
import java.io.*;
import java.util.*;
class GFG {
    static String str;


    static int min(int a, int b)
    {
        return (a < b) ? a : b;
    }

    static int findOverlappingPair(String str1, String str2) {
        int max = Integer.MIN_VALUE;
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = 1; i <= min(len1, len2); i++) {
            if (str1.substring(len1 - i).compareTo(str2.substring(0, i)) == 0) {
                if (max < i) {

                    max = i;
                    str = str1 + str2.substring(i);
                }
            }
        }

        for (int i = 1; i <= min(len1, len2); i++) {
            if (str1.substring(0, i).compareTo(str2.substring(len2 - i)) == 0) {
                if (max < i) {
                    max = i;
                    str = str2 + str1.substring(i);
                }
            }
        }

        return max;
    }

    static String findShortestSuperstring(String arr[], int len) {

        while (len != 1) {

            int max = Integer.MIN_VALUE;
            int l = 0, r = 0;

            String resStr = "";

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int res = findOverlappingPair(arr[i], arr[j]);
                    if (max < res) {
                        max = res;
                        resStr = str;
                        l = i;
                        r = j;
                    }
                }
            }
            len--;

            if (max == Integer.MIN_VALUE) {
                arr[0] += arr[len];
            }
            else {
                arr[l] = resStr;
                arr[r] = arr[len];
            }
            System.out.println(Arrays.toString(arr));
        }

        return arr[0];
    }

    public static void main(String[] args) {
        String[] arr = {"AHMED","DOK","KALO","OPPD","DREFA","OLA","AMOP"};
        int len = arr.length;

        System.out.println("The Shortest Superstring is " +
                findShortestSuperstring(arr, len));
    }
}
