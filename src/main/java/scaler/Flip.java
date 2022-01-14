package scaler;

public class Flip {
    public static int[] flip(String A) {
        int currentStart = 0, currentEnd = 0, maxStart = -1, maxEnd = -1, maxZeros = 0, currentZeros = 0;
        for(int i = 0; i<A.length(); i++){
            if((int)A.charAt(i) == '0') {
                currentZeros++;
                currentEnd = i;
            }
            else if((int)A.charAt(i) == '1')
                currentZeros--;

            if(currentZeros < 0){
                currentStart = i+1;
                currentEnd =  i+1;
                currentZeros = 0;
            }
            else if(currentZeros > maxZeros){
                maxZeros = currentZeros;
                maxStart = currentStart;
                maxEnd = currentEnd;
            }
        }
        if(maxEnd == -1)
            return new int[]{};
        return new int[]{maxStart+1, maxEnd+1};
    }

    public static void main(String[] args){
        String A = "111";
        int[] v = flip(A);
        System.out.println("done");

    }

//    if(count1 == A.length())
//            return new int[]{};
//    int maxones = Integer.MIN_VALUE, current1s = 0;
//
//    int L = 0, R = 0;
//        for(int i = 0; i< A.length(); i++){
//        for(int j = i; j< A.length(); j++){
//            if(i == 2 && j == 2)
//                System.out.println("here");
//            current1s = 0;
//            if(j <= A.length() -2)
//                current1s = ones[j+1];
//            current1s += zeros[j];
//            if(i >= 1)
//                current1s += ones[0] - ones[i] - zeros[i-1];
//            if(current1s > maxones){
//                maxones = current1s;
//                L = i;
//                R = j;
//            }
//        }
//    }
//int count0= 0;
//    int count1 = 0;
//    int[] ones = new int[A.length()];
//        for (int i = A.length() - 1; i >=0; i--) {
//        if (A.charAt(i) == '1')
//            count1++;
//        ones[i] = count1;
//    }
}
