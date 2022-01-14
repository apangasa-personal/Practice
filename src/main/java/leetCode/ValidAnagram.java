package leetCode;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] ch = new int[26];
        for(int i = 0; i< s.length(); i++)
            ch[s.charAt(i) - 97] += 1;

        for(int i = 0; i< t.length(); i++)
            ch[t.charAt(i) - 97] -= 1;

        for(int i = 0; i<=25; i++)
            if(ch[i] != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "agaram";
        System.out.println(isAnagram(s,t));
    }
}
