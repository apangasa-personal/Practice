package scaler.DSA.Graph2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int solve(int[][] A) {
        Queue<Integer[]> visitedNodeQueue = new LinkedList<>();
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                if(A[i][j] == 2)
                    visitedNodeQueue.add(new Integer[]{i,j});

        visitedNodeQueue.add(null);
        int result = 0;
        int[] x = {-1,0,0,1};
        int[] y = {0,-1,1,0};
        while (visitedNodeQueue.size() != 1){
            result++;
            while (visitedNodeQueue.peek() != null) {
                Integer[] current = visitedNodeQueue.poll();
                for (int i = 0; i < x.length; i++) {
                    int newX = current[0] + x[i], newY = current[1] + y[i];
                    if (newX >= 0 && newY >= 0 && newY < A[0].length && newX < A.length && A[current[0] + x[i]][current[1] + y[i]] == 1) {
                        visitedNodeQueue.add(new Integer[]{current[0] + x[i], current[1] + y[i]});
                        A[newX][newY] = 2;
                    }
                }
            }
            visitedNodeQueue.poll();
            visitedNodeQueue.add(null);
        }
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                if(A[i][j] == 1)
                    return -1;
        return result-1;
    }

    public static void main(String[] args) {
        int[][] A = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(solve(A));
    }
}
