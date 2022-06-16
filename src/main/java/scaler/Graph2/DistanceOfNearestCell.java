package scaler.Graph2;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
    public static int[][] solve(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1){
                    queue.add(new Integer[]{i,j});
                    result[i][j] = 0;
                }
                else
                    result[i][j] = A.length + A[0].length;
        }
        solve(A, result, queue);
        return result;
    }

    public static void solve(int[][] A, int[][] result, Queue<Integer[]> queue) {
        int[][] visited = new int[A.length][A[0].length];
        while (!queue.isEmpty()){
            int i = queue.peek()[0], j = queue.peek()[1];
            visited[i][j] = 1;
            queue.poll();
            if(i-1 >= 0 && visited[i-1][j] == 0){
                result[i-1][j] = Math.min(result[i-1][j], result[i][j] + 1);
                queue.add(new Integer[]{i-1,j});
            }
            if(j-1 >= 0 && visited[i][j-1] == 0){
                result[i][j-1] = Math.min(result[i][j-1], result[i][j] + 1);
                queue.add(new Integer[]{i,j-1});
            }
            if(j+1 < A[i].length && visited[i][j+1] == 0){
                result[i][j+1] = Math.min(result[i][j+1], result[i][j] + 1);
                queue.add(new Integer[]{i,j+1});
            }
            if(i+1 < A.length && visited[i+1][j] == 0){
                result[i+1][j] = Math.min(result[i+1][j], result[i][j] + 1);
                queue.add(new Integer[]{i+1,j});
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };
        int[][] result = solve(A);
        System.out.println("done");
    }
}
