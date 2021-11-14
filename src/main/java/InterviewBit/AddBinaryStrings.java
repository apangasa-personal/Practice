package InterviewBit;

public class AddBinaryStrings {
    public static String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        int i = A.length() - 1, j = B.length() - 1;
        int carry = 0;
        int aval = 0, bVal = 0;
        while(i > - 1 && j > -1) {
            aval = A.charAt(i) - 48;
            bVal = B.charAt(j) - 48;
            result.append(aval ^ bVal ^ carry);
            if(aval + bVal + carry >=2)
                carry = 1;
            else
                carry = 0;
            i--;j--;
        }
        while(i > -1){
            aval = A.charAt(i) - 48;
            result.append(aval ^ carry);
            if(aval + carry >=2)
                carry = 1;
            else
                carry = 0;
            i--;
        }
        while(j > -1){
            bVal = B.charAt(j) - 48;
            result.append(bVal ^ carry);
            if(bVal + carry >=2)
                carry = 1;
            else
                carry = 0;
            j--;
        }
        if(carry == 1)
            result.append(carry);

        return result.reverse().toString();
    }

    public static void main(String[] args){
        String a = "110";
        String b = "11";
        System.out.println(addBinary(a,b));
    }
}
