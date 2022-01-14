package scaler;

public class SortedPermutationRank {
    public static int findSmallerOnRight(String A, int i){
        int val = 0;
        for(int j = i+1; j<A.length(); j++){
            if(A.charAt(j) < A.charAt(i))
                val++;
        }
        return val;
    }

    public static int fact(long i){
        int mod = 1000003;
        if(i <= 1)
            return 1;
        return (int)((i%mod) * fact(i-1)%mod)%mod;
    }
    public static int findRank(String A) {
        long answer = 0, mod = 1000003;
        for(int i = 0; i<A.length(); i++){
            int smallOnRight = findSmallerOnRight(A, i);
            int permutation = fact(A.length()-1-i);
            answer =(answer%mod + (smallOnRight%mod * permutation%mod)%mod)%mod;
        }
        return (int)answer + 1;
    }

    public static void main(String[] rags){
        String a = "ZCSFLVHXRYJQKWABGT";
        System.out.println(findRank(a));
    }
}
