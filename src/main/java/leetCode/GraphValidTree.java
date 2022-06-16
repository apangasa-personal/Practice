package leetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        // write your code here
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i= 0;i< n;i++){
            adjacencyList.add(new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++){
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] visited = new int[n];
        if(dfs(adjacencyList, -1,0, visited) == false)
            return false;
        for(int i = 0; i <n; i++){
            if(visited[i] == 0)
                return false;
        }
        return true;
    }

    public static boolean dfs(ArrayList<HashSet<Integer>> adjacencyList, int parent, int node, int[] visited){
        if(visited[node] == 1)
            return false;
        visited[node] = 1;
        for(int child : adjacencyList.get(node)){
            if(child == parent)
                continue;
            if(dfs(adjacencyList, node, child, visited)== false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 100000;
        int[][] edges = {};
        System.out.println(validTree(n,edges));
    }
}
