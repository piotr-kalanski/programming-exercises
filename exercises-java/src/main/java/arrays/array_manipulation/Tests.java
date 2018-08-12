package arrays.array_manipulation;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest(5, new int [][] {new int[] {1,2,100}, new int []{2,5,100}, new int[] {3, 4, 100}}, 200);
    }

    public static void runTest(int n, int[][] queries, long expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(n);
        System.out.println(Arrays.deepToString(queries));

        long output = Solution.arrayManipulation(n, queries);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
