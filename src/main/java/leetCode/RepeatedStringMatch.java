package leetCode;

public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        int count = (b.length() * 2)/a.length() + 1, lenA = a.length();
        if(lenA > b.length())
            count = 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++)
            sb = sb.append(a);

        a = sb.toString();
        int[] kmp = new int[b.length()];
        int j = 0;
        for(int i = 1; i< b.length();){
            if(b.charAt(i) == b.charAt(j)){
                kmp[i] = j+1;
                i++;
                j++;
            }
            else {
                if(j == 0) {
                    kmp[j] = 0;
                    i++;
                }
                else
                    j = kmp[j-1];
            }
        }
        int start = 0, bIndex = 0;
        while (start < a.length()){
            if(a.charAt(start) == b.charAt(bIndex)){
                if(bIndex == b.length() - 1)
                    return (start)/lenA + 1;
                start++;
                bIndex++;
            }
            else{
                if(bIndex != 0)
                    bIndex = kmp[bIndex-1];
                else
                    start++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "aaaaaaaaaaaaaaaaaaaaaab", b = "ba";
        System.out.println(repeatedStringMatch(a,b));
    }
}
