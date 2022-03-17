package scaler;

public class MagicianAndChocolates {
    public static int[] buildHeap(int[] arr, int start){
        if(start == arr.length)
            return arr;

        int currentStart = start;

        while(true){
            int parent = (currentStart - 1)/2;

            if(parent >=0){
                if(arr[parent] < arr[currentStart]){
                    swap(arr, parent, currentStart);
                    currentStart = parent;
                }
                else
                    break;
            }
            else
                break;
        }
        arr = buildHeap(arr, start + 1);
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static  int[] heapify(int[] arr, int start){
        if(start == arr.length)
            return arr;

        int currentStart = start;

        while(true){
            int left = (2 * currentStart + 1);
            int right = (2 * currentStart + 2);
            if(left < arr.length && right < arr.length) {
                if (arr[currentStart] < arr[left] || arr[currentStart] < arr[right]) {
                    int index = left;
                    if (arr[right] > arr[left])
                        index = right;
                    swap(arr, index, currentStart);
                    currentStart = index;
                }
                else
                    break;
            }
            else if(left < arr.length){
                if (arr[currentStart] < arr[left]){
                    swap(arr, left, currentStart);
                    currentStart = left;
                }
                else break;
            }
            else
                break;
        }
        return arr;
    }

    public static int[] extract(int[] arr, int size){
        int result = arr[0];
        //arr = swap(arr, 0, size);
        arr[0] = result/2;
        arr = heapify(arr, 0);
        return arr;
    }

    public static int nchoc(int A, int[] B) {
        B = buildHeap(B, 0);
        long result = 0;
        for(int i = 0; i< A; i++){
            result += (long)B[0];
            result = result % 1000000007;
            B = extract(B, B.length - 1 - i);
        }
        return (int)((result + 1000000007)%1000000007);
    }

    public static void main(String[] args) {
        int A = 5;
        int[] b = {2, 4, 6, 8, 10};
        System.out.println(nchoc(A,b));
    }
}
