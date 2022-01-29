package leetCode;

import java.util.HashMap;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int[] values12 = new int[256];
        int[] values3 = new int[256];
        for(int i = 0; i< s1.length(); i++)
            values12[s1.charAt(i)]++;
        for(int i = 0; i< s2.length(); i++)
            values12[s2.charAt(i)]++;
        for(int i = 0; i< s3.length(); i++)
            values3[s3.charAt(i)]++;

        for(int i = 0; i<256; i++){
            if(values3[i] != values12[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aaadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
