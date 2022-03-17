package InterviewBit;

public class Divisibleby30 {

    public static int solve(String A){
        if(A.charAt(A.length() - 1) != '0')
            return 0;
        int sum = 0;
        for(int i = 0; i< A.length(); i++)
            sum = sum + A.charAt(i) - '0';
        if(sum%3 == 0)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "3030300";
        System.out.println(solve(A));

    }
}
