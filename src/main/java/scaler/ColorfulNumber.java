package scaler;

import java.util.HashSet;

public class ColorfulNumber {
    public static int colorful(int A) {
        HashSet<Long> values = new HashSet<>();
        String s = String.valueOf(A);
        for(int i = 0; i<s.length() ; i++){
            for(int j = i; j<s.length(); j++){
                int n = Integer.valueOf(s.substring(i,j+1));
                long v = 1;
                while (n > 0){
                    v = v * (n%10);
                    n = n/10;
                }
                if(values.contains(v))
                    return 0;
                else
                    values.add(v);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int A = 234;
        System.out.println(colorful(A));
    }
}
