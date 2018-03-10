package EarlyStage.DynamicProgramming;

import java.util.Scanner;

public class poj1837 {
    public static void main(String[] args){
        // 存储钩子位置
        int[] armLen = new int[20+5];
        // 存储砝码重量
        int[] weights = new int[20+5];

        // DP[i][j] 放完i个砝码，平衡度是j的放法数
        int[][] DP = new int[20+5][20000];
        DP[0][7500] = 1;

        Scanner sc = new Scanner(System.in);
        // 钩子个数
        int nArm = sc.nextInt();
        // 砝码个数
        int nWeight = sc.nextInt();

        for(int i=1;i<=nArm;i++){
            armLen[i] = sc.nextInt();
        }
        for(int i=1;i<=nWeight;i++){
            weights[i] = sc.nextInt();
        }

        for(int i=1;i<=nWeight;++i){
            for(int j=15000;j>=0;--j){
                for(int k=1;k<=nArm;++k){
                    if(j-armLen[k]*weights[i]>=0){
                        DP[i][j] += DP[i-1][j-armLen[k]*weights[i]];
                    }
                }
            }
        }
        System.out.println(DP[nWeight][7500]);
    }
}
