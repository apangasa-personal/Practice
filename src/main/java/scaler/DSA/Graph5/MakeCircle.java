package scaler.DSA.Graph5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MakeCircle {

    public static void main(String[] args) {
        String[] A = {"aab", "bac", "aaa", "cda"};
        System.out.println(solve(A));
    }

    public static int solve(String[] A) {
        int[] inbound = new int[256];
        int[] outbound = new int[256];
        for(int i = 0; i < A.length; i++){
            String s = A[i];
            inbound[s.charAt(A[i].length() - 1)]++;
            outbound[s.charAt(0)]++;
        }
        for(int i = 0; i < 256; i++)
            if(outbound[i] != inbound[i])
                return 0;

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < 256; i++)
            adjacencyList.add(new ArrayList<>());

        for(int i = 0; i < A.length; i++){
            adjacencyList.get(Integer.valueOf(A[i].charAt(0))).add(Integer.valueOf(A[i].charAt(A[i].length() - 1)));
        }
        int[] visited = new int[256];
        for(int i = 0; i < 256; i++){
            if(adjacencyList.get(i).size() != 0)
                visited[i] = -1;
        }
        Queue<Character> queue = new LinkedList<>();
        queue.add(A[0].charAt(0));
        while (queue.size() > 0){
            char ch = queue.poll();
            visited[ch] = 0;
            for(int chad : adjacencyList.get(ch)){
                if(visited[chad] == -1){
                    visited[chad] = 0;
                    queue.add((char) chad);
                }
            }
        }
        for(int i = 0; i < visited.length; i++)
            if(visited[i] == -1)
                return 0;
        return 1;
    }
    public static int solve1(String[] A) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
            adjacencyList.add(new ArrayList<>());
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(i == j)
                    continue;
                if(A[i].charAt(A[i].length() - 1) == A[j].charAt(0))
                    adjacencyList.get(i).add(j);
            }
        }
        int[] visited = new int[A.length];
//        for(int i = 0; i < A.length; i++){
//            int[] visited = new int[A.length];
//            boolean visitedAll = true;
//            dfs(adjacencyList, i, visited, i);
//            if(visited[i] != 2)
//                visitedAll = false;
//            else
//                for(int j = 0; j < visited.length; j++) {
//                    if (visited[i] != 1)
//                        visitedAll = false;
//                }
//            if(visitedAll == true)
//                return 1;
//        }
        if(dfs(adjacencyList, 0, visited,0, new Stack<Integer>()) == 1)
            return 1;
        return 0;
    }
    //{"aab", "bac", "aaa", "cda"};
    public static int dfs( ArrayList<ArrayList<Integer>> adjacencyList, int parent, int[] visited, int initialParent, Stack<Integer> stack) {
        if(visited[parent] == 1 && parent != initialParent)
            return 0;
        visited[parent]++;
        if(parent == initialParent && visited[parent] == 2){
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == 0) {
                    return 0;
                }
            }
            return 1;
        }
        for(Integer element : adjacencyList.get(parent)) {
            stack.add(element);
            if (dfs(adjacencyList, element, visited, initialParent, stack) == 1)
                return 1;
            else{
                int e = stack.pop();
                visited[e]--;
            }
        }
        return 0;
    }
}
