package scaler.DSA;

public class CyclicPermutations {
    public static int solve(String A, String B) {
        String s = A + "$" + B + B.substring(0, B.length()-1);
        int[] z = new int[s.length()];
        z[0] = s.length();
        int left = 0 , right = 0 , count = 0;
        for (int i = 1; i< s.length(); i++){
            if(i > right){
                left = i ; right = i;
                while (right < s.length() && s.charAt(right-left) == s.charAt(right))
                    right++;
                z[i] = right-left;
                right--;
            }
            else if(z[i-left] < right - i + 1){
                z[i] = z[i-left];
            }
            else{
                left = i;
                right++;
                while (right < s.length() && s.charAt(right-left) == s.charAt(right))
                    right++;
                z[i] = right-left;
                right--;
            }
            //[13, 0, 0, 1, 0, 0, 0, 1, 4, 0, 0, 1, 1]
            if(z[i] == A.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "1101111111", B = "1101111111";
        System.out.println(solve(A,B));
    }
}
