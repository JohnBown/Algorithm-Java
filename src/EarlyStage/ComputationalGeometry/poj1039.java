package EarlyStage.ComputationalGeometry;

import java.util.Scanner;

public class poj1039 {
    // 链接 http://www.cnblogs.com/kuangbin/p/3192590.html
    // 其实我也很绝望，照着C++代码改，无奈Java没有运算符重载
    // 最后还RE了，跪了orz...无奈自己对Java理解不够深
    // 先标记一下，日后定AC她
    // 这题大概就是枚举，数据量也不大，就是向量运算坑爹！！！
    static double eps = 1e-8;

    static int sgn(double x) {
        if (Math.abs(x) < eps) return 0;
        if (x < 0) return -1;
        else return 1;
    }

    static class Point {
        double x, y;
        Point(double _x, double _y) {
            x = _x;
            y = _y;
        }
        static Point Minu(Point a, Point b) {   // 差
            return new Point(a.x - b.x, a.y - b.y);
        }
        static double Cross(Point a, Point b) {  // 叉积 ^
            return a.x * b.y - a.y * b.x;
        }
    }

    static class pair {
        int first;
        Point second;

        pair(int _first, Point _second) {
            first = _first;
            second = _second;
        }
    }

    static class Line {
        Point s, e;

        Line(Point _s, Point _e) {
            s = _s;
            e = _e;
        }

        static pair CheckLine(Line a, Line b) {
            Point res = a.s;
            if (sgn(Point.Cross(Point.Minu(a.s, a.e), Point.Minu(b.s, b.e))) == 0) {
                if (sgn(Point.Cross(Point.Minu(a.s, b.e), Point.Minu(b.s, b.e))) == 0)
                    return new pair(0, res);    // 重叠
                else return new pair(1, res);   // 平行
            }
            double t = Point.Cross(Point.Minu(a.s, b.s), Point.Minu(b.s, b.e))
                    / Point.Cross(Point.Minu(a.s, a.e), Point.Minu(b.s, b.e));
            res.x += (a.e.x - a.s.x) * t;
            res.y += (a.e.y - a.s.y) * t;
            return new pair(2, res);
        }
    }

    // 判断直线l1和线段l2相交
    static boolean Seg_inter_line(Line l1, Line l2) {
        return sgn(Point.Cross(Point.Minu(l2.s, l1.e), Point.Minu(l1.s, l1.e)))
                * sgn(Point.Cross(Point.Minu(l2.e, l1.e), Point.Minu(l1.s, l1.e))) <= 0;
    }

    public static void main(String[] args) {
        Point[] up = new Point[100];
        Point[] down = new Point[100];
        int n;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            n = sc.nextInt();
            if(n == 0) break;

            for(int i=0; i<n; i++){
                double ux = sc.nextDouble();
                double uy = sc.nextDouble();
                up[i] = new Point(ux,uy);
                down[i] = new Point(ux,uy-1);
            }
            boolean flag = false;   // 穿过所有标记
            double ans = -10000000.0d;
            int k;
            for(int i=0; i<n;i++){
                for(int j=i+1; j<n; j++){
                    for(k=0; k<n; k++){
                        if(!Seg_inter_line(new Line(up[i], down[j]), new Line(up[k], down[k])))
                            break;
                    }
                    if(k>=n){
                        flag = true;
                        break;
                    }
                    if(k>Math.max(i,j)){
                        if(Seg_inter_line(new Line(up[i],down[j]), new Line(up[k-1],up[k]))){
                            pair pr = Line.CheckLine(new Line(up[i],down[j]), new Line(up[k-1],up[k]));
                            Point p = pr.second;
                            ans = Math.max(ans,p.x);
                        }
                        if(Seg_inter_line(new Line(up[i],down[j]), new Line(down[k-1],down[k]))){
                            pair pr = Line.CheckLine(new Line(up[i],down[j]), new Line(down[k-1], down[k]));
                            Point p = pr.second;
                            ans = Math.max(ans,p.x);
                        }
                    }
                    for(k=0;k<n;k++){
                        if(!Seg_inter_line(new Line(down[i], up[j]), new Line(up[k], down[k])))
                            break;
                    }
                    if(k>=n){
                        flag = true;
                        break;
                    }
                    if(k>Math.max(i,j)){
                        if(Seg_inter_line(new Line(down[i],up[j]), new Line(up[k-1],up[k]))){
                            pair pr = Line.CheckLine(new Line(down[i],up[j]), new Line(up[k-1],up[k]));
                            Point p = pr.second;
                            ans = Math.max(ans, p.x);
                        }
                        if(Seg_inter_line(new Line(down[i], up[j]), new Line(down[k-1], down[k]))){
                            pair pr = Line.CheckLine(new Line(down[i],up[j]), new Line(down[k-1], down[k]));
                            Point p = pr.second;
                            ans = Math.max(ans, p.x);
                        }
                    }
                }
                if(flag) break;
            }
            if(flag) System.out.println("Through all the pipe.");
            else System.out.printf("%.2lf\n",ans);
        }
    }
}
