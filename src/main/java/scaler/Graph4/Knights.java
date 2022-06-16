package scaler.Graph4;

import java.util.LinkedList;
import java.util.Queue;

public class Knights {
    public static int knight(int A, int B, int C, int D, int E, int F) {
        int[][] positions = {
                {-2, -1}, {-2, 1}, {2,-1}, {2,1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}
        };
        int[][] visited = new int[A][B];
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                visited[i][j] = A * B + 1;
            }
        }
        C--;D--;E--;F--;
        visited[C][D] = 1;
        moveKnight(C,D,E,F,visited, positions);
        if(visited[E][F] != A*B + 1)
            return visited[E][F]-1;
        return 0;
    }

    public  static void moveKnight(int C, int D, int E, int F, int[][] visited, int[][] positions){
        Queue<Integer[]> positionQueue = new LinkedList<>();
        positionQueue.add(new Integer[]{C,D});
        while (positionQueue.size() > 0){
            Integer[] values = positionQueue.poll();
            C = values[0];
            D = values[1];
            for(int i = 0; i < positions.length; i++){
                int newC = C + positions[i][0];
                int newD = D + positions[i][1];
                if(newC >= 0 && newC < visited.length && newD >= 0 && newD < visited[0].length && visited[newC][newD] > visited[C][D] + 1) {
                    visited[newC][newD] = visited[C][D] + 1;
                    positionQueue.add(new Integer[]{newC, newD});
                    if(newC == E && newD == F)
                        return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 8,
        B = 8,
        C = 1,
        D = 1,
        E = 8,
        F = 8;
        System.out.println(knight(A,B,C,D,E,F));
    }
}
