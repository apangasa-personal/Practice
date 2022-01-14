package leetCode;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int[] chCount = new int[26];

        for(int i = 0; i< s.length(); i++)
            if(s.charAt(i) > 96 && s.charAt(i) < 123)
                chCount[s.charAt(i) - 97] += 1;
            else if(s.charAt(i) > 64 && s.charAt(i) < 91)
                chCount[s.charAt(i) - 65] += 1;

        for(int i = 0; i< s.length(); i++)
            if(s.charAt(i) > 96 && s.charAt(i) < 123 && chCount[s.charAt(i) - 97] == 1)
                return i;
            else if(s.charAt(i) > 64 && s.charAt(i) < 91 && chCount[s.charAt(i) - 65] == 1 )
                return i;

        return -1;
    }
    public static void main(String[] args) {
        String s = "z";
        System.out.println(firstUniqChar(s));
    }
}
