package dictionaries_hash_maps.sherlock_and_anagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        int stringLength = s.length();

        // brute force solution:
/*        for(int firstSubstringStartIndex = 0; firstSubstringStartIndex < stringLength-1 ; firstSubstringStartIndex++) {
            for(int firstSubstringEndIndex = firstSubstringStartIndex; firstSubstringEndIndex < stringLength-1 ; firstSubstringEndIndex++) {
                for(int secondSubstringStartIndex = firstSubstringStartIndex+1; secondSubstringStartIndex < stringLength ; secondSubstringStartIndex++) {
                    for(int secondSubstringEndIndex = secondSubstringStartIndex; secondSubstringEndIndex < stringLength ; secondSubstringEndIndex++) {
                        String firstSubstring = s.substring(firstSubstringStartIndex, firstSubstringEndIndex+1);
                        String secondSubstring = s.substring(secondSubstringStartIndex, secondSubstringEndIndex+1);

                        char[] firstChars = firstSubstring.toCharArray();
                        char[] secondChars = secondSubstring.toCharArray();
                        Arrays.sort(firstChars);
                        Arrays.sort(secondChars);
                        if(Arrays.equals(firstChars, secondChars)) {
                            count += 1;
                        }
                    }
                }
            }
        }*/

        // brute force solution with small optimization - sort only once
/*        for(int firstSubstringStartIndex = 0; firstSubstringStartIndex < stringLength-1 ; firstSubstringStartIndex++) {
            for(int firstSubstringEndIndex = firstSubstringStartIndex; firstSubstringEndIndex < stringLength-1 ; firstSubstringEndIndex++) {
                String firstSubstring = s.substring(firstSubstringStartIndex, firstSubstringEndIndex+1);
                char[] firstChars = firstSubstring.toCharArray();
                Arrays.sort(firstChars);

                for(int secondSubstringStartIndex = firstSubstringStartIndex+1; secondSubstringStartIndex < stringLength ; secondSubstringStartIndex++) {
                    for(int secondSubstringEndIndex = secondSubstringStartIndex; secondSubstringEndIndex < stringLength ; secondSubstringEndIndex++) {
                        String secondSubstring = s.substring(secondSubstringStartIndex, secondSubstringEndIndex+1);

                        char[] secondChars = secondSubstring.toCharArray();
                        Arrays.sort(secondChars);
                        if(Arrays.equals(firstChars, secondChars)) {
                            count += 1;
                        }
                    }
                }
            }
        }*/

        // brute force solution with small optimization - sort only once and the same length of substrings
        for(int firstSubstringStartIndex = 0; firstSubstringStartIndex < stringLength-1 ; firstSubstringStartIndex++) {
            for(int firstSubstringEndIndex = firstSubstringStartIndex; firstSubstringEndIndex < stringLength-1 ; firstSubstringEndIndex++) {
                String firstSubstring = s.substring(firstSubstringStartIndex, firstSubstringEndIndex+1);
                int anagramLength = firstSubstringEndIndex - firstSubstringStartIndex;
                char[] firstChars = firstSubstring.toCharArray();
                Arrays.sort(firstChars);

                for(int secondSubstringEndIndex = firstSubstringEndIndex+1; secondSubstringEndIndex < stringLength; secondSubstringEndIndex++) {
                    int secondSubstringStartIndex = secondSubstringEndIndex - anagramLength;
                    String secondSubstring = s.substring(secondSubstringStartIndex, secondSubstringEndIndex+1);

                    char[] secondChars = secondSubstring.toCharArray();
                    Arrays.sort(secondChars);
                    if(Arrays.equals(firstChars, secondChars)) {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
