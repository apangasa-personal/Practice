package leetCode;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1)
            return false;
        int[] kmp = new int[s.length()];
        int index = 0;
        for(int i = 1; i< s.length();){
            if(s.charAt(i) == s.charAt(index)){
                kmp[i] = index + 1;
                index++;
                i++;
            }
            else{
                if(index == 0){
                    kmp[i] = 0;
                    i++;
                }
                else{
                    index = kmp[index-1];
                }
            }
        }
        if(kmp[kmp.length - 1] % (kmp.length - kmp[kmp.length - 1]) != 0 || kmp[kmp.length - 1] == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }
}
