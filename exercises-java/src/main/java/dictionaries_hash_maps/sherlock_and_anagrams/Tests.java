package dictionaries_hash_maps.sherlock_and_anagrams;

public class Tests {
    public static void main(String[] args) {
        runTest("cdcd", 5);
        runTest("ifailuhkqq", 3);
        runTest("kkkk", 10);
    }

    public static void runTest(String s, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(s);

        int output = Solution.sherlockAndAnagrams(s);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
