package scaler.DSA;

public class SmallestPrefixString {
    public static String smallestPrefix(String A, String B) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< A.length(); i++) {
            if (A.charAt(i) <= B.charAt(0))
                sb.append(A.charAt(i));
            else
                break;
        }

        sb.append(B.charAt(0));
        for(int i = 1; i< B.length(); i++){
            if(B.charAt(i) >= B.charAt(i-1)) {
                sb.append(B.charAt(i));
            }
            else
                break;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String A = "ababa" , B = "ahahahah";
        System.out.println(smallestPrefix(A,B));
    }
}
