package regular_expressions.ip_address;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() { runTest("000.12.12.034", true); }

    @Test
    public void test2() { runTest("121.234.12.12", true); }

    @Test
    public void test3() { runTest("23.45.12.56", true); }

    @Test
    public void test4() { runTest("00.12.123.123123.123", false); }

    @Test
    public void test5() { runTest("122.23", false); }

    @Test
    public void test6() { runTest("Hello.IP", false); }

    private void runTest(String input, boolean expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        boolean output = Solution.isIP(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
