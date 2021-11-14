package leetCode;

public class validNumber2 {
    public static boolean isNumber(String A) {
        char[] ch = A.toCharArray();
        int decCount = 0;
        int digCount = 0;
        int signCount = 0;
        for (int i=0; i<ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                digCount++;
                continue;
            }
            else if (ch[i] == '+' || ch[i] == '-') {
                if (i == 0) {
                    continue;
                }
                if (ch[i-1] != 'e') {
                    return false;
                }
            }
            else if (ch[i] == ' ') {
                continue;
            }
            else if (ch[i] == '.') {
                decCount++;
                if (decCount > 1) return false;
            }
            else if (ch[i] == 'e' || ch[i] == 'E') {
                if(i+1 >= ch.length || digCount == 0) return false;
                try {
                    if (A.substring(i+1).indexOf('.') != -1) return false;
                    long num = Long.valueOf(A.substring(i+1));
                } catch(Exception e) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return digCount > 0 ? true : false;
    }
    public static void main(String[] args){
        String s = "1E9";
        System.out.println(isNumber(s));
    }

}
