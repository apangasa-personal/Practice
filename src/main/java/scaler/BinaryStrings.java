package scaler;

public class BinaryStrings {
    public static char[] swap(char[] ch, int i){
        if(ch[i] == '1')
            ch[i] = '0';
        else
            ch[i] = '1';
        return ch;
    }
    public static int solve(String A, int B) {
        char[] ch = A.toCharArray();
        int result = 0;
        for(int i = 0; i < ch.length - B + 1; i++){
            if(ch[i] == '0'){
                result++;
                for(int j = 0; j < B; j++){
                    ch = swap(ch,j+i);
                }
            }
        }
        for(int i = 0; i < ch.length; i++)
            if(ch[i] == '0')
                return -1;
        return result;
    }

    public static void main(String[] args) {
        String A = "00010110";
        int B = 3;
        System.out.println(solve(A,B));
    }
}
