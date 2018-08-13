package graphs.roads_and_libraries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    // START SOLUTION WITH GRAPH:
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_road > c_lib)
            return n * c_lib;
        else {
            int numberOfClusters = 0;
            int numberOfRoads = 0;

            Graph graph = new Graph(n+1);
            for (int[] edge : cities) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            }

            boolean visited[] = new boolean[n+1];

            int firstNotVisited = 1;

            do {
                Result result = graph.countEdgesFromNodeUsingBFS(firstNotVisited, visited);
                numberOfClusters += 1;
                firstNotVisited = result.firstNotVisitedVertex;
                numberOfRoads += result.edgeCount;
            }
            while(firstNotVisited != -1);

            long costOfBuildingLibraryInEachCluster = numberOfClusters * c_lib;
            long costOfRepairingRoadsToConnectEachCityWithLibrary = numberOfRoads * c_road;

            return costOfBuildingLibraryInEachCluster + costOfRepairingRoadsToConnectEachCityWithLibrary;
        }
    }

    static class Result {
        Result(int edgeCount, int firstNotVisitedVertex) {
            this.edgeCount = edgeCount;
            this.firstNotVisitedVertex = firstNotVisitedVertex;
        }

        int edgeCount;
        int firstNotVisitedVertex;
    }

    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        Result countEdgesFromNodeUsingBFS(int s, boolean visited[])
        {
            int edgeCount = -1;
            int initialStartIndex = s;
            // Mark all the vertices as not visited(By default
            // set as false)
            // boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<>();

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() != 0)
            {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                edgeCount += 1;

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext())
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }

            int firstNotVisitedVertex = -1;
            for (int i = initialStartIndex+1; i < visited.length; i++) {
                if(!visited[i]) {
                    firstNotVisitedVertex = i;
                    break;
                }
            }
            return new Result(edgeCount, firstNotVisitedVertex);
        }

    }
    // END SOLUTION WITH GRAPH STRUCTURE

    /*static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // build library in each city when cost of building library is below repairing road:
        if(c_road > c_lib)
            return n * c_lib;
        else {
            int[] assignedClustersForNodes = new int[n+1];
            int numberOfClusters = 0;
            int numberOfRoads = 0;

            for(int[] edge: cities) {
                int smallerEdge = edge[0] < edge[1] ? edge[0] : edge[1];
                int largerEdge = edge[0] > edge[1] ? edge[0] : edge[1];

                // new cluster
                if(assignedClustersForNodes[smallerEdge] == 0) {
                    numberOfClusters += 1;
                    assignedClustersForNodes[smallerEdge] = numberOfClusters;
                }

                // connect city with cluster for smaller edge
                if(assignedClustersForNodes[largerEdge] == 0) {
                    assignedClustersForNodes[largerEdge] = assignedClustersForNodes[smallerEdge];
                    numberOfRoads += 1;
                }
                else if (assignedClustersForNodes[smallerEdge] != assignedClustersForNodes[largerEdge]){
                    // connecting with other cluster
                    int prevCluster = assignedClustersForNodes[largerEdge];
                    assignedClustersForNodes[largerEdge] = assignedClustersForNodes[smallerEdge];
                    for (int i = 0; i <= n ; i++) {
                        if(assignedClustersForNodes[i] == prevCluster)
                            assignedClustersForNodes[i] = assignedClustersForNodes[smallerEdge];
                    }
                    numberOfClusters -= 1;
                    numberOfRoads += 1;
                }
            }

            int numberOfCitiesNotConnectedToAnyOtherCity = 0;
            for (int i = 1; i <= n; i++) {
                if(assignedClustersForNodes[i] == 0)
                    numberOfCitiesNotConnectedToAnyOtherCity += 1;
            }

            long costOfBuildingLibraryInEachCluster = numberOfClusters * c_lib;
            long costOfRepairingRoadsToConnectEachCityWithLibrary = numberOfRoads * c_road;
            long costOfBuildingLibrariesForSingleCities = numberOfCitiesNotConnectedToAnyOtherCity * c_lib;

            return costOfBuildingLibraryInEachCluster + costOfRepairingRoadsToConnectEachCityWithLibrary + costOfBuildingLibrariesForSingleCities;
        }
    }*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
