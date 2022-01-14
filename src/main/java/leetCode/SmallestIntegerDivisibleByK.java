package leetCode;

public class SmallestIntegerDivisibleByK {
    public static int smallestRepunitDivByK(int k) {
        int residue = 1, num = 1, i = 1;
        while(i <= k){
            if(residue%k == 0)
                return i;
            else {
                residue = (residue*10)%k + 1;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int k =3;
        int result = smallestRepunitDivByK(k);
        System.out.println(result);
    }
}
