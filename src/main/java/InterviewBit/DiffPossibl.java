package InterviewBit;

public class DiffPossibl {
    public static int diffPossible(int[] A, int B) {
        int s = 0, e = 1;
        if(B == 0){
            for(int i = 1; i < A.length; i++)
                if(A[i] == A[i-1])
                    return 1;
        }
        while(e < A.length){
            if(A[e] - A[s] == B && e != s)
                return 1;
            else if((A[e] - A[s]) > B)
                s++;
            else
                e++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = { 0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95 };
        int B = 83;
        System.out.println(diffPossible(A,B));
    }
}
