package retail;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Question_1 {

    
    static void miniMaxSum(int[] arr) {

        int min = 0;
        int max = 0;
        int small = arr[0];
        int large = arr[0];

        Arrays.sort(arr);
            for (int g = 0; g<4; g++){
                min+=arr[g];
            }
                System.out.println("Minimum: " + min);

            for (int h = 1; h<5; h++){
                max+=arr[h];
            }
                System.out.println("Maximum: " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}



