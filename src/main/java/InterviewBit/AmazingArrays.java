package InterviewBit;

public class AmazingArrays {

    public static int solve(String A) {
        int r = 0;
        for(int i = 0; i< A.length(); i++){
            char ch = A.charAt(i);
            switch(ch){
                case 'A': r = r + A.length() - i; break;
                case 'E': r = r + A.length() - i; break;
                case 'I': r = r + A.length() - i; break;
                case 'O': r = r + A.length() - i; break;
                case 'U': r = r + A.length() - i; break;
                case 'a': r = r + A.length() - i; break;
                case 'e': r = r + A.length() - i; break;
                case 'i': r = r + A.length() - i; break;
                case 'o': r = r + A.length() - i; break;
                case 'u': r = r + A.length() - i; break;

            }
        }
        return (r+10003)%10003;
    }

    public static void main(String[] args) {
        String A = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
        System.out.println(solve(A));
    }
}
