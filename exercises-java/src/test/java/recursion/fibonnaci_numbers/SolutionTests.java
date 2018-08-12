package recursion.fibonnaci_numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest(3, 2);
    }

    @Test
    public void test2() {
        runTest(4, 3);
    }

    @Test
    public void test3() {
        runTest(6, 8);
    }

    private void runTest(int input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        int output = Solution.fibonacci(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
