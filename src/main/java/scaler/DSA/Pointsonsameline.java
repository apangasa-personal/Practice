package scaler.DSA;

import java.util.HashMap;
import java.util.Map;

public class Pointsonsameline {

    public static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
    public static int solve(int[] A, int[] B) {
        int result = 0;
        for(int i = 0; i< A.length; i++){
            HashMap<String, Integer> slopes = new HashMap<>();
            int duplicate = 0, ypoints = 0;
            for(int j = i+1; j< B.length; j++){
                if(A[j] == A[i] && B[j] == B[i]) {
                    duplicate++;
                }
                else if (A[j] == A[i])
                    ypoints++;
                else {
                    double x = A[j] - A[i], y = B[j] - B[i];
                    int gcd = gcd((int)x,(int)y);
                    x = x/gcd; y = y/gcd;
                    if(y < 0){
                        y = y * (-1);
                        x = x * (-1);
                    }
                    String slope = (x) + "" + (y);
                    slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                    result = Math.max(result, slopes.get(slope));
                }
            }
            result = Math.max(result, ypoints);
            result  += duplicate;
        }
        return result + 1;
    }

    public static int solve1(int[] A, int[] B){
        int result = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.clear();
            int overlap = 0;
            int max = 0;
            for (int j = i+1; j < A.length; j++) {
                int x = A[j] - A[i];
                int y = B[j] - B[i];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if(map.containsKey(x)) {
                    if(map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                }
                else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[]   A = {4, 7, 4, 2, 4},
                B = {-2, -9, -1, -4, -9};
        System.out.println(solve(A,B));
        System.out.println(solve1(A,B));
    }
}
