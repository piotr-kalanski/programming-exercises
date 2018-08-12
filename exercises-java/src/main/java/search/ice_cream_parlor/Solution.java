package search.ice_cream_parlor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        // brute force solution - O(N^2)
        /*for(int i=0; i < cost.length - 1; ++i)
            for (int j = i + 1; j < cost.length; j++) {
                if((cost[i] + cost[j]) == money)
                    System.out.println((i+1) + " " + (j+1));
            }
        */

        // using hash map to index costs - O(NlogN)
        Map<Integer, Integer> costsIndex = new HashMap<>();
        for(int i=0; i < cost.length; ++i)
            costsIndex.put(cost[i], i);

        for(int i=0; i < cost.length; ++i) {
            int lackingCost = money - cost[i];
            if(costsIndex.containsKey(lackingCost) && costsIndex.get(lackingCost) != i) {
                System.out.println((i + 1) + " " + (costsIndex.get(lackingCost) + 1));
                break;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
