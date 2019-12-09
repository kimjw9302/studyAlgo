package algo.study;
/**************************************************************
    Problem: 1681
    User: jaewoong9302
    Language: Java
    Result: Accepted
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main_정올_해밀턴 {
    static int N;
    static int[][] value;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        value = new int[N+1][N+1];
        visited = new boolean[N+1];
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = 1 ; j<=N ;j++) {
                value[i][j] = sc.nextInt();
            }
        }
         
         
        visited[1] = true;
        for(int i = 2; i <= N ; i++) {
//          System.out.println(value[1][i]);
            if(value[1][i] == 0) {
                continue;
            }
            visited[i] = true;
            delivery(i,1,value[1][i]);
            visited[i] = false;
        }
        System.out.println(answer);
         
         
    }
    private static void delivery(int idx,int depth,int sum){
        if(depth==N-1) {
        	if(value[idx][1]!=0) 
            answer = Math.min(answer, sum+value[idx][1]);
            return;
        }
        for(int i = 1 ; i<= N; i++) {
            if(!visited[i] && value[idx][i] !=0) {
            	if(sum+value[idx][i] >=answer) continue;
                visited[i] = true;
                delivery(i,depth+1,sum+value[idx][i]);
                visited[i] = false;
             
            }
        }
    }
}