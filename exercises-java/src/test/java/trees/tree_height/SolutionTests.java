package trees.tree_height;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest(new Node(0), 0);
    }

    @Test
    public void test2() {
        runTest(Solution.insert(new Node(0), 1), 1);
    }

    @Test
    public void test3() {
        runTest(
                Solution.insert(Solution.insert(new Node(0), 1), 2),
                2
        );
    }

    private void runTest(Node tree, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(tree);

        int output = Solution.height(tree);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
