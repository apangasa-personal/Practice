package InterviewBit;

public class Salutes {
    public static long countSalutes(String A) {
        long rCount = 0, lCount = 0, result = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '>') {
                if(lCount == 0)
                    rCount++;
                else
                    rCount = 1;
            }
            else if(A.charAt(i) == '<')
                result = result + rCount;
        }
        return  result;
    }

    public static void main(String[] args) {
        String A = ">>><<<";
        System.out.println(countSalutes(A));
    }
}
