package EarlyStage.BasicAlgs;

import java.util.Scanner;

public class poj2109 {
    // 这可能是我做过最优雅的题了吧
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext("0")){
            double n = sc.nextDouble();
            double p = sc.nextDouble();
            System.out.printf("%.0f\n",Math.pow(p, 1.0/n));
        }
    }
}
