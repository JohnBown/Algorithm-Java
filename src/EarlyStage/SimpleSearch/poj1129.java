package EarlyStage.SimpleSearch;

import java.util.Arrays;
import java.util.Scanner;

public class poj1129 {

    // https://blog.csdn.net/lhfight/article/details/7844765
    // 四色定理+dfs
    static int[][] map;
    static boolean[] colored;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("0")){
            n = sc.nextInt();

            map = new int[n][n];
            colored = new boolean[n];

            for (int i = 0; i < n; i++) {
                String str = sc.next();

                int s = str.charAt(0)-'A';
                for (int j = 2; j < str.length(); j++) {
                    int e = str.charAt(j) - 'A';
                    map[s][e] = 1;
                }
            }

            int cnum = dfs();

            if (cnum==1) System.out.println("1 channel needed.");
            else System.out.println(cnum+" channels needed.");
        }
    }

    static int dfs(){

        int color_num = 1;//颜色数目
        boolean no_side = true;//没有边

        // 如果没有边，则只需1种色
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (map[i][j]==1){
                    no_side = false;
                    break;
                }
            }
        }
        if (no_side) return color_num;

        // 存在边，则不可能需要超过4色
        for (color_num = 2; color_num<=4;color_num++){
            int[] x = new int[n];//保存每个顶点所着的颜色
            Arrays.fill(x,-1);
            if (solve(x,0,color_num,n)){
                return color_num;
            }
        }
        return -1;
    }

    static boolean solve(int[] x, int vnum, int color_num, int n){
        if (vnum==n) return true;

        for (int i = 0; i < color_num; i++) {
            x[vnum] = i;
            if (check(x,vnum,i,n)){
                if (solve(x,vnum+1,color_num,n)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean check(int[] x, int vnum, int t, int n){
        boolean find = true;
        for (int i = 0; i < n && find; i++) {
            if (map[vnum][i] == 1 && x[i] ==t){
                // 如果顶点vnum和i之间有边，并且i已经
                // 着上了颜色t，那么vnum就不能着颜色t了
                find = false;
            }
        }
        return find;
    }
}
