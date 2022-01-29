package scaler;

public class MakeStringPalindrome {
    public static int solve(String A) {
        StringBuilder complete = new StringBuilder();
        complete.append(A);
        String finalString = A + '$' + complete.reverse().toString();
        int[] kmp = new int[finalString.length()];
        int index = 0;
        for(int i = 1; i< finalString.length();){
            if(finalString.charAt(i) == finalString.charAt(index)){
                kmp[i] = index + 1;
                index++;
                i++;
            }
            else{
                if(index == 0){
                    kmp[i] = 0;
                    i++;
                }
                else{
                    index = kmp[index-1];
                }
            }
        }
        return A.length() - kmp[kmp.length - 1] ;
    }

    public static void main(String[] args) {
        String A = "eylfpbnpljvrvipyamyehwqnq";
        System.out.println(solve(A));
    }
}
