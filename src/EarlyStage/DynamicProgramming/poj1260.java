package EarlyStage.DynamicProgramming;

import java.util.Scanner;

public class poj1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int c = sc.nextInt();
            int[] sum = new int[c];
            int[] q = new int[c];
            int[] p = new int[c];//价格

            for (int i=0;i<c;i++){
                q[i] = sum[i] = sc.nextInt();
                p[i] = sc.nextInt();
                if(i>0){
                    sum[i] =sum[i-1]+q[i];
                }
            }

            int[] dp = new int[c];
            for (int i = 0; i < c; i++) {
                dp[i] = (sum[i]+10)*p[i];
                for (int j=0;j<i;j++){
                    dp[i] = Math.min(dp[i],(sum[i]-sum[j]+10)*p[i]+dp[j]);
                }
            }
            System.out.println(dp[c-1]);
        }
    }
} 
