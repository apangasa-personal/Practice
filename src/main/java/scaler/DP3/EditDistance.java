package scaler.DP3;

public class EditDistance {
    public static int minDistanceCore(String A, String B, int[][] matrix, int i, int j) {
        if(i == -1 && j == -1)
            return 0;
        else if(i < 0)
            return j+1;
        if(j < 0)
            return i+1;
        if(A.charAt(i) == B.charAt(j)) {
            matrix[i][j] = minDistanceCore(A, B, matrix, i - 1, j - 1);
            return matrix[i][j];
        }
        if(matrix[i][j] != -1)
            return matrix[i][j];
        int replace = minDistanceCore(A,B,matrix, i-1,j-1);
        int remove = minDistanceCore(A,B,matrix, i-1,j);
        int add = minDistanceCore(A,B,matrix, i,j-1);
        matrix[i][j] = 1 + Math.min(Math.min(replace, remove ), add);;
        return matrix[i][j];
    }

    public static int minDistance(String A, String B) {
        int[][] matrix = new int[A.length()][B.length()];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = -1;
        int min = minDistanceCore(A,B,matrix, A.length() - 1, B.length() - 1);
        return min;
    }

    public static void main(String[] args) {
        String A = "baababaabababbaaabbbbbbababaaabbbbbbbabbabbababaaaabbbbabbbabaaababbabbbbabbabaaaabababaaabbaababbababbaabbabaabaaabaaaaaabbaaababbabbbaababbbbbbbababaaabaabbabbaaba" ,
                B = "aaabababbbaaabaaaabbaabababbbababbabaabbbbbaabbabbabaaababbaaaabaaababaabaabaaaaabbbaababbabaabaaaaabbaabaaabbbbbbbabbbababaabaaaabaabaaabbbbbbabbbbbabaaababbaaabbbabbabbaabaaababaaaabbbbabaababbbaabbbbaabbbbbaaabbbbaaababbbaaaabbbbbbbbabbbabaabbabbbabaabbbbbbaabbabaabbbbbabbabbabbaabbbabbaaabaaababbaabaababbaabbaaabababbbaabbbbabaabbaababbabbabbabbbababaaaaaaaaaaaaaaaaabbaababbaaaabbbaaabbbbaabaaaaabaaabbbaabaaaababbaaba";
        System.out.println(minDistance(A,B));
    }
}
