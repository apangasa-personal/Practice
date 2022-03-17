package InterviewBit;

public class MinCharsReqdToMakePalindrome {

    public static int charsReqd(String a){
        String s = a +  new StringBuilder(a).reverse();
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int i = 1, l =0;
        while (i < s.length()){
            if(s.charAt(i) == s.charAt(l)){
                l++;
                lps[i] = l;
                i++;
            }
            else{
                if(l == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    l = lps[l-1];
                }
            }
        }
        return a.length() - lps[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "AACECAAAA";
        System.out.println(charsReqd(s));

    }
}
