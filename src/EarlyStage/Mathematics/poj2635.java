package EarlyStage.Mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class poj2635 {
    // 用一张大表存素数，再用BigInteger水过
    // 还可以用同余取模公式：(A+B)%C = ((A%C)+(B%C))%C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000009;
        boolean np[] = new boolean[N];
        int P[] = new int[N];
        int cnt = 0;

        // 求出N内的质数
        for(int i=2;i<N;i++){
            if(!np[i]) P[cnt++] = i;
            for(int j=0;j<cnt;j++){
                if(i*P[j]>=N) break;
                np[i*P[j]] = true;
                if(i%P[j]==0) break;
            }
        }

        while(sc.hasNext()){
            BigInteger b = sc.nextBigInteger();
            int L = sc.nextInt();
            if(b.equals(BigInteger.ZERO)&&L==0) break;
            boolean flag = true;
            int ans = 0;
            for(int i=0;P[i]<L;i++){
                if(b.mod(BigInteger.valueOf(P[i])).equals(BigInteger.ZERO)){
                    flag = false;
                    ans = P[i];
                    break;
                }
            }
            if(flag) System.out.println("GOOD");
            else System.out.printf("BAD %d\n", ans);
        }
    }
}
