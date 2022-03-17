package InterviewBit;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class graphPoints {
    static class Graph {

        // No. of vertices
        private int V;

        // Array of lists for
        // Adjacency List
        // Representation
        private LinkedList<Integer> adj[];

        @SuppressWarnings("unchecked")
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        // Method to add an edge into the graph
        void addEdge(int v, int w) {

            // Add w to v's list.
            adj[v].add(w);
        }


        // A recursive method to count
        // all paths from 'u' to 'd'.
        int countPathsUtil(int u, int d,
                           boolean visited[],
                           int pathCount) {

            // Mark the current node as
            // visited and print it
            visited[u] = true;

            // If current vertex is same as
            // destination, then increment count
            if (u == d) {
                pathCount++;
            }

            // Recur for all the vertices
            // adjacent to this vertex
            else {
                Iterator<Integer> i = adj[u].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        pathCount = countPathsUtil(n, d, visited, pathCount);
                    }
                }
            }

            visited[u] = false;
            return pathCount;
        }

        // Returns count of
        // paths from 's' to 'd'
        int countPaths(int s, int d) {

            // Mark all the vertices
            // as not visited
            boolean visited[] = new boolean[V];
            Arrays.fill(visited, false);

            // Call the recursive method
            // to count all paths
            int pathCount = 0;
            pathCount = countPathsUtil(s, d,
                    visited,
                    pathCount);
            return pathCount;
        }
    }


    static int totalWays(int mtrx[][], int vrtx,
                         int src, int dest)
    {
        boolean []visited = new boolean[vrtx];

        // Loop to make all vertex unvisited,
        // Initially
        for (int i = 0; i < vrtx; i++) {
            visited[i] = false;
        }

        // Make source visited
        visited[src] = true;

        return countWays(mtrx, vrtx, src, dest,
                visited);
    }

    static int countWays(int mtrx[][], int vrtx,
                         int i, int dest, boolean visited[])
    {
        // Base condition
        // When reach to the destination
        if (i == dest) {

            return 1;
        }
        int total = 0;
        for (int j = 0; j < vrtx; j++) {
            if (mtrx[i][j] == 1 && !visited[j]) {

                // Make vertex visited
                visited[j] = true;

                // Recursive function, for count ways
                total += countWays(mtrx, vrtx,
                        j, dest, visited);

                // Backtracking
                // Make vertex unvisited
                visited[j] = false;
            }
        }

        // Return total ways
        return total;
    }

    public static void main(String args[])
    {
        int A = 3;
        int[][] array = new int[A][A];
        int[][] B = {{1,2}, {2,3}, {1,3}};
        for(int i = 0; i < B.length; i++){
            array[B[i][0]-1][B[i][1]-1] = 1;
            array[B[i][1]-1][B[i][0]-1] = 1;
        }
        System.out.println(totalWays(array, A, 0, A-1));
    }
}
