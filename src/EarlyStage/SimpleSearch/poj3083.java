package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj3083 {
    //TODO: 爆栈

    static class Node{
        int x,y;
        int rout;

        public Node() {
            this.x = -1;
            this.y = -1;
            this.rout = -1;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.rout = -1;//Default: not used.
        }

        public Node(int x, int y, int rout) {
            this.x = x;
            this.y = y;
            this.rout = rout;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", rout=" + rout +
                    '}';
        }
    }

    private static Node s,e;
    private static char[][] str;
    private static int cnt,flag,w,h;
    static final int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){
            w = sc.nextInt();
            h = sc.nextInt();
            str = new char[h][w];

            for (int i = 0; i < h; i++) {
                char[] strw = sc.next().toCharArray();
                for (int j = 0; j < w; j++) {
                    str[i][j] = strw[j];

                    if (str[i][j] == 'S'){
                        s = new Node(j,i,1);
                    } else if (str[i][j] == 'E'){
                        e = new Node(j,i);
                    }

                }
            }

//            cnt = 1;flag = 0;
//            DFS(s.x,s.y,e.x,e.y,0);
//            int ans_left = cnt;

            cnt = 1;flag = 0;
            DFS(e.x,e.y,s.x,s.y,0);
            int ans_right = cnt;

//            int ans = BFS(s);

//            System.out.println(ans_left+" "+ans_right+" "+ans);

        }

    }

    private static int BFS(Node s) {
        return 0;
    }

    private static void DFS(int x, int y, int tx, int ty, int d) {

        if (x==tx&&y==ty){
            flag=1;
            return;
        }

        d = (d+3)%4;

        for (int i = d; i < d+4; i++) {
            int tempx = x+dir[i%4][0];
            int tempy = y+dir[i%4][1];

            if (tempx>=0&&
                    tempx<h&&
                    tempy>=0&&
                    tempy<w&&
                    (str[tempx][tempy]!='#')){
                cnt++;
                d = i;
                DFS(tempx,tempy,tx,ty,d);
                if (flag!=0)
                    return;
            }
        }

    }
}
