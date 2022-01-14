package leetCode;
import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobBank {
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result = new ArrayList<>();
        int[] before = new int[security.length];
        int[] after = new int[security.length];
        before[0] = 0;
        after[security.length-1] = 0;
        for(int i = 1; i<before.length; i++){
            if(security[i] <= security[i-1])
                before[i] = before[i-1] + 1;
            else
                before[i] = 0;
        }

        for(int i = security.length-2; i>=0; i--){
            if(security[i] <= security[i+1])
                after[i] = after[i+1] + 1;
            else
                after[i] = 0;
        }
        for(int i = time; i< security.length; i++ ){
            if(before[i] >= time && after[i] >= time)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args){
        int[] s = {1,1,1,1,1};
        int t = 0;
        System.out.println(String.valueOf(goodDaysToRobBank(s,t).toArray()));

    }
}
