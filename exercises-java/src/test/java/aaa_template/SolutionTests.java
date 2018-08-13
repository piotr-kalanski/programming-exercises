package aaa_template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        // TODO - change calls:
        runTest("cdcd", 5);
        /*

        runTest(
                5,
                92,
                23,
                new int[][] {
                        new int[] {2, 1},
                        new int[] {5, 3},
                        new int[] {5, 1},
                        new int[] {3, 4},
                        new int[] {3, 1},
                        new int[] {5, 4},
                        new int[] {4, 1},
                        new int[] {5, 2}
                },
                184
        );

         */
    }

    @Test
    public void test2() {
        // TODO - change calls:
        runTest("ifailuhkqq", 3);
    }

    @Test
    public void test3() {
        // TODO - change calls:
        runTest("kkkk", 10);
    }

    // TODO - change input expected output type:
    private void runTest(String input, int expectedOutput) {
    //private void runTest(String input, String expectedOutput) {
        System.out.println("\n\nINPUT:");
        // TODO - change println input - if two
        System.out.println(input);
        //System.out.println(input2);
        //System.out.println(input3);
        //System.out.println(Arrays.toString(input));

        // TODO - change method:
        int output = Solution.exercise(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
