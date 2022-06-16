package scaler.DP3;

public class RegularExpressionMatch {
    public static int isMatch(final String A, final String B) {
        int[][] matrix = new int[A.length()][B.length()];
        for(int i = 0; i < A.length(); i++)
            for(int j = 0; j < B.length(); j++)
                matrix[i][j] = -1;
        return isMatch(A,B,matrix,A.length() - 1, B.length() - 1);
    }

    public static int isMatch(final String A, final String B, int[][] matrix, int Aptr, int Bptr) {
        if(Aptr == -1 && Bptr == -1)
            return 1;
        else if(Aptr == -1) {
            while(Bptr > -1 && B.charAt(Bptr) == '*')
                Bptr--;
            if(Bptr == -1)
                return 1;
            return 0;
        }
        else if(Bptr == -1){
            if(Aptr == -1)
                return 1;
            return 0;
        }
        if(matrix[Aptr][Bptr] != -1)
            return matrix[Aptr][Bptr];
        if(B.charAt(Bptr) == '?')
            matrix[Aptr][Bptr] = isMatch(A,B,matrix, Aptr-1, Bptr-1);

        else if(B.charAt(Bptr) == '*'){
            matrix[Aptr][Bptr] = isMatch(A,B,matrix, Aptr-1, Bptr-1) | isMatch(A,B,matrix, Aptr, Bptr-1) | isMatch(A,B,matrix, Aptr-1, Bptr) ;
        }
        else if(A.charAt(Aptr) != B.charAt(Bptr))
            matrix[Aptr][Bptr] = 0;
        else
            matrix[Aptr][Bptr] = isMatch(A,B,matrix,Aptr-1,Bptr-1);

        return matrix[Aptr][Bptr];
    }

    public static void main(String[] args) {
        String A = "aabbaaabbbaa",
        B = "a*bbb*aaa";
        System.out.println(isMatch(A,B));
    }
}
