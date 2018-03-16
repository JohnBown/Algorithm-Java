package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj3252 {
    // 就像给出数学公式前，总要对相关性质加以描述
    // 这道题充分体现了分析问题的重要性，例如：
    // “对于8bits X，任何一个小于8位的二进制数均小于X” 这句话虽然是废话，
    // 但也是解决此题重要性质之一，做这样的描述有助于理清思路
    // 思路参考 http://www.mamicode.com/info-detail-83101.html
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Init();
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(roundNumber(b)-roundNumber(a-1));
        }
    }

    static int c[][] = new int[35][35]; // 计算组合数很容易越界
    public static void Init(){
        // Pascal’s triangle
        for(int i=0;i<33;i++){
            c[i][0] = c[i][i] = 1;
            for(int j=1;j<i;j++){
                c[i][j] = c[i-1][j]+c[i-1][j-1];
            }
        }
    }

    private static char[] toBinary(int value){
        return Integer.toBinaryString(value).toCharArray();
    }

    public static int roundNumber(int value){
        char b[] = toBinary(value);
        int sum = 0;

        // Part1: 求出len=n-1，排列满足的Rn之和
        for(int len=1; len<b.length; len++){
            for(int j=(len+1)/2;j<len;j++){
                sum +=c[len-1][j];
            }
        }

        // Part2：以X=8为例 bin(8) = 10100100
        // 分别考察：
        //          00100100
        //          00000100
        //          00000000 的排列满足的Rn之和
        int zeros = 0;
        for(int i=1; i<b.length;i++){
            if(b[i]=='1'){
                int k=(b.length+1)/2;
                int m = Math.max(0,k-(zeros+1));
                int n = b.length-i-1;
                for(int j=n;j>=m;j--){
                    sum += c[n][j];
                }
            }
            else{
                zeros++;
            }
        }

        if(2*zeros>=b.length)
            sum++;

        return sum;
    }
}
