package leetCode;

public class CountNumberOfMaximumBitwiseORSubsets {
    public static int countMaxOrSubsets(int[] nums) {
        int resultVal = 0, count = 0;
        for(int i = 0; i<nums.length; i++)
            resultVal = resultVal | nums[i];

        long total = (long) Math.pow(2, nums.length);
        for(int i = 1; i< total; i++){
            int current = 0;
            for(int j = 0; j<32; j++){
                if((1 << j) > i)
                    break;
                int v1 = 1<<j;
                if((v1 & i) != 0)
                    current = current | nums[j];
            }
            if(current == resultVal)
                count++;
        }

        return count;
    }

    public static void main(String[] rags){
        int[] A = {3,2,1,5};
        System.out.println(countMaxOrSubsets(A));
    }

}
