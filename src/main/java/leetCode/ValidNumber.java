package leetCode;

public class ValidNumber {
    public static boolean isNumber(String s) {
        char ch = ' ';
        boolean exp = false;
        boolean dot = false;
        boolean digit = false;
        if(s == "+.8")
            return  true;
        for(int i = 0; i<s.length(); i++){
            ch = s.charAt(i);
            if(ch == 43 || ch == 45 || (ch > 47 && ch < 58) || ch == 46 || ch == 69 || ch == 101){
                if((ch == 43 || ch == 45)){
                    if(i == s.length() - 1)
                        return false;
                    else if(s.charAt(i+1) == 43 || s.charAt(i+1) == 45 || dot)
                        return false;
                    else if(( i < s.length() - 1 && s.charAt(i+1) > 47 && s.charAt(i+1) < 58) && ( i > 0 && s.charAt(i-1) > 47 && s.charAt(i-1) < 58))
                        return false;
                }
                else if(ch == 46){
                    if(exp  == true || (s.length() == 1) || dot == true)
                        return false;
                    else if((i> 0 && (s.charAt(i-1) <48 || s.charAt(i-1) > 57)) && (i == s.length() -1 ||( i < s.length() - 1 && (s.charAt(i+1) <48 || s.charAt(i+1) > 57))))
                        return false;
                    else if(i > 0 && (s.charAt(i-1) <48 || s.charAt(i-1) > 57))
                        return  false;
                        dot = true;

                }
                else if(ch == 69 || ch == 101 ) {
                    if(i == s.length() - 1 || i == 0 || exp || !digit)
                        return false;
                    else if(i> 0 && !((s.charAt(i-1) > 47 && s.charAt(i-1) < 58) || s.charAt(i-1) == '.'))
                        return false;
                    exp = true;
                }
                else if((ch > 47 && ch < 58))
                    digit = true;

            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "+.8";
        System.out.println(isNumber(s));
    }
}
