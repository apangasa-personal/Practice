package leetCode;

public class Corridor {

    public static int numberOfWays(String corridor) {
        long PCount = 0, result = 1, SCount = 0;
        int mod = 1000000007;
        for(int i = 0; i< corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                if(SCount < 2)
                    SCount++;
                else{
                    if(PCount != 0)
                        result = (result * (PCount+1))%mod;
                    SCount = 1;
                    PCount = 0;
                }
            }
            else{
                if(SCount==2)
                    PCount++;
            }
        }
        if(SCount < 2)
            return 0;
        return (int)(result%(mod))%mod ;
    }

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));

    }
}
