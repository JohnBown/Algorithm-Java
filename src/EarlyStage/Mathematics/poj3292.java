package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj3292 {

    final static int maxn = 1000100;
    static int num[] = new int[maxn];
    static  int H_prime[] = new int[maxn];

    static void reset(){
        for (int i = 5; i < maxn/5 ; i+=4) {
            for (int j = 5; i*j <maxn ; j+=4) {
                if(num[i]==0 && num[j]==0){
                    num[i*j] = 1;
                }
                else {
                    num[i*j] = -1;
                }
            }
        }
        int sum =0;
        for (int i = 5; i < maxn; i++) {
            if(num[i]==1){
                sum++;
            }
            H_prime[i] = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reset();
        while (!sc.hasNext("0")){
            int n = sc.nextInt();
            System.out.println(n+" "+H_prime[n]);
        }
    }
}
