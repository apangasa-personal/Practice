package scaler;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationOfAInB {
    public static int solve(String A, String B) {
        int count = 0;
//        HashSet<>
//        for(int i = 0; i< B.length(); i++){
//
//        }
        return count;
    }

    static final int MAX = 256;

    static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    static void search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int count = 0;
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        for (int i = M; i < N; i++)
        {
            if (compare(countP, countTW))
                count++;

            (countTW[txt.charAt(i)])++;

            countTW[txt.charAt(i-M)]--;
        }

        if (compare(countP, countTW))
           count++;

        System.out.println(count);
    }

    public static void main(String[] args){
        String A = "abc";
        String B = "abcbacabc";
        search(A, B);
//        System.out.println(search(A,B));
    }
}
