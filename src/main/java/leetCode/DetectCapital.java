package leetCode;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if(word.length() == 1)
            return true;

        boolean firstCapital = false, secondCapital = false, otherCapital = false;
        firstCapital = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' ? true : false;
        secondCapital = word.charAt(1) >= 'A' && word.charAt(1) <= 'Z' ? true : false;
        if(word.length() == 2){
            if(secondCapital == true && firstCapital == false)
                return false;
            else
                return true;
        }

        for(int i = 2; i< word.length(); i++){
            otherCapital = word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' ? true : false;
            if(otherCapital != secondCapital || firstCapital == false && otherCapital == true)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "mLZ";
        System.out.println(detectCapitalUse(word));
    }
}
