package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxScore {
    public static int highestScore(String[][] A) {
        HashMap<String, ArrayList<Integer>> numbers = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            ArrayList<Integer> values = new ArrayList<>();
            if(numbers.containsKey(A[i][0]))
                values = numbers.get(A[i][0]);
            values.add(Integer.valueOf(A[i][1]));
            numbers.put(A[i][0], values);
        }
        int max = 0;
        for(String key: numbers.keySet()){
            ArrayList<Integer> values = numbers.get(key);
            int v = 0;
            for(int i = 0 ; i< values.size(); i++)
                v += values.get(i);
            v = v/values.size();
            max = Math.max(max, v);
        }
        return max;
    }

    public static void main(String[] args) {
        String[][] A = {
                {"fqyh", "79"},
                {"fqyh", "12"},
                {"fqyh", "46"},
                {"fqyh", "45"},
                {"fqyh", "20"},
                {"fqyh", "10"},
                {"fqyh", "92"},
                {"fqyh", "93"},
                {"fqyh", "72"},
                {"fqyh", "53"},
                {"fqyh", "39"},
                {"fqyh", "99"},
                {"fqyh", "52"},
                {"fqyh", "59"}
        };
        highestScore(A);
    }
}
