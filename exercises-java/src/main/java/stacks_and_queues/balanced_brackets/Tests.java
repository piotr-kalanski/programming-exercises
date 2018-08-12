package stacks_and_queues.balanced_brackets;

public class Tests {
    public static void main(String[] args) {
        runTest("{[()]}", "YES");
        runTest("{[(])}", "NO");
        runTest("{{[[(())]]}}", "YES");

        runTest("{(([])[])[]}", "YES");
        runTest("{(([])[])[]]}", "NO");
        runTest("{(([])[])[]}[]", "YES");
    }

    public static void runTest(String input, String expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        String output = Solution.isBalanced(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output.equals(expectedOutput));
    }
}
