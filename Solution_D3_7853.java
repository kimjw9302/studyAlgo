package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_D3_7853 {
    static BufferedReader br;
    static int T;
    static int[] neighbor;
    static boolean[] used;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            char[] ch = br.readLine().toCharArray();
            int previous = -1;
            int current = ch[0];
            int next = ch[1];
            neighbor = new int[ch.length];
            used = new boolean[ch.length];
            result = 0;
            if(current != next) {
                neighbor[0]=2;
            }else {
                neighbor[0] = 1;
            }
            for (int i = 1; i < ch.length - 1; i++) {
                previous = ch[i-1];
                current = ch[i];
                next = ch[i+1];
                 
                if(previous == current && current == next && previous == next) {
                    neighbor[i] = 1;
                    continue;
                }
                else if(previous == current || current == next||previous == next) {
                    neighbor[i] = 2;
                    continue;
                }
                else {
                    neighbor[i] = 3;
                    continue;
                }
            }
            current = ch[ch.length-2];
            next = ch[ch.length-1];
         
            if(current != next) {
                neighbor[ch.length-1]=2;
            }else {
                neighbor[ch.length-1]=1;
            }
             
            long sum = 1;
            for(int i = 0 ;i < ch.length; i++) {
                sum*=neighbor[i];
                sum = sum%1000000007;
            }
            System.out.println("#"+tc+ " " + sum);
        }
    }
    public static void subSet(int index) {
        if(index == used.length) {
            int k = 1;
            for(int i = 0 ; i < used.length; i++) {
                if(used[i]) {
                    k = k * neighbor[i];
                     
                }
            }
            result+=k;
            return;
        }
         
        used[index] = true;
        subSet(index+1);
        used[index] = false;
        subSet(index+1);
    }
}