package scaler.DSA;

public class LittlePonnyAnd2Subsequence {
    public static String solve(String A) {
        int smallest = Integer.MIN_VALUE, smaller = Integer.MIN_VALUE;
        for(int i = 0; i< A.length(); i++){
            if(smallest == Integer.MIN_VALUE)
                smallest = i;
            else if(A.charAt(i) < A.charAt(smallest) && i!= A.length() - 1){
                smallest = i;
                smaller = Integer.MIN_VALUE;
            }
            else if(smaller == Integer.MIN_VALUE)
                smaller = i;
            else{
                if(A.charAt(i) < A.charAt(smaller))
                    smaller = i;
            }
        }
        return (A.charAt(smallest) +"" + A.charAt(smaller));
    }
    public static void main(String[] args){
        String A = "scsecugqsb";
        System.out.println(solve(A));
    }
}
