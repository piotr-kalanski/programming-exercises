package arrays.minimum_swaps;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapsCount = 0;

        // solution 1 - selection sort:
/*        for(int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for(int j=i+1; j < arr.length; ++j) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                swapsCount += 1;
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }*/

        // solution 2 - "graph" sort
        for(int i=0; i<arr.length-1; i++) {
            if ((i + 1) != arr[i]) {
                int elementToSwap = arr[i] - 1;
                int tmp = arr[i];
                arr[i] = arr[elementToSwap];
                arr[elementToSwap] = tmp;
                i = 0;
                swapsCount += 1;
            } else {
                i += 1;
            }
        }


/*        for(int j=0; j<arr.length-1; ) {
            if(arr[j] > arr[j+1]) {
                int elementToSwap = j+1;

                while((elementToSwap < arr.length-1) && (arr[j] > arr[elementToSwap+1]) && (arr[elementToSwap+1] < arr[j+1]))
                    elementToSwap += 1;

                System.out.println("swap: " + arr[j] + " with " + arr[elementToSwap]);
                System.out.println(Arrays.toString(arr));

                swapsCount += 1;
                int tmp = arr[j];
                arr[j] = arr[elementToSwap];
                arr[elementToSwap] = tmp;
                j = j > 0 ? j - 1 : 0;
            }
            else {
                j++;
            }
        }*/

        return swapsCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        System.out.println(res);

        //bufferedWriter.close();

        scanner.close();
    }
}

