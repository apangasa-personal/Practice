package scaler.DSA.DP1;

public class WaysToDecode {
    public static int numDecodings(String A) {
        if(A.length() == 0)
            return 0;
        long[] values = new long[A.length() + 1];
        int mod = 1000000007;
        for(int i = 0; i < A.length()+1; i++){
            if(i < 2 ) {
                values[i] = 1;
                if(i == 1 && A.charAt(i-1) == '0')
                    values[i] = 0;
                continue;
            }
            int single = Integer.valueOf(A.charAt(i-1)) - '0';
            int doubl = Integer.valueOf(A.substring(i-2, i));
            if(single > 0 && single < 10)
                values[i] = values[i-1];
            if(doubl> 0 && doubl <= 26)
                values[i] +=  values[i-2];
            values[i] = (values[i] + mod)%mod;
        }
        return (int)values[values.length - 1];
    }

    public static long numDecodings(String A, long[] result, int i) {
        int mod = 1000000007;
        if(result[i] != -1)
            return result[i];
        long previous = numDecodings(A, result, i - 1);
        int n = Integer.valueOf(A.substring(i, i+1));
        if(n == 0){
            result[i] = previous;
            return result[i];
        }
        if(n > 0) {
            result[i] = previous;
        }
        n = Integer.valueOf(A.substring(i-1, i+1));
        if(n < 27 && n > 9)
            result[i] = result[i] + 1;
        return result[i]%mod;
    }
    public static void main(String[] args) {
        String A = "2611055971756562";
        System.out.println(numDecodings(A));
    }
}
