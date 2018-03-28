package EarlyStage.BasicAlgs;

import java.util.Scanner;

public class poj2586 {
    public static void main(String[] args) {
        // 考虑每五个月都亏损而整年盈利，则每五个月亏损越少
        // 全年越有可能盈利，令五个月中亏损月后置，盈利月前置
        // 形如：ddddd;sdddd;ssddd;sssdd;ssssd;sssss;
        // 求最大剩余金额，用贪心思想，让每五个月都刚好亏损
        // 每五个月s与d组合相同，比如sssdd的情况，全年盈亏有
        // sssdd sssdd ss，每五组循环且组合相同，最后求出盈亏
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
