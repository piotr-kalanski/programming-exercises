package sorting.bubble_sort;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest(new int [] {3, 2, 1});
        runTest(new int [] {1, 2, 3});
    }

    public static void runTest(int[] input) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(input));

        Solution.countSwaps(input);
    }
}
