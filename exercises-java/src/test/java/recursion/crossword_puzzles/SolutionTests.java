package recursion.crossword_puzzles;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    @Test
    public void test1() {
        runTest(
                new String[] {
                    "+-++++++++",
                    "+-++++++++",
                    "+-++++++++",
                    "+-----++++",
                    "+-+++-++++",
                    "+-+++-++++",
                    "+++++-++++",
                    "++------++",
                    "+++++-++++",
                    "+++++-++++"
                },
                "LONDON;DELHI;ICELAND;ANKARA",
                new String[] {
                    "+L++++++++",
                    "+O++++++++",
                    "+N++++++++",
                    "+DELHI++++",
                    "+O+++C++++",
                    "+N+++E++++",
                    "+++++L++++",
                    "++ANKARA++",
                    "+++++N++++",
                    "+++++D++++"
                }
        );
    }

    @Test
    public void test2() {
        runTest(
                new String[] {
                        "+-++++++++",
                        "+-++++++++",
                        "+-------++",
                        "+-++++++++",
                        "+-++++++++",
                        "+------+++",
                        "+-+++-++++",
                        "+++++-++++",
                        "+++++-++++",
                        "++++++++++"
                },
                "AGRA;NORWAY;ENGLAND;GWALIOR",
                new String[] {
                        "+E++++++++",
                        "+N++++++++",
                        "+GWALIOR++",
                        "+L++++++++",
                        "+A++++++++",
                        "+NORWAY+++",
                        "+D+++G++++",
                        "+++++R++++",
                        "+++++A++++",
                        "++++++++++"
                }
        );
    }

    @Test
    public void test3() {
        runTest(
                new String[] {
                        "XXXXXX-XXX",
                        "XX------XX",
                        "XXXXXX-XXX",
                        "XXXXXX-XXX",
                        "XXX------X",
                        "XXXXXX-X-X",
                        "XXXXXX-X-X",
                        "XXXXXXXX-X",
                        "XXXXXXXX-X",
                        "XXXXXXXX-X"
                },
                "ICELAND;MEXICO;PANAMA;ALMATY",
                new String[] {
                        "XXXXXXIXXX",
                        "XXMEXICOXX",
                        "XXXXXXEXXX",
                        "XXXXXXLXXX",
                        "XXXPANAMAX",
                        "XXXXXXNXLX",
                        "XXXXXXDXMX",
                        "XXXXXXXXAX",
                        "XXXXXXXXTX",
                        "XXXXXXXXYX"
                }
        );
    }

    private void runTest(String[] crossword, String words, String[] expectedOutput) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(crossword));
        System.out.println(words);
        String[] output = Solution.crosswordPuzzle(crossword, words);

        System.out.println("\n----\nOUTPUT:");
        for(int i=0;i<10;++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.print(output[i].charAt(j));
            }
            System.out.println();
        }

        System.out.println("\n----\nEXPECTED OUTPUT:");
        for(int i=0;i<10;++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.print(expectedOutput[i].charAt(j));
            }
            System.out.println();
        }

        assertArrayEquals(expectedOutput, output);
    }
}
