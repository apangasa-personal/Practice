package leetCode;

public class HiddenSequences {
    public static int solve(int[] differences, int lower , int upper){
        int smallest = differences[0], indexSmallest = 0, largest =  differences[0], indexLargest = 0;
        for(int i = 0; i< differences.length; i++){
            if(differences[i] < smallest){
                smallest = differences[i];
                indexSmallest = i;
            }
            if(differences[i] > largest){
                largest = differences[i];
                indexLargest = i;
            }
        }
        int large = 0;
        for(int i = indexSmallest; i<= indexLargest; i++){
            large = large + differences[i];
        }
        return Math.min(upper-large, Math.abs(smallest + lower));
    }

    public static void main(String[] args) {
        int[] differences = {1,-3,4};
        int lower = 1, upper = 6;
        System.out.println(solve(differences, lower, upper));
    }
}
