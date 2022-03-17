package InterviewBit;

import java.util.HashSet;

public class Colorfulnumber {
    public static void main(String[] args) {
        int n  = 234;
        System.out.println(colorful(n));
    }

    public static int colorful(int A) {
       String a = A + "";
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< a.length(); i++){
            for(int j = i; j < a.length(); j++){
                int c = Integer.valueOf(a.substring(i,j+1));
                int val = 1;
                if(c < 10)
                    val = c;
                else {
                    while (c != 0) {
                        val = val * (c % 10);
                        c = c / 10;
                    }
                }
                if(set.contains(val))
                    return 0;
                else
                    set.add(val);
            }
        }
        return 1;
    }
}
