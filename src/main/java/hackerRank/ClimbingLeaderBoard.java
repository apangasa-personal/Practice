package hackerRank;

import java.util.*;

public class ClimbingLeaderBoard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> sortedList = new ArrayList<Integer>();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < ranked.size(); i++) {
            if(!sortedList.contains(ranked.get(i)))
                sortedList.add(ranked.get(i));
        }
        for (int i = 0; i < player.size(); i++) {
            if(!sortedList.contains(player.get(i))) {
                sortedList.add(player.get(i));
                Collections.sort(sortedList,Collections.reverseOrder());
            }
            result.add(sortedList.indexOf(player.get(i)) + 1);
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> ranked = new LinkedList<>();
        ranked.add(100);
        ranked.add(90);
        ranked.add(90);
        ranked.add(80);
        ranked.add(75);
        ranked.add(60);
        List<Integer> player = new LinkedList<>();
        player.add(50);
        player.add(65);
        player.add(77);
        player.add(90);
        player.add(102);
        climbingLeaderboard(ranked,player);
    }
}
