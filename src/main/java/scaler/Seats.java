package scaler;

import java.util.ArrayList;

public class Seats {

    public static int seats(String A) {
        ArrayList<Integer> occupied = new ArrayList<>();
        int start = 0, end = A.length() - 1;
        while(start < A.length() && A.charAt(start) == '.')
            start++;
        while(end >= 0 && A.charAt(end) == '.')
            end--;
        for(int i = start ; i <= end; i++)
            if(A.charAt(i) == 'x')
                occupied.add(i);

        if(occupied.size() == 0)
            return 0;

        int mid = occupied.get(occupied.size()/2) - 1;
        long result = 0;
        for(int i = occupied.size()/2 - 1; i >= 0; i--){
            result += (long)mid - occupied.get(i);
            result = result % 1000000007;
            mid--;
        }
        mid = occupied.get(occupied.size()/2) + 1;
        for(int i = occupied.size()/2 +1 ; i < occupied.size(); i++){
            result += (long)occupied.get(i) - mid;
            result = result % 1000000007;
            mid++;
        }
        return (int)result;
    }

    public static char[] swap(char[] ch, int i , int j){
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
        return ch;
    }

    public static void main(String[] args) {
        String  A = "x.x.xx.x.xxx.......x..x.xxx..x.xxx";
        seats(A);
    }
}
