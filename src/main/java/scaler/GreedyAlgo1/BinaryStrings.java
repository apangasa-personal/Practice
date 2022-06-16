package scaler.GreedyAlgo1;

public class BinaryStrings {
    public static int solve(String A, int B) {
        char[] ch = A.toCharArray();
        int[] nllif = new int[A.length()];
        int flips = 0, answer = 0;
        for(int i = 0; i < A.length() - B + 1; i++){
            flips = flips + nllif[i];
            int value = (ch[i] - '0' + flips)%2;
            if(value == 0){
                answer++;
                flips++;
                if(i+B < A.length())
                nllif[i+B] = -1;
            }
        }
        for(int i = A.length() - B + 1; i < A.length(); i++){
            flips = flips + nllif[i];
            int value = (ch[i] - '0' + flips)%2;
            if(value == 0){
                return 0;
            }
        }
        return answer;
    }

    public static char[] swap(char[] ch, int i){
        if(ch[i] == '1')
            ch[i] = '0';
        else
            ch[i] = '1';
        return ch;
    }

    public static void main(String[] args) {
        String A = "00010110";
        int B = 3;
        System.out.println(solve(A,B));
    }

    
}
