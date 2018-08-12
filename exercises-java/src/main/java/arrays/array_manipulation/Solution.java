package arrays.array_manipulation;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long result = Long.MIN_VALUE;

        long array [] = new long[n];

        // intelligent solution:
        for(int[] query: queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];

            array[a-1] += k;
            if(b < array.length)
                array[b] -= k;
        }

        long temp = 0;

        for(long e: array){
            temp += e;
            if(temp> result) result = temp;
        }

        // brute force solution:
/*        for(int[] query: queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];

            for(int i=a; i<=b; ++i)
                array[i-1] += k;
        }

        for(long e: array)
            if(result < e)
                result = e;*/

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}