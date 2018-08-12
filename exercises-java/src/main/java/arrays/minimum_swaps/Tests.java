package arrays.minimum_swaps;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest(new int [] {4, 3, 1, 2}, 3);
        runTest(new int [] {2, 3, 4, 1, 5}, 3);
        runTest(new int [] {1, 3, 5, 2, 4, 6, 8}, 3);
        runTest(new int[] {3, 7, 6, 9, 1, 8, 10, 4, 2, 5}, 9);
    }

    public static void runTest(int[] input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(input));

        int output = Solution.minimumSwaps(input);

        System.out.println("INPUT AFTER:");
        System.out.println(Arrays.toString(input));
        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
