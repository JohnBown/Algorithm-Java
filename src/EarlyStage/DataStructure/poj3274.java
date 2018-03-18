package EarlyStage.DataStructure;

import java.util.HashMap;
import java.util.Scanner;

/*
* 原问题N=100K，做两数相减全搜索要O(2^N)，至少也
* 要O(C_{N}^{2})用Hash存储，将问题转化成判重，要O(NK)
* 典型地用空间换时间，很魔幻
* */
public class poj3274 {
    static final int size = 100001;
    static int max_dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max_dis = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++)
            sb.append(0);
        hm.put(sb.toString(),0);
        int sum[][] = new int[N+1][K];
        int c[][] = new int[N+1][K];

        for(int i=1;i<=N;i++){
            int P = sc.nextInt();
            int feature;
            for(int j=0; j<K; j++){
                feature = P%2;
                sum[i][j] = sum[i-1][j] + feature;
                c[i][j] = sum[i][j] - sum[i][0];
                P /=2;
            }
            add(c[i],i,hm);
        }
        System.out.println(max_dis);
    }

    static void add(int[] a, int i, HashMap<String, Integer> hm){
        String data = null;
        StringBuilder sb = new StringBuilder();
        for (int anA : a) sb.append(anA);
        data = sb.toString();
        if(hm.get(data)==null){
            hm.put(data,i);
        }else{
            if(max_dis<i-hm.get(data))
                max_dis=i-hm.get(data);
        }
    }
}
