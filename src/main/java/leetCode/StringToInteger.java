package leetCode;

public class StringToInteger {
    public static int myAtoi(String s) {
        long ans = 0, sign = 1, numFound = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == ' ' && numFound == 0)
                continue;
            if(numFound == 0){
                if(s.charAt(i) == '-') {
                    numFound = 1;
                    sign = -1;
                }
                else if(s.charAt(i) == '+') {
                    numFound = 1;
                    continue;
                }
                else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    ans = ans * 10 + s.charAt(i) - '0';
                    numFound = 1;
                }
                else if(s.charAt(i) == ' ')
                    continue;
                else
                    break;
            }
            else if(numFound == 1) {
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    ans = ans * 10 + s.charAt(i) - '0';
                    if(ans * sign > Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                    else if (ans * sign < Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }
                else
                    break;
            }
        }
        ans = ans * sign;
        return (int)ans;
    }

    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));
    }
}
