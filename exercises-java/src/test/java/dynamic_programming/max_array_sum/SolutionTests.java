package dynamic_programming.max_array_sum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest(new int[] {3, 7, 4, 6, 5}, 13);
    }

    @Test
    public void test2() {
        runTest(new int[] {2, 1, 5, 8, 4}, 11);
    }

    @Test
    public void test3() {
        runTest(new int[] {3, 5, -7, 8, 10}, 15);
    }

    private void runTest(int[] input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(input));

        int output = Solution.maxSubsetSum(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
