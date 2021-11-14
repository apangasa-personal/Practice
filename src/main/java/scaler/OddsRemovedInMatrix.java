package scaler;

import java.util.ArrayList;

public class OddsRemovedInMatrix {
    public static int[][] solve(int[][] A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(A.length);
        int row = 0, col = 0;
        for(int i=0; i < A.length; i++) {
            result.add(new ArrayList());
        }
        for(int i = 0; i < A.length; i++){
            row = i;
            col = 0;
            for(int j = 0; j< A[i].length; j++){

                if(A[i][j] %2 == 0){
                    result.get(row).add(A[i][j]);
                    col++;
                }
            }
        }
        int[][] intArray = result.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        return intArray;
    }
    public static void main(String[ ] args){
       int[][] arr =  {{793722473, 234646438, 927508673, 470745499, 473622314, 872148236, 360426804, 595925557, 639872757, 949571740},
               {79926276, 65161072, 612089967, 190454469, 36038718, 907354915, 384122269, 792382934, 28860461, 446602633},
               {964646880, 628308989, 588364650, 445961095, 706180582, 199988745, 488304669, 91323205, 636561155, 56080921},
               {65828230, 611465588, 902441304, 454924763, 895695004, 401568873, 987556408, 197794673, 506146646, 815414655},
               {710721742, 746356231, 437293493, 826201355, 653801873, 662208099, 173308652, 676955805, 570450167, 569294089}};
       int[][] result = solve(arr);
       System.out.println("done");

    }

}
