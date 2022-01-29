package scaler;

public class BoringSubstring {
    public static int solve(String A){
        int evenStart = Integer.MAX_VALUE, oddStart = Integer.MAX_VALUE, evenEnd = Integer.MIN_VALUE, oddEnd = Integer.MIN_VALUE;
        for(int i = 0; i< A.length(); i++){
            if(A.charAt(i)%2 == 0){
                int val = A.charAt(i) - 'a';
                evenEnd = Math.max(evenEnd, val);
                evenStart = Math.min(evenStart, val);
            }
            else{
                int val = A.charAt(i) - 'a';
                oddEnd = Math.max(oddEnd, val);
                oddStart = Math.min(oddStart, val);
            }
        }
        if(Math.abs(oddStart - evenStart) != 1 || Math.abs(oddStart - evenEnd) != 1)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        String A ="abcd";
        System.out.println(solve(A));
    }
}
