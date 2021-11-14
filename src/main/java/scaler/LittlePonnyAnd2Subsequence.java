package scaler;

public class LittlePonnyAnd2Subsequence {
    public static String solve(String A) {
        char smallest = ' ', smaller = ' ';
        if(A.charAt(0) > A.charAt(1)){
            smallest = A.charAt(1);
            smaller = A.charAt(0);
        }
        else{
            smallest = A.charAt(0);
            smaller = A.charAt(1);
        }
        for(int i = 2; i< A.length(); i++){
          if(A.charAt(i) < smallest){
              smaller = smallest;
              smallest = A.charAt(i);
          }
          else if(A.charAt(i) < smaller){
              smaller = A.charAt(i);
          }
        }
        if(A.indexOf(smallest) < A.indexOf(smaller))
            return String.valueOf(smallest) + smaller;
        else
            return String.valueOf(smaller) + smallest;
    }
    public static void main(String[] args){
        String A = "djjhibvetj";
        System.out.println(solve(A));
    }
}
