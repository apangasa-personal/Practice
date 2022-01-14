package leetCode;

public class FindKthBitinNthBinaryString {
    public static char findKthBit(int n, int k) {
        if (n == 1 || k == 1)
            return '0';
        StringBuilder s = new StringBuilder();
        s.append("0");
        while (n > 0){
            StringBuilder sRev = new StringBuilder();
            sRev.append(s.reverse());
            sRev.replace(0, sRev.length(), sRev.toString().replace('0', ';'));
            sRev.replace(0, sRev.length(), sRev.toString().replace('1', '0'));
            sRev.replace(0, sRev.length(), sRev.toString().replace(';', '1'));
            s.reverse().append("1").append(sRev);
            n--;
        }
        return s.charAt(k-1);
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(findKthBit(n,k));
    }
}
