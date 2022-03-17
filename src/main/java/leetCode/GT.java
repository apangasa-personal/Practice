package leetCode;

import java.util.HashMap;

public class GT {

    public static long goodTriplets(int[] nums1, int[] nums2) {
        int ans = 0, n = nums2.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i< nums2.length; i++)
            m.put(nums2[i], i);

        for (int i = 0; i < n-3; i++){
            boolean foundJ = false;
            int j = 0;
            for (int k = i + 1; k < n; k++){
               if(m.get(nums1[i]) < m.get(nums1[k])){
                   if(foundJ == false){
                       foundJ = true;
                       j = k;
                       foundJ = true;
                   }
                   else{
                       if(m.get(nums1[j]) < m.get(nums1[k]))
                           ans++;
                   }
               }
            }
        }

        // Return the final count
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {4,0,1,3,2}, b = {4,1,0,2,3};
        goodTriplets(a,b);
    }
}
