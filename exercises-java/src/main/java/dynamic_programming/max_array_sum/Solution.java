package dynamic_programming.max_array_sum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /*
    // START SOLUTION 1
    static int maxSubsetSum(int[] arr) {
        return searchMaxSubsetSum(arr, 0, arr.length-1, new HashMap<>());
        //return searchMaxSubsetSum(arr, 0, arr.length-1, new int[arr.length][arr.length]);
    }


    static int searchMaxSubsetSum(int[] arr, int startIndex, int endIndex, Map<Integer, Map<Integer,Integer>> cachedSums) {
    //static int searchMaxSubsetSum(int[] arr, int startIndex, int endIndex, int[][] cachedSums) {
        int maxSum = Integer.MIN_VALUE;

        if(startIndex == endIndex) {
            maxSum = arr[startIndex];
        }
        else if(cacheExists(startIndex, endIndex, cachedSums)) {
            return readFromCache(startIndex, endIndex, cachedSums);
        }
        else {
            int maxSumWithFirstElement = arr[startIndex];
            if(startIndex + 1 < endIndex) {
                int maxSumWithoutFirstTwoElements = searchMaxSubsetSum(arr, startIndex+2, endIndex, cachedSums);
                maxSumWithFirstElement = maxSumWithFirstElement < 0 ? maxSumWithoutFirstTwoElements : maxSumWithFirstElement + maxSumWithoutFirstTwoElements;
            }
            maxSum = maxSumWithFirstElement > maxSum ? maxSumWithFirstElement : maxSum;

            int maxSumWithoutFirstElement = searchMaxSubsetSum(arr, startIndex+1, endIndex, cachedSums);
            maxSum = maxSumWithoutFirstElement > maxSum ? maxSumWithoutFirstElement : maxSum;

            int maxSumWithoutLastElement = searchMaxSubsetSum(arr, startIndex, endIndex - 1, cachedSums);
            maxSum = maxSumWithoutLastElement > maxSum ? maxSumWithoutLastElement : maxSum;

            if(startIndex < endIndex - 2) {
                int maxSumWithoutLastTwoElements = searchMaxSubsetSum(arr, startIndex, endIndex-2, cachedSums);
                maxSum = maxSumWithoutLastTwoElements > maxSum ? maxSumWithoutLastTwoElements : maxSum;
            }
        }

        cacheValue(startIndex, endIndex, maxSum, cachedSums);

        return maxSum;
    }

    static void cacheValue(int startIndex, int endIndex, int value, Map<Integer, Map<Integer,Integer>> cache) {
        if(cache.containsKey(startIndex)) {
            cache.get(startIndex).put(endIndex, value);
        }
        else {
            Map<Integer, Integer> e = new HashMap<>();
            e.put(endIndex, value);
            cache.put(startIndex, e);
        }
    }

    static boolean cacheExists(int startIndex, int endIndex, Map<Integer, Map<Integer,Integer>> cache) {
        return cache.containsKey(startIndex) && cache.get(startIndex).containsKey(endIndex);
    }

    static int readFromCache(int startIndex, int endIndex, Map<Integer, Map<Integer,Integer>> cache) {
        return cache.get(startIndex).get(endIndex);
    }

    static void cacheValue(int startIndex, int endIndex, int value, int[][] cache) {
        cache[startIndex][endIndex] = value;
    }

    static boolean cacheExists(int startIndex, int endIndex, int[][] cache) {
        return cache[startIndex][endIndex] != 0;
    }

    static int readFromCache(int startIndex, int endIndex, int[][] cache) {
        return cache[startIndex][endIndex];
    }

    // END SOLUTION 1
    */

    // START SOLUTION 2
    static int maxSubsetSum(int[] arr) {
        if(arr.length == 1)
            return arr[0];

        int[] cache = new int [arr.length];
        cache[0] = arr[0];
        cache[1] = arr[1] > arr[0] ? arr[1] : arr[0];
        int maxSum = cache[1];

        for(int i = 2 ; i < arr.length ; ++i) {
            int maxAtPosition = arr[i];
            maxAtPosition = maxAtPosition < maxSum ? maxSum : maxAtPosition;

            int maxWithPrev = cache[i - 2] + arr[i];
            maxAtPosition = maxWithPrev > maxAtPosition ? maxWithPrev : maxAtPosition;
            cache[i] = maxAtPosition;
            maxSum = maxAtPosition;
        }

        return maxSum;
    }

    // END SOLUTION 2

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

