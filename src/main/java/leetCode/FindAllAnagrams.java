package leetCode;
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static Boolean check(int[] A, int[] B){
        for(int i = 0; i< 26; i++){
            if(A[i] != B[i])
                return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())
            return null;
        int[] sArray = new int[26], pArray = new int[26];
        for(int i = 0; i< p.length(); i++){
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        if(check(pArray, sArray))
            result.add(0);
        for(int i = p.length(); i< s.length(); i++){
            sArray[s.charAt(i) - 'a']++;
            sArray[s.charAt(i-p.length()) - 'a']--;
            if(check(pArray, sArray))
                result.add(i - p.length()+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = findAnagrams(s,p);
        System.out.println("done");
    }
}
