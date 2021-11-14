package scaler;

import java.util.HashMap;
import java.util.HashSet;

public class FindSubsequence {
    public static String solve(String A, String B) {
        int j = 0;
        int i = 0;
        for(; i< A.length(); i++){
            if(j == B.length() )
                return "NO";
            while(j < B.length()){
                if(A.charAt(i) == B.charAt(j)){
                    j++;
                    break;
                }
                else
                    j++;
            }
        }
        if(j == B.length() + 1 && i <= A.length())
            return "NO";
        return "YES";
    }

    public static void main(String[] args){
        String A = "apple", B = "appel";
        System.out.println(solve(A,B));
    }
}
