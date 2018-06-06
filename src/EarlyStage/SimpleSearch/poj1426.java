package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj1426 {

    //题目看了好几便，答案输出不唯一，直接暴力枚举
    //其实bfs不剪枝的情况下等同于暴力
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long d = 1,c;
        while (!sc.hasNext("0")){
            long n = sc.nextLong();
            while (true) {
                c = Long.parseLong(Long.toBinaryString(d));
                System.out.println("c: "+c);
                if (c%n==0) break;
                d++;
            }
            System.out.println(Long.toBinaryString(d));
        }
    }
}
