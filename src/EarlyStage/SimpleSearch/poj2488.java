package EarlyStage.SimpleSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class poj2488 {

    //魔法数组，能够保证遍历升序（字典序）
    private static final int[] DX = {-1,1,-2,2,-2,2,-1,1};
    private static final int[] DY = {-2,-2,-1,-1,1,1,2,2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for (int i = 1; i <= testcase; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean[][] visited = new boolean[row][col];
            boolean isPossible = false;
            visited[0][0] = true;
            List<String> items = new ArrayList<String>();
            items.add("A1");
            isPossible = helper(row,col,0,0,1,items,visited);
            StringBuilder sb = new StringBuilder();
            if (isPossible){
                for (String str:items){
                    sb.append(str);
                }
            }else {
                sb.append("impossible");
            }
            System.out.println("Scenario #" + i + ":");
            System.out.println(sb.toString());
            System.out.println();
        }
    }

    private static boolean helper(int row, int col, int x, int y, int num, List<String> items, boolean[][] visited){

        if (num==row*col){
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (nx<0||nx>=row||ny<0||ny>=col||visited[nx][ny]){
                continue;
            }
            items.add((char) ('A' + ny) + "" + (nx + 1));
            visited[nx][ny] = true;
            num++;
            boolean isPossible = helper(row,col,nx,ny,num,items,visited);
            if (isPossible){
                return true;
            }
            //深度优先
            //如果不能走完，则返回前一状态：回溯
            visited[nx][ny] = false;
            num--;
            items.remove(items.size()-1);
        }

        return false;
    }
}
