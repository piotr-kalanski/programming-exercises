package dictionaries_hash_maps.two_strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        // sorting O(N logN) solution
        char [] chars1 = s1.toCharArray();
        char [] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for(int i1 = 0, i2 = 0; i1 < chars1.length && i2 < chars2.length ;)
            if(chars1[i1] == chars2[i2])
                return "YES";
            else if (chars1[i1] < chars2[i2])
                i1 += 1;
            else if (chars1[i1] > chars2[i2])
                i2 += 1;

        return "NO";

        // another option is to create two dictionaries and search

        // brute force solution O(N^2)
        /*for(char c1: s1.toCharArray())
            for(char c2: s2.toCharArray())
                if(c1 == c2)
                    return "YES";
        return "NO";*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
