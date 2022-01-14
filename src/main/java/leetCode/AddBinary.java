package leetCode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        for(;i>=0 && j>= 0; i--,j--){
            int v1 = Integer.valueOf(a.charAt(i)) - '0';
            int v2 = Integer.valueOf(b.charAt(j)) - '0';
            sb.append(v1 ^ v2 ^ carry);
            carry = (v1+v2+carry)/2;
        }
        while(i>=0){
            int v1 = Integer.valueOf(a.charAt(i)) - '0';
            sb.append(v1 ^ carry);
            carry = (v1+carry)/2;
            i--;
        }
        while(j>=0){
            int v2 = Integer.valueOf(b.charAt(j)) - '0';
            sb.append(v2 ^ carry);
            carry = (v2+carry)/2;
            i--;
        }
        if(carry != 0)
            sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1", b = "111";
        System.out.println(addBinary(a,b));
    }
}
