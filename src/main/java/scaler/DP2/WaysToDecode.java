package scaler.DP2;

public class WaysToDecode {

    public static int numDecodings(String A) {
        int last = 0, secondLast = 0, mod = 1000000007;
        if(A.charAt(A.length() - 1) == '0')
            secondLast = 0;
        else
            secondLast = 1;

        if(A.length() == 1){
            return secondLast;
        }
        int value = Integer.valueOf(A.substring(A.length() - 2, A.length()));

        if(value >= 10 && value <= 26)
            last = secondLast + 1;
        else if (value == 0)
            last = 0;
        else
            last = secondLast;

        for(int i = A.length() - 3; i >= 0; i--){
            int singleValue = Integer.valueOf(A.charAt(i)),
            doubleValue = Integer.valueOf(A.substring(i, i + 2));
            long temp = 0;
            if(doubleValue >= 10 && doubleValue <= 26){
                temp = (temp + secondLast)%mod;
            }
            if(singleValue > 0 ){
                temp = (temp + last)%mod;
            }
            secondLast = last;
            last = (int)temp;

        }
        return last;

    }

    public static void main(String[] args) {
        String A = "95";
        System.out.println(numDecodings(A));
    }
}
