package scaler;

public class CountA {

    public static int solve(String A) {
        int count = 0, result = count;
        for(int i = 0; i< A.length(); i++){
            if(A.charAt(i) == 'a'){
                count++;
                result += count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String  A = "aab";
        System.out.println(solve(A));
    }
}
