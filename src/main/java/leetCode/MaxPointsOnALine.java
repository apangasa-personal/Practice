package leetCode;

import java.util.HashMap;

public class MaxPointsOnALine {
    public static void main(String[] args){
        int[][] A= {{2,3},{3,3}, {-5,3}};

        int result = 0, temp = 0;
        HashMap<Double, Integer> slopes = new HashMap<>();
        double slopeCurrent;
        for(int i = 0; i< A.length-1; i++){
            slopes.clear();
            for(int j = i+1; j< A.length; j++){
                if(A[j][1] > A[i][1])
                    slopeCurrent = (double)(A[j][1] - A[i][1])/(A[j][0] - A[i][0]);
                else
                    slopeCurrent = (double)(A[i][1] - A[j][1])/(A[i][0] - A[j][0]);
                if(slopeCurrent == 0.0)
                    slopeCurrent = 0.0;
                if(slopes.containsKey(slopeCurrent))
                    slopes.put(slopeCurrent, slopes.get(slopeCurrent) + 1);
                else
                    slopes.put(slopeCurrent,1);
            }
            for(double key: slopes.keySet()){
                result = Math.max(result, slopes.get(key));
            }
        }
        System.out.println(result+1);
    }
}
