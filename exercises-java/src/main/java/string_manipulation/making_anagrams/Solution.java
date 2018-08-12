package string_manipulation.making_anagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int result = 0;

        Map<Character, Integer> characterFreqInFirstWord = new HashMap<>();
        Map<Character, Integer> characterFreqInSecondWord = new HashMap<>();
        Set<Character> uniqueCharacters = new HashSet<>();

        for(char c: a.toCharArray()) {
            characterFreqInFirstWord.put(c, characterFreqInFirstWord.getOrDefault(c, 0) + 1);
            uniqueCharacters.add(c);
        }

        for(char c: b.toCharArray()) {
            characterFreqInSecondWord.put(c, characterFreqInSecondWord.getOrDefault(c, 0) + 1);
            uniqueCharacters.add(c);
        }

        for(char c: uniqueCharacters) {
            result += Math.abs(characterFreqInFirstWord.getOrDefault(c, 0) - characterFreqInSecondWord.getOrDefault(c, 0));
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
