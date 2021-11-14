package InterviewBit;

public class AtoI {
    public static long atoi(final String A) {
        int digit = 0;
        long result = 0;
        boolean negtaive = false;
        for(int i = 0; i< A.length(); i++){
            digit = A.charAt(i);
            if(digit > 47 && digit < 58)
                result = result*10 + (digit - 48);
            else if(digit == '+' && i==0)
                continue;
            else if(digit == '-' && i==0)
                negtaive = true;
            else
                break;
        }
        if(negtaive)
            result = result * (-1);
        if((result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) && negtaive)
            return -2147483648;
        else if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return result;
    }

    public static void main(String[] args){
        String A = "-15620769845D3431 491E4 8X644 465 P18078";
        System.out.println(atoi(A));
    }
}
