package leetCode;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();
    public static void combinationSum(int[] candidates, int target, int index, List<Integer> elements) {
        if(target == 0) {
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i< elements.size(); i++)
                values.add(elements.get(i));
            result.add(values);
            return;
        }
        for(int i = index; i< candidates.length; i++){
            if(target - candidates[i] >=0){
                elements.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, elements);
                elements.remove(elements.get(elements.size() - 1));
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(A, target);
        System.out.println("done");
    }
}
