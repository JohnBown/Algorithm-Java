package EarlyStage.GraphAlgs;

import java.util.Arrays;
import java.util.Scanner;

public class poj1125 {

    public static void main(String[] args) {

        int[][] mat;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n==0)
                break;

            mat = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(mat[i],999999);
            }
            for (int i = 1; i <= n; i++) {
                int pair = sc.nextInt();
                for (int j = 0; j < pair; j++) {
                    mat[i][sc.nextInt()] = sc.nextInt();
                }
            }

            //floyd
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (mat[i][j]>mat[i][k]+mat[k][j])
                            mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }

            int index = 0, max, min = 999999;
            for (int i = 1; i <= n; i++) {
                max=0;
                mat[i][i] = 0;
                for (int j = 1; j <= n; j++) {
                    if (mat[i][j]>max)
                        max = mat[i][j];
                }
                if (min>max){
                    min = max;
                    index = i;
                }
            }
            if (index==0)
                System.out.println("disjoint");
            else
                System.out.println(index+" "+min);
        }
    }
}
