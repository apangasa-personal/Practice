package InterviewBit;

public class CharCount {

    public static String solve(String A) {
        int[] chars = new int[26];
        for(int i = 0; i< A.length(); i++)
            chars[A.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< A.length(); i++){
            if(chars[A.charAt(i) - 'a'] != 0){
                sb.append(A.charAt(i));
                sb.append(chars[A.charAt(i) - 'a']);
                chars[A.charAt(i) - 'a'] = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "rtzb";
        System.out.println(solve(s));
    }
}
