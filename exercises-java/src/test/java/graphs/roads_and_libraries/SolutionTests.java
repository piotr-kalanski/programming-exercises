package graphs.roads_and_libraries;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest(
                3,
                2,
                1,
                new int[][] {
                        new int[] {1, 2},
                        new int[] {3, 1},
                        new int[] {2, 3}
                        },
                4
                );
    }

    @Test
    public void test2() {
        runTest(
                6,
                2,
                5,
                new int[][] {
                        new int[] {1, 3},
                        new int[] {3, 4},
                        new int[] {2, 4},
                        new int[] {1, 2},
                        new int[] {2, 3},
                        new int[] {5, 6}
                },
                12
        );
    }

    @Test
    public void test3() {
        runTest(
                5,
                6,
                1,
                new int[][] {
                        new int[] {1, 2},
                        new int[] {1, 3},
                        new int[] {1, 4}
                },
                15
        );
    }

    @Test
    public void test4() {
        runTest(
                9,
                91,
                84,
                new int[][] {
                        new int[] {8, 2},
                        new int[] {2, 9}
                },
                805
        );
    }

    @Test
    public void test5() {
        runTest(
                5,
                92,
                23,
                new int[][] {
                        new int[] {2, 1},
                        new int[] {5, 3},
                        new int[] {5, 1},
                        new int[] {3, 4},
                        new int[] {3, 1},
                        new int[] {5, 4},
                        new int[] {4, 1},
                        new int[] {5, 2}
                },
                184
        );
    }

    @Test
    public void test6() {
        runTest(
                8,
                10,
                55,
                new int[][] {
                        new int[] {6, 4},
                        new int[] {3, 2},
                        new int[] {7, 1}
                },
                80
        );
    }

    @Test
    public void test7() {
        runTest(
                1,
                5,
                3,
                new int[][] {},
                5
        );
    }

    @Test
    public void test8() {
        runTest(
                2,
                102,
                1,
                new int[][] {},
                204
        );
    }

    private void runTest(int n, int c_lib, int c_road, int[][] cities, int expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(n);
        System.out.println(c_lib);
        System.out.println(c_road);
        System.out.println(Arrays.deepToString(cities));

        long output = Solution.roadsAndLibraries(n, c_lib, c_road, cities);

        System.out.println("OUTPUT VS EXPECTED OUTPUT:");
        System.out.println("output = " + output + " vs expected = " + expectedOutput);
        assertEquals(expectedOutput, output);
    }
}
