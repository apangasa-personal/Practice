package leetCode;

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuilder current = new StringBuilder("1");
        StringBuilder result = new StringBuilder();
        int num = 0, count = 1, i,j=0;
        for(i= 2; i<=n; i++){
            if(result.length() > 0)
                result.delete(0, result.length());
            for(j = 1; j<current.length(); j++) {
                if (current.charAt(j) == current.charAt(j - 1))
                    count++;
                else {
                    result.append(count);
                    result.append(current.charAt(j - 1));
                    count = 1;
                }
            }
            result.append(count);
            result.append(current.charAt(j - 1));
            current.delete(0, current.length());
            current.append(result);
            count = 1;
        }

        return current.toString();
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(countAndSay(n));
    }
}
