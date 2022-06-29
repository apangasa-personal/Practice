package scaler.DSA;

import java.util.HashMap;

public class CheckPalindrome {
    public static int solve(String A) {
        HashMap<Character, Integer> ele = new HashMap<>();
        for(int i = 0; i< A.length(); i++){
            if(ele.containsKey(A.charAt(i)))
                ele.put(A.charAt(i), ele.get(A.charAt(i))+1);
            else
                ele.put(A.charAt(i), 1);
        }
        int oddFound = 0;
        for(char k: ele.keySet() ){
            if((ele.get(k))%2 != 0){
                if(oddFound == 0)
                    oddFound = 1;
                else
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "inttnikjmjbemrberk";
        System.out.println(solve(s));
    }
}
