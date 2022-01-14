package leetCode;

public class NumberOfProvinces {
    static boolean[] visited;
    public static void findConnected(int[][] isConnected, int i){
        for(int j = 0; j< isConnected[i].length; j++){
            if(visited[j] == false){
                if(isConnected[i][j] == 1){
                    visited[j] = true;
                    findConnected(isConnected, j);
                }
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        visited =  new boolean[isConnected.length];
        int answer = 0;
        for(int i = 0; i< isConnected.length; i++){
            for(int j = 0; j <isConnected[i].length; j++){
                if(visited[i] == false) {
                    answer++;
                    findConnected(isConnected, i);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
