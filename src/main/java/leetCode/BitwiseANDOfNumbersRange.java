package leetCode;

public class BitwiseANDOfNumbersRange {
    public static int rangeBitwiseAnd(int left, int right) {
        int result = 0, posL = 0, posR = 0, tempL = left, tempR = right;
        for(posL = 31; tempL>0;posL--) {
            if(((1<<posL) & left) != 0)
                break;
        }
        for(posR = 31; tempL>0;posR--) {
            if(((1<<posR) & right) != 0)
                break;
        }
        if(posL != posR || left == 0 || right == 0)
            return 0;

        while(posR>=0){
            if(((1<<posR) & left) == ((1<<posR) & right)) {
                result = ((1<<posR) & left) | result;
                posR--;
            }
            else
                return result;
        }
        return result;
    }

    public static void  main(String[] rags){
        System.out.println(rangeBitwiseAnd(2,2));
    }
}
