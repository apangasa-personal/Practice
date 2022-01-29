package scaler;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationOfAInB {

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

    public static boolean compare(int[] actual, int[] expected){
        for(int i = 0; i< actual.length; i++)
            if(actual[i] != expected[i])
                return false;
        return true;
    }

    public static int solve(String A, String B) {
        int result = 0;
        int[] actual = new int[27];
        int[] expected = new int[27];
        for(int i = 0; i< A.length(); i++){
            expected[A.charAt(i) - 'a']++;
        }
        for(int i = 0; i < A.length(); i++){
            actual[B.charAt(i) - 'a']++;
        }
        if(compare(actual, expected))
            result++;
        for(int i = A.length(); i < B.length(); i++){
            actual[B.charAt(i-A.length()) - 'a']--;
            actual[B.charAt(i) - 'a']++;
            if(compare(actual, expected))
                result++;
        }
        return result;
    }

    public static void main(String[] args){
        String A = "qc";
        String B = "qcqpqbobcpeboeqqqoppbaaqqebaddaeqcdoebeqeopebdaqobcqoboobeadeqdaceqqcbppdqedpceqabadocqbqe";
        System.out.println(solve(A, B));
//        System.out.println(search(A,B));
    }
}
