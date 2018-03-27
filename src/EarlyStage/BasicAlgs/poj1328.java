package EarlyStage.BasicAlgs;

import java.util.*;

public class poj1328 {
    static class Interval{
        double left;
        double right;
        Interval(double _left, double _right){
            this.left = _left;
            this.right = _right;
        }
    }

    static class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            double temp = o1.left - o2.left;
            if(temp==0) return 0;
            else if(temp>0) return 1;
            else return -1;
        }
    }

    static int solve(List<Interval> lists, int r){
        int rus = 1;
        double cur = lists.get(0).right;
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).left>cur){
                rus++;
                cur = lists.get(i).right;
            }else{
                cur = Math.min(cur,lists.get(i).right);
            }
        }
        return rus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, r, testcase = 0;
        List<Interval> intervals = new ArrayList<Interval>();
        while(sc.hasNext()){
            testcase++;
            intervals.clear();
            num = sc.nextInt();
            r = sc.nextInt();

            if(num==0 && r==0) break;

            boolean flag = true;
            for (int i = 0; i <num ; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(y>r) flag = false;
                double dist = Math.sqrt(r*r-y*y);
                intervals.add(new Interval(x-dist,x+dist));
            }
            if(flag){
                Collections.sort(intervals,new IntervalComparator());
                System.out.println("Case " + testcase +": " + solve(intervals, r));
            }else {
                System.out.println("Case " + testcase + ": -1");
            }
        }
    }
}
