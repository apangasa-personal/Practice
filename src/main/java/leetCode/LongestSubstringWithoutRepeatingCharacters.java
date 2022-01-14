package leetCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0, startIndex = 0;
        HashMap<Character, Integer> values = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            if(values.containsKey(s.charAt(i))){
                if( values.get(s.charAt(i)) >= startIndex) {
                    startIndex = values.get(s.charAt(i)) + 1;
                }
                values.put(s.charAt(i), i);
            }
            else{
                values.put(s.charAt(i), i);
            }
            result = Math.max(result, i-startIndex + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
