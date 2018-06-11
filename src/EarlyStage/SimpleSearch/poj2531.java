package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj2531 {

    static int[][] a;
    static int[] b;
    static int n;
    static int num=0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n+1][n+1];
        b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        dfs(0,1);
        System.out.println(num);
    }

    public static void dfs(int sum, int d){

        if (d>n){
            if (sum>num){
                num = sum;
            }
            return;
        }
        int temp;

        b[d] = 1;
        temp = 0;
        for (int i = 1; i <= d; i++) {
            if (b[i]!=1){
                temp+=a[i][d];
            }
        }
        dfs(sum+temp,d+1);

        b[d] = 2;
        temp = 0;
        for (int i = 1; i <= d; i++) {
            if (b[i]!=2){
                temp+=a[i][d];
            }
        }
        dfs(sum+temp,d+1);
    }
}
