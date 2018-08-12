package greedy.min_abs_diff_in_array;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest(new int[] {3, -7, 0}, 3);
        runTest(new int[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}, 1);
        runTest(new int[] {1, -3, 71, 68, 17}, 3);
    }

    public static void runTest(int[] input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(input));

        int output = Solution.minimumAbsoluteDifference(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
