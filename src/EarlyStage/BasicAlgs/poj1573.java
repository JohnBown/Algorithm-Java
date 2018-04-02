package EarlyStage.BasicAlgs;

import java.util.Arrays;
import java.util.Scanner;

public class poj1573 {
    static int row,col,Ncol;
    static int ans1,ans2;
    static int[][] dist;
    static int[] dir = new int[255];
    static char[][] map;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    //  S E S W E    1 -1 11 10 -1
    //  E E S N W    2  3  4  9  8
    //  N W E E N   -1 -1  5  6  7
    //  E W S E N   -1 -1 -1 -1 -1
    static boolean dfs(int cnt, int r, int c){
        int d = dir[map[r][c]];
        if(dist[r][c]==-1){
            dist[r][c]=cnt;
            int nr = r+dr[d],nc = c+dc[d];
            if(nr<0||nr>=row||nc<0||nc>=col){
                ans1=cnt;
                return true;
            }
            return dfs(cnt+1,nr,nc);
        }else{
            ans1 = dist[r][c]-1;    // 循环击中入口记录的步长
            ans2 = cnt - dist[r][c];    // 循环步长
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dir['N'] = 0;
        dir['S'] = 1;
        dir['W'] = 2;
        dir['E'] = 3;

        while (!sc.hasNext("0")){
            row = sc.nextInt();
            col = sc.nextInt();
            Ncol = sc.nextInt();

            map = new char[row][col];
            for(int i=0;i<map.length;i++){
                map[i] = sc.next().toCharArray();
            }
            dist = new int[row][col];
            for(int[] row:dist) {
                Arrays.fill(row, -1);
            }

            if(dfs(1,0,Ncol-1)) System.out.println(ans1+" step(s) to exit");
            else System.out.println(ans1 +" step(s) before a loop of "+ans2+" step(s)");

        }
    }
}
