package EarlyStage.ComputationalGeometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class poj2031 {
    // (参考：http://d.hatena.ne.jp/komiyam/20110222/1298374224)
    // 碍于文件目录的原因，我对代码做了些改动，但原代码设计真心不错
    // 清晰、严谨、自然，可以看出原作者对Java应用之熟练以及对OOP
    // 认识之深刻
    static int N;
    static Cell[] cells;


    static double sq(double x){ return x*x;}
    static class Cell{
        double x,y,z,r;
        Cell(double _x, double _y, double _z, double _r){
            this.x = _x;
            this.y = _y;
            this.z = _z;
            this.r = _r;
        }
        double getDist(Cell a){
            return Math.sqrt(sq(x-a.x)+sq(y-a.y)+sq(z-a.z));
        }
    }

    static class Edge{
        double dist;
        int a, b;
        Edge(double _d, int _a, int _b){
            this.dist = _d;
            this.a = _a;
            this.b = _b;
        }
    }

    static class UnionFind{
        int[] pars;
        UnionFind(int n){
            this.pars = new int[n];
            for(int i=0; i<n; i++) pars[i] = i;
        }
        int getRoot(int x){
            return x == pars[x]?x:(pars[x]=getRoot(pars[x]));
        }
        boolean isSame(int x,int y){
            return getRoot(x) == getRoot(y);
        }
        void merge(int x, int y){
            pars[getRoot(x)] = getRoot(y);
        }
    }

    static class Cmp implements Comparator<Edge>{
        public int compare(Edge e1, Edge e2){
            return Double.compare(e1.dist, e2.dist);
        }
    }

    static double solve(){
        double ret = 0.0;
        UnionFind uf = new UnionFind(N);
        ArrayList<Edge> es = new ArrayList<Edge>();
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                double d = cells[i].getDist(cells[j])-cells[i].r-cells[j].r;
                if(d<=0) uf.merge(i,j);
                else es.add(new Edge(d, i, j));
            }
        }
        Edge[] ees = (Edge[])es.toArray(new Edge[0]);
        Arrays.sort(ees, new Cmp());
        for(int i=0;i<ees.length;i++){
            if(!uf.isSame(ees[i].a, ees[i].b)){
                uf.merge(ees[i].a, ees[i].b);
                ret += ees[i].dist;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N = sc.nextInt();
            if(N==0) break;
            cells = new Cell[N];
            for(int i=0; i<N; i++){
                cells[i] = new Cell(sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            }
            System.out.printf("%.3f\n",solve());
        }
    }
}
