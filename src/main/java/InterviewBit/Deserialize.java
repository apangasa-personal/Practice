package InterviewBit;
import java.util.ArrayList;

public class Deserialize {
    public static String[] deserialize(String A) {
        ArrayList<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< A.length(); i++){
            if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z'){
                sb.append(A.charAt(i));
            }
            else{
                if(sb.toString().length() != 0)
                    values.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        String[] str = new String[values.size()];

        for (int i = 0; i < values.size(); i++) {
            str[i] = values.get(i);
        }
        return str;
    }

    public static void main(String[] args) {
        String A = "mxxxzclaql10~omttepvukq10~sckhqgagqt10~miaufqvumh10~jndrqnllah10~wqlithzmfi10~oczafaqcrz10~lnubllvcsq10~rzngzhllmw10~ntpvbeyxnk10~";
        String[] result = deserialize(A);
        System.out.println("done");
    }
}
