package InterviewBit;
import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLists {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        System.out.println("done");
    }

    public static void main(String[] args) {
        int[] A = {-4, 3};
        int[] B =  {-2, -2};
        ArrayList<Integer> intList1 = new ArrayList<Integer>(A.length);
        for (int i : A)
        {
            intList1.add(i);
        }
        ArrayList<Integer> intList2 = new ArrayList<Integer>(B.length);
        for (int i : B)
        {
            intList2.add(i);
        }
        merge(intList1, intList2);
    }

}
