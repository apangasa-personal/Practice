package InterviewBit;

public class LastWord {
    public static int lengthOfLastWord(final String A) {
        if(A.length() == 0)
            return 0;
        int i = A.length() - 1;
        while(i > -1 && A.charAt(i) == ' ')
            i--;
        if(i == -1)
            return 0;
        int j = i;
        for(;i > -1; i--){
            if(A.charAt(i) == ' ')
                break;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        String s = " ";
        lengthOfLastWord(s);
    }
}
