package leetCode;

public class SwapstoMakePalindrome {
    public static int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - left - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    break;
                }
                else {
                    right--;
                }
            }
            if (left == right) {
                return -1;
            }

            for (int j = right; j < n - left - 1; j++) {
                StringBuilder modified = new StringBuilder(s);
                char ch = s.charAt(j);
                modified.setCharAt(j, s.charAt(j+1));
                modified.setCharAt(j+1, ch);
                s = modified.toString();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "skwhhaaunskegmdtutlgtteunmuuludii";
        System.out.println(minMovesToMakePalindrome(s));

    }
}
