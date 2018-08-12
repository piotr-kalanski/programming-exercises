package dictionaries_hash_maps.frequency_queries;

import java.util.Arrays;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        runTest(
            Arrays.asList(
                Arrays.asList(3,4),
                Arrays.asList(2, 1003),
                Arrays.asList(1, 16),
                Arrays.asList(3, 1)
            ),
            Arrays.asList(0, 1)
        );

        runTest(
            Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
            ),
            Arrays.asList(0, 1, 1)
        );
    }

    public static void runTest(List<List<Integer>> input, List<Integer> expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(input);

        List<Integer> output = Solution.freqQuery(input);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        System.out.println("IS EQUAL?");
        System.out.println(output.equals(expectedOutput));
    }
}
