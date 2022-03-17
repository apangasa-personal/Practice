package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class Counts {

    public Counts() {
    }

    public static int[] solve(String A) {
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < A.length(); i++){
            m.put(A.charAt(i), m.getOrDefault(A.charAt(i), 0) + 1);
        }
        for(int i = 0; i< A.length(); i++){
            if(m.containsKey(A.charAt(i))){
                a.add(m.get(A.charAt(i)));
                m.remove(A.charAt(i));
            }
        }

        return a.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String a = "interviewbit";
        solve(a);
    }
}
