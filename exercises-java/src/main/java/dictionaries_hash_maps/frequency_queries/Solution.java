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

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new LinkedList<>();

        // brute force solution:
        /*Map<Integer, Integer> countsOfElements = new HashMap<>();

        for(List<Integer> query: queries) {
            Integer operation = query.get(0);
            Integer element = query.get(1);
            int countOfElement = countsOfElements.getOrDefault(element, 0);

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements.put(element, countOfElement + 1);
            }
            // Delete one occurence of y from your data structure, if present.
            else if(operation == 2 && countOfElement > 0) {
                countsOfElements.put(element, countOfElement - 1);
            }
            // Check if any integer is present whose frequency is exactly element, If yes, print 1 else 0.
            else if(operation == 3) {

                int isFrequencyEqual = 0;
                // brute force check:
                for(Integer frequency: countsOfElements.values())
                    if(frequency.equals(element))
                        isFrequencyEqual = 1;

                result.add(isFrequencyEqual);
            }
        }*/

        // Optimization with additional dictionary
        /*Map<Integer, Integer> countsOfElements = new HashMap<>();
        Map<Integer, Set<Integer>> elementsWithFrequency = new HashMap<>();

        for(List<Integer> query: queries) {
            Integer operation = query.get(0);
            Integer element = query.get(1);
            int countOfElement = countsOfElements.getOrDefault(element, 0);

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements.put(element, countOfElement + 1);

                elementsWithFrequency.getOrDefault(countOfElement, new HashSet<>()).remove(element);
                if(!elementsWithFrequency.containsKey(countOfElement + 1))
                    elementsWithFrequency.put(countOfElement + 1, new HashSet<>());
                elementsWithFrequency.get(countOfElement + 1).add(element);
            }
            // Delete one occurence of y from your data structure, if present.
            else if(operation == 2 && countOfElement > 0) {
                countsOfElements.put(element, countOfElement - 1);

                elementsWithFrequency.getOrDefault(countOfElement, new HashSet<>()).remove(element);
                if(!elementsWithFrequency.containsKey(countOfElement - 1))
                    elementsWithFrequency.put(countOfElement - 1, new HashSet<>());
                elementsWithFrequency.get(countOfElement - 1).add(element);
            }
            // Check if any integer is present whose frequency is exactly element, If yes, print 1 else 0.
            else if(operation == 3) {
                int isFrequencyEqual = elementsWithFrequency.containsKey(element) && !elementsWithFrequency.get(element).isEmpty() ? 1 : 0;
                result.add(isFrequencyEqual);
            }
        }*/

        // number of elements with frequency
        /*Map<Integer, Integer> countsOfElements = new HashMap<>();
        Map<Integer, Integer> numberOfElementsWithFrequency = new HashMap<>();

        for(List<Integer> query: queries) {
            Integer operation = query.get(0);
            Integer element = query.get(1);
            int countOfElement = countsOfElements.getOrDefault(element, 0);

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements.put(element, countOfElement + 1);

                numberOfElementsWithFrequency.put(countOfElement, numberOfElementsWithFrequency.getOrDefault(countOfElement, 0) - 1);
                numberOfElementsWithFrequency.put(countOfElement + 1, numberOfElementsWithFrequency.getOrDefault(countOfElement + 1, 0) + 1);
            }
            // Delete one occurence of y from your data structure, if present.
            else if(operation == 2 && countOfElement > 0) {
                countsOfElements.put(element, countOfElement - 1);

                numberOfElementsWithFrequency.put(countOfElement, numberOfElementsWithFrequency.getOrDefault(countOfElement, 0) - 1);
                numberOfElementsWithFrequency.put(countOfElement - 1, numberOfElementsWithFrequency.getOrDefault(countOfElement - 1, 0) + 1);
            }
            // Check if any integer is present whose frequency is exactly element, If yes, print 1 else 0.
            else if(operation == 3) {
                int isFrequencyEqual = numberOfElementsWithFrequency.getOrDefault(element,0) > 0 ? 1 : 0;
                result.add(isFrequencyEqual);
            }
        }*/

        // Use array as number of elements with frequency
        Map<Integer, Integer> countsOfElements = new HashMap<>();
        int[] numberOfElementsWithFrequency = new int[1000000];

        for(List<Integer> query: queries) {
            Integer operation = query.get(0);
            Integer element = query.get(1);
            int countOfElement = countsOfElements.getOrDefault(element, 0);

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements.put(element, countOfElement + 1);

                numberOfElementsWithFrequency[countOfElement] -= 1;
                numberOfElementsWithFrequency[countOfElement + 1] += 1;
            }
            // Delete one occurence of y from your data structure, if present.
            else if(operation == 2 && countOfElement > 0) {
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

        // Use only arrays - heap size issue
        /*int[] countsOfElements = new int[10000000];
        int[] numberOfElementsWithFrequency = new int[1000000];

        for(List<Integer> query: queries) {
            Integer operation = query.get(0);
            Integer element = query.get(1);
            int countOfElement = countsOfElements[element];

            // insert x in your data structure
            if(operation == 1) {
                countsOfElements[element] += 1;

                numberOfElementsWithFrequency[countOfElement] -= 1;
                numberOfElementsWithFrequency[countOfElement + 1] += 1;
            }
            // Delete one occurence of y from your data structure, if present.
            else if(operation == 2 && countOfElement > 0) {
                countsOfElements[element] -= 1;

                numberOfElementsWithFrequency[countOfElement] -= 1;
                numberOfElementsWithFrequency[countOfElement - 1] += 1;
            }
            // Check if any integer is present whose frequency is exactly element, If yes, print 1 else 0.
            else if(operation == 3) {
                int isFrequencyEqual = numberOfElementsWithFrequency[element] > 0 ? 1 : 0;
                result.add(isFrequencyEqual);
            }
        }*/

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
