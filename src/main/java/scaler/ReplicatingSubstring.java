package scaler;

import java.util.HashMap;
import java.util.HashSet;

public class ReplicatingSubstring {
    public static int solve(int A, String B) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< B.length(); i++){
            if(map.containsKey(B.charAt(i)))
                map.put(B.charAt(i), map.get(B.charAt(i)) + 1);
            else
                map.put(B.charAt(i), 1);
        }
        for(char key: map.keySet()){
            if(map.get(key) %A != 0)
                return -1;
        }
        return 1;
    }

    public static void main(String[] args){
        String B = "bbaabb";
        int A = 2;
        System.out.println(solve(A,B));
    }
}
