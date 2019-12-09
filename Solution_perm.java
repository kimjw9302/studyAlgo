package algo.study;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_perm {
//조합 만들기
    static char[] arr;
    static int max;
    static int maxcnt,maxcnt1;
    static boolean flag;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc < TC + 1; tc++) {
            max = 0;
            flag = false;
            String[] t = sc.nextLine().split(" ");
            arr = t[0].toCharArray();
            maxcnt1 = Integer.parseInt(t[1]);
            maxcnt = maxcnt1 > arr.length ? maxcnt1 - arr.length : maxcnt1;
            for (int k = 0; k < arr.length; k++) {
                for (int i = 0; i < arr.length; i++) {
                    if (k != i && arr[k] == arr[i]) {
                        flag = true;
                        break;
                    }
                }
            }
            perm1(0, 0);
            System.out.println("#" + tc + " " + max);
             
        }
    }
 
    static void perm1(int k, int cnt) {
        if (k == arr.length) {
            if (flag) {
                if (cnt == maxcnt || cnt == maxcnt1-2) {
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        int a = (int) ((arr[i] - '0') * Math.pow(10, arr.length - i - 1));
                        sum += a;
                    }
//              System.out.println(sum);
                    max = max > sum ? max : sum;
                }
            } else {
                if (cnt == maxcnt || cnt == maxcnt1)  {
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        int a = (int) ((arr[i] - '0') * Math.pow(10, arr.length - i - 1));
                        sum += a;
                    }
                    max = max > sum ? max : sum;
                }
            }
            return;
        }
 
        for (int i = k; i < arr.length; i++) {
            swap(i, k);
            perm1(k + 1, i != k ? cnt + 1 : cnt);
            swap(i, k);
        }
    }
 
    static void swap(int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}