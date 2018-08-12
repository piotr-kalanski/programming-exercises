package dictionaries_hash_maps.frequency_queries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SolutionWithModifiedMain {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> countsOfElements = new HashMap<>();
        int[] numberOfElementsWithFrequency = new int[1000000];

        for(int[] query: queries) {
            int operation = query[0];
            int element = query[1];
            int countOfElement = countsOfElements.getOrDefault(element, 0);

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements.put(element, countOfElement + 1);

                numberOfElementsWithFrequency[countOfElement] -= 1;
                numberOfElementsWithFrequency[countOfElement + 1] += 1;
            }
            // Delete one occurence of y from your data structure, if present.
            else if((operation == 2) && (countOfElement > 0)) {
                countsOfElements.put(element, countOfElement - 1);

                numberOfElementsWithFrequency[countOfElement] -= 1;
                numberOfElementsWithFrequency[countOfElement - 1] += 1;
            }
            // Check if any integer is present whose frequency is exactly element, If yes, print 1 else 0.
            else if(operation == 3) {
                int isFrequencyEqual = numberOfElementsWithFrequency[element] > 0 ? 1 : 0;
                result.add(isFrequencyEqual);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}
