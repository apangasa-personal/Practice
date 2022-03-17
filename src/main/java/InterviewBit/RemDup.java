package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RemDup {
    public static int removeDuplicates(ArrayList<Integer> a) {
        int count = 1;
        if(a.size() < 2)
            return a.size();
        for(int i = 1; i < a.size();){
            int y = a.get(i), z = a.get(i-1);
            if(y == z){
                if(count == 2)
                    a.remove(i);
                else {
                    i++;
                    count++;
                }
            }
            else{
                count = 1; i++;
            }
        }
        return a.size();
    }

    public static int solve(Integer[] A) {
        Arrays.sort(A);
        int elementCount = 1, r = 0;

        for(int i = 1; i< A.length; i++){
            if(A[i] == A[i-1]){
                if(elementCount == 2){
                    r++;
                }
                else{
                    elementCount++;
                }
            }
            else
                elementCount = 1;
        }

        return r;
    }

    public static int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< A.length; i++)
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);

        int r = 0;
        for(int i = 0; i< A.length; i++){
            if(map.containsKey(B + A[i]))
                r = r + map.get(B + A[i]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A = { -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322};
        int B = 78;
        solve(A, B);
//        ArrayList<Integer> a = new ArrayList();
//        for(int i = 0; i< A.length; i++)
//            a.add(A[i]);
//        removeDuplicates(a);
    }

}
