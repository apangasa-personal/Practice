package leetCode;

public class RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        int direction = 0, x= 0, y=0;
        for(int i = 0; i< instructions.length(); i++){
            if(instructions.charAt(i) == 'L')
                direction = (4 + direction - 1)%4;
            else if(instructions.charAt(i) == 'R')
                direction = (direction + 1)%4;
            else{
                if(direction == 0)
                    y++;
                else if(direction == 1)
                    x++;
                else if(direction == 2)
                    y--;
                else if(direction == 3)
                    x--;
            }
            if(x==0 && y==0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }
}
