package EarlyStage.DynamicProgramming;

import java.util.Scanner;

public class poj1836 {
    //TODO TLE
    static final int MAX = 10005;
    static final int INF = (int)0x3fffffff;
    static int[] l = new int[MAX];
    static int[] r = new int[MAX];
    static double[] h = new double[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=1;i<=n;i++)
            h[i] = sc.nextDouble();
        for (int i=1;i<=n;i++)
            l[i] = r[i] = 1;

        for (int i = 1; i < n; i++)//求出每个位置最长上升子序列长度
            for (int j = 1; j < i; j++)
                if(h[i]>h[j])
                    l[i] = Math.max(l[i],l[j]+1);


        for (int i = n; i >= 1; i++)//求出每个位置最长下降子序列长度
            for (int j = n; j > i; j++)
                if(h[i]>h[j])
                    r[i] = Math.max(r[i],r[i]+1);

        int in = 0;
        for (int i = 1; i < n; i++)
            for (int j = i+1; j <= n; j++)
                in = Math.max(in,(l[i]+r[j]));

        System.out.println(n-in);
    }
} 
