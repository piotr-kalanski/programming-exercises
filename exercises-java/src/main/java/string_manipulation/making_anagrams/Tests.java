package string_manipulation.making_anagrams;

public class Tests {
    public static void main(String[] args) {
        runTest("cde", "abc", 4);
    }

    public static void runTest(String a, String b, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(a);
        System.out.println(b);

        int output = Solution.makeAnagram(a, b);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
