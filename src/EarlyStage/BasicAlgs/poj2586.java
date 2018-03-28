package EarlyStage.BasicAlgs;

import java.util.Scanner;

public class poj2586 {
    public static void main(String[] args) {
        // 考虑每五个月都亏损而整年盈利，则每五个月亏损越少
        // 全年越有可能盈利，令五个月中亏损月后置，盈利月前置
        // 形如：ddddd;sdddd;ssddd;sssdd;ssssd;sssss;
        // 求最大剩余金额，用贪心思想，让每五个月都刚好亏损
        // 比如sssdd满足刚好亏损，则全年sssdd sssdd ss满足
        // 每五月八组都刚好亏损且组合得到的剩余金额最大
        int[][] arr = {{3,9},{6,6},{8,4},{10,2}};
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int s = sc.nextInt();   // 盈利
            int d = sc.nextInt();   // 亏损

            int i;
            for(i=4; i>0;i--) if(s*i<d*(5-i))  break;

            if((i==0) || (s*arr[i-1][0]<d*arr[i-1][1])) System.out.println("Deficit");
            else System.out.println(s*arr[i-1][0]-d*arr[i-1][1]);
        }
    }
}
