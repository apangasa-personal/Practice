package leetCode;

public class NumberOfLaserBeamsInaBank {

    public static int numberOfBeams(String[] bank) {
        int current = 0, next = 0, result = 0;
        for(int i = 0; i< bank.length; i++){
            for(int j = 0; j< bank[i].length(); j++){
                if(bank[i].charAt(j) == '1')
                    next++;
            }
            if(next != 0) {
                result += current * next;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] beams = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(beams));
    }
}
