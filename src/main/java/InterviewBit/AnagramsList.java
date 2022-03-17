package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramsList {

    public static long v(String s){
        int[] r = new int[26];
        for(int i = 0; i< s.length(); i++){
            r[s.charAt(i) - 'a']++;
        }
        long v = 0;
        for(int i = 0; i< r.length; i++){
            v = v * 26 + r[i];
        }
        return v;
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<Long, ArrayList<Integer>> r = new HashMap<>();
        for(int i = 0; i< A.size(); i++){
            long v = v(A.get(i));
            if(r.containsKey(v)){
                ArrayList<Integer> n = r.get(v);
                n.add(i);
                r.put(v, n);
            }
            else{
                ArrayList<Integer> n = new ArrayList<>();
                n.add(i);
                r.put(v, n);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(long k: r.keySet()){
            result.add(r.get(k));
        }
        return result;
    }


    public static void main(String[] args) {
        String[] s = {"cat", "dog", "god", "tca"};
       anagrams(Arrays.asList(s));
    }
}
