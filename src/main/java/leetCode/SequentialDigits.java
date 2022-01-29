package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> val = new ArrayList<>();
        while (low < high){
            String lowString = String.valueOf(low);
            String highString = String.valueOf(high);
            StringBuilder stringBuilder = new StringBuilder();
            if(lowString.length() <= highString.length()) {
                stringBuilder.append(lowString.charAt(0) - '0');
                for (int i = 1; i< lowString.length(); i++) {
                    stringBuilder.append(stringBuilder.toString().charAt(i-1) - '0' + 1);
                }
            }
            if(stringBuilder.charAt(stringBuilder.length() - 1) < stringBuilder.charAt(0)){
                low = (int) Math.pow(10, stringBuilder.length()-1);
            }
            else if(Integer.valueOf(stringBuilder.toString()) < low){
                int n = (int) Math.pow(10, stringBuilder.toString().length()-1);
                low = Integer.valueOf(stringBuilder.charAt(0) - '0' + 1) *  n;
            }
            else if(Integer.valueOf(stringBuilder.toString()) <= high) {
                val.add(Integer.valueOf(stringBuilder.toString()));
                int n = (int) Math.pow(10, stringBuilder.toString().length()-1);
                low = Integer.valueOf(stringBuilder.toString()) +  n;
            }
            else
                break;
        }
        return val;
    }

    public static void main(String[] args) {
        int low = 234    , high = 2314;
        List<Integer> values = sequentialDigits(low, high);
        System.out.println("done");
    }

}
