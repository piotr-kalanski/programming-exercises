package string_manipulation.alternating_characters;

public class Tests {
    public static void main(String[] args) {
        // TODO - change calls:
        runTest("AAAA", 3);
        runTest("BBBBB", 4);
        runTest("ABABABAB", 0);
        runTest("BABABA", 0);
        runTest("AAABBB", 4);
        runTest("A", 0);
        runTest("", 0);
        runTest("ABBABBAA", 3);
    }

    public static void runTest(String input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        // TODO - change method :
        int output = Solution.alternatingCharacters(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output == expectedOutput);
    }
}
