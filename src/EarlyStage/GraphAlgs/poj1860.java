package EarlyStage.GraphAlgs;


import java.util.Scanner;

public class poj1860 {
    //我记得Algs.4th里面有讲“套汇”
    static int n;  //货币种数
    static int m;  //兑换种数
    static Currency[] currnecies;
    static double[] dis;   //到了第i种货币对应的货币值

    static class Currency {
        int s1;     //货币1
        int s2;     //货币2
        double r;   //汇率
        double c;   //手续费

        Currency(int _s1, int _s2, double _r, double _c) {
            this.s1 = _s1;
            this.s2 = _s2;
            this.r = _r;
            this.c = _c;
        }
    }

    static void Relax(Currency currency) {
        if (dis[currency.s2] < (dis[currency.s1] - currency.c) * currency.r)
            dis[currency.s2] = (dis[currency.s1] - currency.c) * currency.r;
    }

    static boolean isIncrease() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * m; j++) {
                Relax(currnecies[j]);
            }
        }
        for (int i = 0; i < 2 * m; i++) {
            Currency currency = currnecies[i];
            if (dis[currency.s2] < (dis[currency.s1] - currency.c) * currency.r)
                return true;
        }

        return false;
    }

    static void setM(int i, int s1, int s2, double r12, double c12, double r21, double c21) {
        currnecies[i] = new Currency(s1, s2, r12, c12);
        currnecies[i + 1] = new Currency(s2, s1, r21, c21);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int s = sc.nextInt();
        double v = sc.nextDouble();
        currnecies = new Currency[2 * m];
        dis = new double[n + 1];
        dis[s] = v;

        int i = 0;
        while (i < 2 * m) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            double r12 = sc.nextDouble();
            double c12 = sc.nextDouble();
            double r21 = sc.nextDouble();
            double c21 = sc.nextDouble();

            setM(i, s1, s2, r12, c12, r21, c21);
            i += 2;
        }

        if (isIncrease())
            System.out.println("YSE");
        else
            System.out.println("NO");


    }


}
