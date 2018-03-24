package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj1942 {
    // 一开始想打表，发现没给M N范围，只能用组合式公
    // 式算，然后提交TLE，优化组合数C(M+N,min(M,N))
    // 又提交RE，int数据范围太小，哎，水题都这么多陷阱
    static long move(long x, long y){
        long sum=1;
        for(long i=y+1,j=1;i<=x;i++,j++){
            sum = sum*i/j;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            long N = sc.nextLong();
            long M = sc.nextLong();

            if(N==0 && M==0) break;

            System.out.println(move(N+M,N>M?N:M));
        }
    }
}
