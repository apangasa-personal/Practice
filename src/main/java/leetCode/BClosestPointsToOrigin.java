package leetCode;
import java.util.Arrays;

public class BClosestPointsToOrigin {
    public static int[][] kClosest(int[][] pts, int k) {
        int n = pts.length;
        int[] distance = new int[n];
        for(int i = 0; i < n; i++)
        {
            int x = pts[i][0], y = pts[i][1];
            distance[i] = (x * x) + (y * y);
        }

        Arrays.sort(distance);

        // Find the k-th distance
        int distk = distance[k - 1];
        int[][] result = new int[k][2];

        // Print all distances which are
        // smaller than k-th distance
        int id = 0;
        for(int i = 0; i < n; i++)
        {
            int x = pts[i][0], y = pts[i][1];
            int dist = (x * x) + (y * y);

            if (dist <= distk){
                result[id][0] = x;
                result[id][1] = y;
                id++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{3,3},{5,-1},{-2,4}};
        int[][] result = kClosest(A, 2);
        System.out.println("done");
    }
}
