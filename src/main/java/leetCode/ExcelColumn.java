package leetCode;

public class ExcelColumn {
    public static void main(String[] args) {
        int i = 28;
        System.out.println(convertToTitle(i));
    }

    public static String convertToTitle(int columnNumber) {
        String value = "";
        while(columnNumber > 0){
            int remainder = columnNumber%26;
            if(remainder == 0){
                value = value + 'Z';
                columnNumber = columnNumber/26 - 1;
            }
            else{
                value = value + (char)(remainder + 'A' - 1);
                columnNumber = columnNumber/26;
            }
        }
        return value;
    }
}
