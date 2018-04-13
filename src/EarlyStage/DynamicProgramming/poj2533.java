package EarlyStage.DynamicProgramming;

import java.util.Scanner;

public class poj2533 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int ans = 0;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            ans = Math.max(ans,dp[i]);
        }

        System.out.println(ans);

    }
} 
