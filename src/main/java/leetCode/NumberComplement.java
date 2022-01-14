package leetCode;

public class NumberComplement {
    public static int findComplement(int num) {
        boolean msbFound = false;
        for(int i = 31; i>=0; i--){
            if(((1<<i) & num) != 0)
                msbFound = true;
            if(msbFound)
                num = num ^ (1<<i);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
