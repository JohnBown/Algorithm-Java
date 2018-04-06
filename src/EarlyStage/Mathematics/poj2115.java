package EarlyStage.Mathematics;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class poj2115 {
    // @see: https://blog.csdn.net/tinyDolphin/article/details/76404340
    private static BigInteger x;
    private static BigInteger y;

    public static BigInteger exGcd(BigInteger a, BigInteger b){
        if(b.compareTo(BigInteger.valueOf(0))==0){
            x = BigInteger.valueOf(1);
            y = BigInteger.valueOf(0);
            return a;
        } else {
            BigInteger d = exGcd(b, a.mod(b));
            BigInteger temp = x;
            x = y;
            y = temp.subtract(a.divide(b).multiply(y));
            return d;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BigInteger inputA;
        BigInteger inputB;
        BigInteger inputC;
        int inputK;
        BigInteger gcd;
        while (in.hasNext()){
            inputA = in.nextBigInteger();
            inputB = in.nextBigInteger();
            inputC = in.nextBigInteger();
            inputK = in.nextInt();
            if(inputA.add(inputB).add(inputC).add(BigInteger.valueOf(inputK)).compareTo(BigInteger.valueOf(0))==0){
                break;
            }
            BigInteger b = inputB.subtract(inputA);
            BigInteger a = inputC;
            BigInteger n = BigInteger.valueOf(2).pow(inputK);
            gcd = exGcd(a,n);
            if(b.mod(gcd).compareTo(BigInteger.valueOf(0))==0){
                x = x.multiply(b.divide(gcd)).mod(n);
                x = x.add(n.divide(gcd)).mod(n.divide(gcd));
                out.println(x);
            }else {
                out.println("FOREVER");
            }
        }
        out.flush();
    }
}
