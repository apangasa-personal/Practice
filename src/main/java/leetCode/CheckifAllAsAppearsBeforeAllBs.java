package leetCode;

public class CheckifAllAsAppearsBeforeAllBs {
    public static boolean checkString(String s) {
        int indexOfA = -1, indexOfB = Integer.MAX_VALUE;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == 'a') {
                indexOfA = i;
                if(indexOfA > indexOfB)
                    return false;
            }
            else if(s.charAt(i) == 'b' && indexOfB == Integer.MAX_VALUE)
                indexOfB = i;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(checkString(s));
    }
}
