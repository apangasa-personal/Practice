package scaler;

public class ClosestPalindrome {
    public static String solve(String A) {
        int count = 0;
        int start = 0, end = A.length() - 1;
        while (start <= end){
            if((start == end && count != 1) || A.charAt(start) != A.charAt(end) ){
                count++;
            }
            start++;
            end--;
        }
        if(count == 1)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        String A = "abcca";
        System.out.println(solve(A));
    }
}
