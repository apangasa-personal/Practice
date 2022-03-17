package InterviewBit;

import java.util.HashMap;

public class WindowString {

    public static Boolean check(HashMap A, HashMap B){
        for(Object key: B.keySet()){
            if(A.containsKey(key) && (int)A.get(key) >= (int)B.get(key))
                continue;
            return false;
        }
        return true;
    }

    public static String minWindow(String A, String B) {
        HashMap<Character, Integer> AMap = new HashMap<>();
        HashMap<Character, Integer> BMap = new HashMap<>();
        for(int i = 0; i < B.length(); i++){
            BMap.put(B.charAt(i), BMap.getOrDefault(B.charAt(i), 0) + 1);
        }

        int i = 0, j = 0, length = Integer.MAX_VALUE, iResult = 0, jResult = 0;

        while(j < A.length()) {
            while (check(AMap, BMap) != true && j < A.length()) {
                AMap.put(A.charAt(j), AMap.getOrDefault(A.charAt(j), 0) + 1);
                j++;
            }

            while (check(AMap, BMap) && i < j) {
                AMap.put(A.charAt(i), AMap.getOrDefault(A.charAt(i), 0) - 1);
                i++;
            }

            if(length > j - i){
                iResult = i-1;
                jResult = j;
                length = j - i;
            }
        }
        if(jResult - iResult > 0 && iResult >= 0)
            return A.substring(iResult, jResult);
        return "";
    }

    public static void main(String[] args) {
        String S = "w",
        T = "o";
        System.out.println(minWindow(S,T));

    }
}
