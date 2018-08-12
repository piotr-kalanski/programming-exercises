package stacks_and_queues.balanced_brackets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String result = "YES";

        char[] chars = s.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();
        for (char c: chars) {
            if(c == '{' || c == '[' || c == '(')
                stack.add(c);
            else if(stack.isEmpty()) {
                return "NO";
            }
            else {
                Character last = stack.removeLast();
                if(c == '}' && last != '{') {
                    return "NO";
                }
                if(c == ']' && last != '[') {
                    return "NO";
                }
                if(c == ')' && last != '(') {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
