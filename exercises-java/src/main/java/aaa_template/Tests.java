package aaa_template;

public class Tests {
    public static void main(String[] args) {
        // TODO - change calls:
        runTest("cdcd", 5);
        runTest("ifailuhkqq", 3);
        runTest("kkkk", 10);
    }

    // TODO - change input expected output type:
    public static void runTest(String input, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        // TODO - change method :
        int output = Solution.exercise(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        // TODO == or equals:
        System.out.println(output == expectedOutput);
        //System.out.println(output.equals(expectedOutput));
    }
}
