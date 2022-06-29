package scaler.DSA;

public class ConnectRopes {

    public static int[] buildHeap(int[] arr, int start){
        if(start == arr.length)
            return arr;

        int currentStart = start;
        while(true){
            int parent = (currentStart - 1)/2;
            if(parent >= 0 && arr[currentStart] < arr[parent]){
                int temp = arr[currentStart];
                arr[currentStart] = arr[parent];
                arr[parent] = temp;
                currentStart = parent;
            }
            else
                break;
        }
        arr = buildHeap(arr, start+1);
        return arr;
    }

    public static int extractFromHeap(int[] arr, int size){
        if(size < 0)
            return 0;
        int temp = arr[0];
        arr[0] = arr[size];
        arr[size] = temp;
        int current = 0;
        while(true){
            int left = (2 * current)  + 1;
            int right = (2 * current)  + 2;
            if(left < size && right < size){
                if(arr[current] > arr[left] || arr[current] > arr[right]){
                    int index = right;
                    if(arr[left] < arr[right]){
                        index = left;
                    }
                    temp = arr[current];
                    arr[current] = arr[index];
                    arr[index] = temp;
                    current = index;
                }
                else
                    break;
            }
            else if(left < size){
                if(arr[current] > arr[left]){
                    temp = arr[current];
                    arr[current] = arr[left];
                    arr[left] = temp;
                    current = left;
                }
                else
                    break;
            }
            else
                break;
        }
        return arr[size];
    }

    public static int[] insertInHeap(int[] arr, int start){
        if(start < 0)
            return arr;

        int currentStart = start;
        int parent = (currentStart - 1)/2;
        while(parent >= 0){
            if(arr[currentStart] < arr[parent]){
                int temp = arr[currentStart];
                arr[currentStart] = arr[parent];
                arr[parent] = temp;
                currentStart = parent;
            }
            else
                break;
            parent = (currentStart - 1)/2;
        }
        return arr;
    }

    public static int solve(int[] arr) {
        int result = 0, size = arr.length - 1;
        arr = buildHeap(arr, 0);
        while (size > 0){
            int first = 0, second = 0;
            first = extractFromHeap(arr, size--);
            if(size > -1) {
                second = extractFromHeap(arr, size--);
            }
            if(second != 0){
                size++;
                arr[size] = first + second;
                arr = insertInHeap(arr, size);
            }
            result += first + second;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {16, 7, 3, 5, 9, 8, 6, 15};
        System.out.println(solve(A));
    }

}
