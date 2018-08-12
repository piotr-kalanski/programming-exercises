package aaa_template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        // TODO - change calls:
        runTest("cdcd", 5);
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
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        // TODO - change method:
        int output = Solution.exercise(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
