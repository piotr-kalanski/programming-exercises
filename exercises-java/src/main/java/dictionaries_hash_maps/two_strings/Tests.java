package dictionaries_hash_maps.two_strings;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest("hello", "world", "YES");
        runTest("hi", "world", "NO");
    }

    public static void runTest(String s1, String s2, String expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(s1);
        System.out.println(s2);

        String output = Solution.twoStrings(s1, s2);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output.equals(expectedOutput));
    }
}
