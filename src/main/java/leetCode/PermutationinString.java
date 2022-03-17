package leetCode;

public class PermutationinString {
    public static boolean check(int[] a, int[] b){
        for(int i = 0; i< 26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for(int i = 0; i< s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        if(check(s1Array, s2Array))
            return true;
        for(int i = s1.length(); i< s2.length(); i++){
            s2Array[s2.charAt(i) - 'a']++;
            s2Array[s2.charAt(i - s1.length()) - 'a']--;
            if(check(s1Array, s2Array))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "ccc",
        b = "cbac";
        System.out.println(checkInclusion(a,b));
    }
}
