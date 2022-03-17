package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubstringConcatenation {
    public static boolean check(HashMap a, HashMap b){
        if(a.keySet().size() != b.keySet().size())
            return false;
        for(Object key: a.keySet())
            if(a.get(key) != b.get(key))
                return false;
        return true;
    }

    public static int[] findSubstring(String A, final String[] B) {
        int wordLength = B[0].length();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> bHashMap = new HashMap<>();
        HashMap<String, Integer> aHashMap = new HashMap<>();
        for(int i = 0; i< B.length; i++)
            bHashMap.put(B[i], bHashMap.getOrDefault(B[i], 0) + 1);
        for(int i = wordLength; i< A.length(); i = i + wordLength){
            String newVal = A.substring(i-wordLength, i);
            if(!bHashMap.containsKey(newVal))
                aHashMap.clear();
            else {
                aHashMap.put(newVal, aHashMap.getOrDefault(newVal, 0) + 1);
                if(check(aHashMap, bHashMap))
                    result.add(i-wordLength* B.length);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String S = "barfoothefoobarman";
        String[] L =  {"foo", "bar"};
        System.out.println(Arrays.toString(findSubstring(S,L)));
    }
}
