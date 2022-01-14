package scaler;

public class Fibo {
    public static void fibo(int num){
        if(num == 0) {
            System.out.println(0);
            return;
        }
        if(num  == 1) {
            System.out.println("0 1");
            return;
        }
        System.out.print("0 1");
        int first = 0, second = 1, temp;
        do{
            temp = first + second;
            System.out.print(" " + temp);
            first = second;
            second = temp;

        }while (temp < num);
        return;
    }
    public static void main(String[] args){
        fibo(377);
    }
}
