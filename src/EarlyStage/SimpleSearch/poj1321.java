package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj1321 {

    static char a[][];
    static int count=0,n,k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){
            n = sc.nextInt();
            k = sc.nextInt();
            if (n==-1&&k==-1) break;
            a = new char[n][n];
            String s;
            for (int i = 0; i < n; i++) {
                s = sc.next();
                for (int j = 0; j < n; j++) {
                    a[i][j] = s.charAt(j);
                }
            }
            dfs(0,k);
            System.out.println(count);
            count = 0;
        }
    }

    //cur：已经摆放的棋子数
    //left：剩余要摆放棋子数
    private static void dfs(int cur, int left) {
        if (left==0){
            count++;
            return;
        }
        for (int i = cur; i <= n - left; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j]=='.')
                    continue;
                if (check(i,j)){    //a[i][j]=='#'
                    a[i][j] = '*';
                    dfs(i+1,left-1);
                    a[i][j] = '#';  //因为不能保证k=n，回溯可以覆盖所有
                }
            }
        }
    }

    static boolean check(int x, int y){
        for (int i = 0; i < x; i++) {
            if (a[i][y]=='*')
                return false;
        }
        return true;
    }
}
