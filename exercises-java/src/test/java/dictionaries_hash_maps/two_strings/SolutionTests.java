package dictionaries_hash_maps.two_strings;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest("hello", "world", "YES");
    }

    @Test
    public void test2() {
        runTest("hi", "world", "NO");
    }


    private void runTest(String s1, String s2, String expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(s1);
        System.out.println(s2);

        String output = Solution.twoStrings(s1, s2);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
