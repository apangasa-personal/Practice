package scaler.DSA;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public static int solve(String A){
        int result = 1;
        int start = 0, end = 1;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(A.charAt(0));
        for(; end < A.length();){
            if(!hashSet.contains(A.charAt(end))){
                hashSet.add(A.charAt(end));
                end++;
            }
            else {
                while(A.charAt(start) != A.charAt(end)){
                    hashSet.remove(A.charAt(start));
                    start++;
                }
                start++;
                end++;
            }
            result = Math.max(end - start, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "abcabcbb";
        System.out.println(solve(A));
    }
}
