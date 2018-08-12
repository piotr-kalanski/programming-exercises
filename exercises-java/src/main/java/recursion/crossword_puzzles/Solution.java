package recursion.crossword_puzzles;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        // prepare data structures:
        LinkedList<String> wordsList = convertWordsToList(words);
        char[][] crosswordGrid = createCrosswordGrid(crossword);
        // search for solution:
        Result result = searchForSolutions(crosswordGrid, wordsList);
        return result.convertSolutionToStringArray();
    }

    private static LinkedList<String> convertWordsToList(String words) {
        LinkedList<String> wordsArray = new LinkedList<>(Arrays.asList(words.split(";")));
        return wordsArray;
    }

    static class Result {
        Result(boolean solved, char[][] solution) {
            this.solved = solved;
            this.solution = solution;
        }
        boolean solved;
        char[][] solution;

        String[] convertSolutionToStringArray() {
            String[] result = new String[solution.length];
            for (int i = 0; i < solution.length; i++) {
                result[i] = new String(solution[i]);
            }
            return result;
        }
    }

    private static Result searchForSolutions(char[][] remainingCrossword, LinkedList<String> remainingWords) {
        if(remainingWords.isEmpty())
            return new Result(true, remainingCrossword);
        else {
            LinkedList<String> remainingWordsCopy = new LinkedList<>(remainingWords);
            String word = remainingWordsCopy.removeFirst();
            List<char[][]> potentialSolutions = findAllSolutionsToPlaceWord(word, remainingCrossword);
            for(char[][] crossword: potentialSolutions) {
                Result result = searchForSolutions(crossword, remainingWordsCopy);
                if(result.solved)
                    return result;
            }
        }
        return new Result(false, remainingCrossword);
    }

    private static List<char[][]> findAllSolutionsToPlaceWord(String word, char[][] inputCrossword) {
        List<char[][]> solutions = new LinkedList<>();

        for(int r=0; r < inputCrossword.length; ++r) {
            for (int c = 0; c < inputCrossword.length - word.length() + 1; ++c) {
                boolean wordFitAtRow = true;
                for (int i = 0; i < word.length(); ++i) {
                    char crossWordChar = inputCrossword[r][c + i];
                    if (word.charAt(i) != crossWordChar && crossWordChar != '-')
                        wordFitAtRow = false;
                }
                if (wordFitAtRow) {
                    char[][] crossWordCopy = copyCrossword(inputCrossword);
                    for (int i = 0; i < word.length(); ++i) {
                        crossWordCopy[r][c + i] = word.charAt(i);
                    }
                    solutions.add(crossWordCopy);
                }
            }
        }

        for(int r=0; r < inputCrossword.length - word.length() + 1; ++r) {
            for (int c = 0; c < inputCrossword.length; ++c) {
                boolean wordFitAtColumn = true;
                for (int i = 0; i < word.length(); ++i) {
                    char crossWordChar = inputCrossword[r + i][c];
                    if (word.charAt(i) != crossWordChar && crossWordChar != '-')
                        wordFitAtColumn = false;
                }
                if (wordFitAtColumn) {
                    char[][] crossWordCopy = copyCrossword(inputCrossword);
                    for (int i = 0; i < word.length(); ++i) {
                        crossWordCopy[r + i][c] = word.charAt(i);
                    }
                    solutions.add(crossWordCopy);
                }
            }
        }

        return solutions;
    }

    private static char[][] copyCrossword(char[][] crossword) {
        char[][] copy = new char[10][10];
        for (int r = 0; r < crossword.length ; r++) {
            for (int c = 0; c < crossword.length ; c++) {
                copy[r][c] = crossword[r][c];
            }
        }
        return copy;
    }

    private static char[][] createCrosswordGrid(String[] crossword) {
        char[][] grid = new char[10][10];
        for (int r = 0; r < crossword.length ; r++) {
            for (int c = 0; c < crossword.length ; c++) {
                grid[r][c] = crossword[r].charAt(c);
            }
        }
        return grid;
    }

    // END SOLUTION


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
