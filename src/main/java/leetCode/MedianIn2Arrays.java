package leetCode;

public class MedianIn2Arrays {

    public static double median(int[] nums1, int[] nums2){
        int l1 = nums1.length, l2 = nums2.length;
        int result = (l1 + l2)/2-1, k= 0, i= 0, j=0;
        int element1 = 0, element2 = 0;
        while(i < l1 && j < l2 && k <= result){
            if (nums1[i] <= nums2[j]) {
                element1 = nums1[i];
                i++;
            } else {
                element1 = nums2[j];
                j++;
            }
            k++;
        }
        while(i < l1 && k <= result){
            if(k == result)
                element1 = nums1[i];
            k++;
            i++;
        }
        while(j < l2 && k <= result){
            if(k == result)
                element1 = nums2[j];
            k++;
            j++;
        }
        if(i < l1 && j< l2) {
            if (nums1[i] < nums2[j])
                element2 = nums1[i];
            else
                element2 = nums2[j];
        }
        else if(i < l1)
            element2 = nums1[i];
        else
            element2 = nums2[j];
        if((l1 + l2)%2 == 0){
            return(double)(element1 + element2)/2;
        }
        return element2;
    }

    public static void main(String[] args){
       int[] nums1 = {}, nums2 = {2,3};
       System.out.println(median(nums1, nums2));
       float result = (float)5/2;
       System.out.println(result);
    }
}
