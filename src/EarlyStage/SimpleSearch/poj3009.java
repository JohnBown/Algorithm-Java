package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj3009 {

    static int[][] S;
    static int W, H;
    static int[] Dx = { -1, 0, 1, 0 };
    static int[] Dy = { 0, 1, 0, -1 };
    static int sx, sy, gx, gy, minmove;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            W = sc.nextInt();
            H = sc.nextInt();
            S = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    S[i][j] = sc.nextInt();
                    if (S[i][j]==2){
                        sx = i;
                        sy = j;
                    }
                    if (S[i][j]==3){
                        gx = i;
                        gy = j;
                    }
                }
            }
            if (W==0&&H==0)
                break;
            minmove = Integer.MAX_VALUE;
            dfs(1,sx,sy);
            if (minmove==Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(minmove);
        }
    }

    static void dfs(int step, int x, int y){
        if (step>10) return;
        for (int i=0; i<4; i++){
            int k= x+Dx[i];
            int v= y+Dy[i];

            while (k>=0&&k<H&&v>=0&&v<W&&S[k][v]!=1){
                int xx = k;
                int yy = v;

                if (S[k][v] == 3){
                    if (step<minmove){
                        minmove = step;
                    }
                }

                k = k+Dx[i];
                v = v+Dy[i];
                if (k<0||k>=H||v<0||v>=W) break;
                if (S[k][v]==1){
                    S[k][v] = 0;
                    dfs(step+1,xx,yy);
                    S[k][v]=1;
                }
            }
        }

    }

}
