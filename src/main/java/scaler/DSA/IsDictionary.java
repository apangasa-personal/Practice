package scaler.DSA;

import java.util.HashSet;

public class IsDictionary {
    public static int solve(String[] A, String B) {
        int maxLength = 0;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            maxLength = Math.max(maxLength, A[i].length());
        }
        for (int i = 0; i < A.length; i++)
            hashSet.add(A[i]);

        for(int i = 1; i < A.length; i++){
            int j = 0;
            int k = 0;
            while(j < A[i-1].length() && k < A[i].length()){
                char ch1 = A[i-1].charAt(j);
                char ch2 = A[i].charAt(j);
                if(B.indexOf(ch1) > B.indexOf(ch2))
                    return 0;
                else if(B.indexOf(ch1) < B.indexOf(ch2)){
                    j = A[i-1].length();
                    break;
                }
                j++;k++;
            }
            if(j != A[i-1].length())
               return 0;
        }

        return 1;
    }

    public static void main(String[] args){
        String[] A = {"fine", "none", "no" };
        String B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(solve(A,B));
    }
}
