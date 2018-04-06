package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj1845 {
    static final long MOD = 9901;

    static long modPow(long a, long n){
        if(n==1) return a%MOD;
        long temp = modPow(a, n>>1);
        temp = temp*temp%MOD;
        if((n&1)==1) temp = temp*a%MOD;
        return temp;
    }

    // 因子分解
    // A=p1^a1*p2^a2...*pn^an
    //	<=> A^B=p1^(a1*B)*p2^(a2*B)...*pn^(an*B)
    static long myPow(long a, long n){
        if(n==0) return 1;
        long ans = modPow(a,(n>>1)+1);
        ans = (ans+1) % MOD;
        if((n&1)==1)
            ans = ans*myPow(a,n>>1)%MOD;
        else {
            ans = ans*myPow(a,(n-1)>>1)%MOD;
            ans = ans+modPow(a,n>>1);
        }
        return ans%MOD;
    }

    // 约数求和
    // sum = [1+p1+p1^2...+p1^(a1*B)]*[1+p2+p2^2...+p2^(a2*B)]...
    // 	*[1+pn+pn^2...+pn^(an*B)]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = 1;

        for (long i = 2; i*i <= a; i++) {
            if(a%i==0){
                long pow = 0;
                while (a%i==0){
                    a/=i;
                    pow++;
                }
                pow*=b;
                ans=ans*myPow(i,pow)%MOD;
            }
        }
        if (a!=1)
            ans = ans*myPow(a,b)%MOD;
        System.out.println((ans+MOD)%MOD);
    }
}
