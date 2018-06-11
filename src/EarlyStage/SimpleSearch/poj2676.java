package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj2676 {

    static char[] s;
    static int[][] num = new int[9][9];
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-->0){
            flag = false;
            for (int i = 0; i < 9; i++) {
                s = sc.next().toCharArray();
                for (int j = 0; j < 9; j++) {
                    num[i][j] = s[j]-'0';
                }
            }
            dfs(0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(num[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void dfs(int n){
        if (n>80||flag){
            flag = true;
            return;
        }
        if (num[n/9][n%9]!=0){
            dfs(n+1);
        }else {
            for (int i = 1; i <= 9; i++) {
                if (ok(n,i)){
                    num[n/9][n%9] = i;
                    dfs(n+1);
                    if (flag) return;
                    num[n/9][n%9] = 0; //回溯，状态还原
                }
            }
        }
    }

    static boolean ok(int n, int cur){
        int r = n/9;
        int c = n%9;

        for (int i = 0; i < 9; i++)
            if (num[r][i] == cur)
                return false;

        for (int i = 0; i < 9; i++)
            if (num[i][c] == cur)
                return false;

        int x = r/3*3;
        int y = c/3*3;
        for (int i = x; i < x + 3; i++)
            for (int j = y; j < y + 3; j++)
                if (num[i][j] == cur)
                    return false;
        return true;
    }
}
