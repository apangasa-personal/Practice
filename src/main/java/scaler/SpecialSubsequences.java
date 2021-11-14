package scaler;

public class SpecialSubsequences {
    public static int solve(String A) {
        int[] GOccurrence = new int[A.length()];
        int gOcurrence = 0;
        int iter = 0;
        for(int i = A.length() - 1; i>=0; i--, iter++){
            if(A.charAt(i) == 'G')
                gOcurrence++;
            if(A.charAt(i) == 'A')
                GOccurrence[iter] = gOcurrence;
        }
        int result = 0;
        int modulo = 1000000007;
        for(int i = 0; i < GOccurrence.length; i++){
            result = (result%modulo + GOccurrence[i]%modulo)%modulo;
        }
        return result;
    }

    public static void main(String[] args){
        String A = "ABCGAG";
        System.out.println(solve(A));
    }
}
