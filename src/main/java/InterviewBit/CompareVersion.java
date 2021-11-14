package InterviewBit;

public class CompareVersion {
    public static int compareVersion(String A, String B) {
        double vnum1 = 0, vnum2 = 0;
        for (int i = 0, j = 0; (i < A.length() || j < B.length());) {
            while (i < A.length() && A.charAt(i) != '.') {
                vnum1 = vnum1 * 10 + (A.charAt(i) - '0');
                i++;
            }
            while (j < B.length() && B.charAt(j) != '.') {
                vnum2 = vnum2 * 10 + (B.charAt(j) - '0');
                j++;
            }

            if (vnum1 > vnum2)
                return 1;
            if (vnum2 > vnum1)
                return -1;

            vnum1 = vnum2 = 0;
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args){
        String A = "444444444444444444444444";
        String B = "4444444444444444444444444";
        System.out.println(compareVersion(A,B));
    }
}
