package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static  List<List<String>> list = new ArrayList<>();
    static List<String> temp = new ArrayList<>();
    public static Boolean isPalindrome(String str){
        int s = 0, e = str.length() -1 ;
        while(s <= e){
            if(str.charAt(s) != str.charAt(e))
                return false;
            s++;e--;
        }
        return true;
    }
    public static void solve(String s, int start, List<String> path, List<List<String>> ans){
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); ++i)
            if (isPalindrome(s.substring(start, i+1))) {
                path.add(s.substring(start, i + 1));
                solve(s, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        String s = "cdd";
        List<List<String>> list = partition(s);
        System.out.println("done");
    }


}
