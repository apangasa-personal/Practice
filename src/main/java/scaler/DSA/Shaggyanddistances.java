package scaler.DSA;

import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.HashSet;

public class Shaggyanddistances {
    public static int solve(int[] A) {
        int result = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<A.length; i++){
            if(map.containsKey(A[i])){
                result = Math.min(result, i - map.get(A[i]));
            }
            map.put(A[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 3, 4, 1, 7};
        System.out.println(solve(A));
    }
}
