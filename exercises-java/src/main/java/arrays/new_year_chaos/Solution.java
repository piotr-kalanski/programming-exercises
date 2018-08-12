package arrays.new_year_chaos;

import java.util.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribesCount = 0;
        int bribesPerPerson [] = new int[q.length];

        for(int j=0; j<q.length-1; ) {
            if(q[j] > q[j+1]) {
                bribesCount += 1;
                bribesPerPerson[q[j]-1] += 1;
                if(bribesPerPerson[q[j] - 1] > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                int tmp = q[j];
                q[j] = q[j+1];
                q[j+1] = tmp;
                j = j > 0 ? j - 1 : 0;
            }
            else {
                j++;
            }
        }

        System.out.println(bribesCount);
    }

    /*

    static void minimumBribes(int[] q) {
        int bribesCount = 0;
        int bribesPerPerson [] = new int[q.length];

        for(int i=0; i<q.length-1; ++i) {
            for(int j=0; j<q.length-1; ++j) {
                if(q[j] > q[j+1]) {
                    bribesCount += 1;
                    bribesPerPerson[q[j]-1] += 1;
                    int tmp = q[j];
                    q[j] = q[j+1];
                    q[j+1] = tmp;
                    if(bribesPerPerson[q[j]] > 2) {
                        System.out.println("Too chaotic");
                        return;
                    }
                }
            }
        }

        System.out.println(bribesCount);
    }

     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

