package EarlyStage.GraphAlgs;

import java.util.Arrays;
import java.util.Scanner;

public class poj3259 {
    //http://www.voidcn.com/article/p-hkrifoub-dc.html
    static int maxn = 7010;
    static int dis[] = new int[maxn];
    static int Max = 10000000;
    static int node;
    static class Edge{
        int st,ed;
        int val;

        public Edge(int st, int ed, int val) {
            this.st = st;
            this.ed = ed;
            this.val = val;
        }
    }

    static Edge data[] = new Edge[maxn];
    static int edgenum;
    static void addedge(int st, int ed, int val){
        edgenum++;
        data[edgenum] = new Edge(st,ed,val);
    }

    static boolean bellman_ford(int start){
        Arrays.fill(dis,Max);
        dis[start] = 0;
        for (int i = 1; i < node; i++) {
            for (int j = 1; j <= edgenum; j++) {
                if (dis[data[j].ed]>dis[data[j].st]+data[j].val)
                    dis[data[j].ed] = dis[data[j].st]+data[j].val;
            }
        }
        //一轮结束，如果仍然能松弛，则存在负环
        for (int i = 1; i < edgenum; i++) {
            if (dis[data[i].ed]>dis[data[i].st]+data[i].val)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casenum = sc.nextInt();
        while (casenum!=0){
            node = sc.nextInt();
            int M = sc.nextInt();
            int W = sc.nextInt();
            edgenum = 0;

            for (int i = 1; i <= M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int val = sc.nextInt();
                addedge(a,b,val);
                addedge(b,a,val);
            }
            for (int i = 1; i <= W; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int val = sc.nextInt();
                addedge(a,b,-val);
            }
            if (bellman_ford(1))
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
