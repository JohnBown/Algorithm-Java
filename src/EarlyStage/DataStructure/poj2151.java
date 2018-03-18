package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj2151 {
    public static void main(String[] args) {
        // DP题，初始化和DP方程，配上一些概率的知识
        // 有点绕，但总归还算简单
        int MAX_N = 1005;
        double[][][] DP = new double[MAX_N][35][35];
        double[][] P = new double[MAX_N][35];
        double[][] S = new double[MAX_N][35];

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int T = sc.nextInt();
        int N = sc.nextInt();

        while((M!=0) || (T!=0) || (N!=0)){
            for(int i=1;i<=T;i++)
                for(int j=1;j<=M;j++)
                    P[i][j] = sc.nextDouble();

            for(int i=1;i<=T;i++)
                DP[i][0][0] = 1.0;
            double P1 = 1.0,P2 = 1.0;

            for(int i=1;i<=T;i++){
                for(int j=1;j<=M;j++)
                    DP[i][j][0] = DP[i][j-1][0]*(1-P[i][j]);

                for(int j=1;j<=M;j++)
                    for(int k=1;k<=j;k++)
                        DP[i][j][k] = DP[i][j-1][k-1]*P[i][j] + DP[i][j-1][k]*(1-P[i][j]);

                S[i][0] = DP[i][M][0];

                for(int k=1;k<=M;k++)
                    S[i][k] = S[i][k-1]+DP[i][M][k];
            }

            for(int i=1;i<=T;i++){
                P1 *= (1-S[i][0]);
                P2 *= (S[i][N-1] - S[i][0]);
            }
            System.out.printf("%.3f\n",P1-P2);

            M = sc.nextInt();
            T = sc.nextInt();
            N = sc.nextInt();
        }
    }
}
