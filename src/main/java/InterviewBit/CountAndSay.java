package InterviewBit;

public class CountAndSay {
    public static String countAndSay(int A) {
        if(A == 1)
            return "1";
        if(A == 2)
            return "11";
        StringBuilder last = new StringBuilder();
        last.append("11");
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i = 3; i<= A; i++){
            result.delete(0, last.length());
            count = 1;
            for(int j= 1;j<last.length(); j++){
                if(last.charAt(j) == last.charAt(j-1)){
                    count++;
                }
                else{
                    result.append(count);
                    result.append(last.charAt(j-1));
                    count = 1;
                }
            }
            result.append(count);
            result.append(last.charAt(last.length()-1));
            last.delete(0, last.length());
            last.append(result);
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(countAndSay(6));
    }
}
