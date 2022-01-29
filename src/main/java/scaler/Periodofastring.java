package scaler;

public class Periodofastring {

    public static int solve(String A) {
        int left = 0, right = 0;
        int[] z = new int[A.length()];
        z[0] = A.length();
        for(int i = 1; i< A.length(); i++){
            if(i > right){
                left = i;
                right = i;
                while(right < A.length() && A.charAt(right) == A.charAt(right-left)){
                    right++;
                }
                z[i] = right - left;
                right--;
            }
            else if(z[i-left] < right - i + 1 )
                z[i] = z[i - left];
            else{
                left = i;
                right++;
                while(right < A.length() &&  A.charAt(right) == A.charAt(right-left)){
                    right++;
                }
                z[i] = right - left;
                right--;
            }
            if(z[i] + i == A.length())
                return i;
        }
        return A.length();
    }

    public static void main(String[] args) {
        String A = "abababababb";
        System.out.println(solve(A));
    }
}
