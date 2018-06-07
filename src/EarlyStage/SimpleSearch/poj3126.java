package EarlyStage.SimpleSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class poj3126 {
    //bfs通常会维护这样一个队列，用于存储搜索过程状态的一个队列
    //如果队列被消耗完仍没有答案，则无解，此过程类似暴力枚举
    //但相比枚举优势在于：bfs获得的第一解往往是全局最优解
    //可以通俗理解为离初始状态“最近”的解

    static Queue<Integer> queue;

    static boolean marked[];

    static int steps[];

    static int original, goal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();
        for(int i = 1; i <= testNumber; i++) {
            original = sc.nextInt();
            goal = sc.nextInt();
            marked = new boolean[10000];
            steps = new int[10000];
            queue = new LinkedList<Integer>();
            boolean flag = bfs();
            if(flag)
                System.out.println(steps[goal]);
            else
                System.out.println("Impossible");
        }
    }

    private static boolean bfs() {

        queue.add(original);
        steps[original] = 0;
        marked[original] = true;

        while(!queue.isEmpty()) {

            int head = queue.poll();
            int unit = head % 10;      //获取个位
            int deca = (head % 100) / 10; //获取十位

            for(int i = 1; i <= 9; i += 2) {  //更改个位数，跳过偶数
                int temp = (head / 10) * 10 + i;
                if(!marked[temp] && isPrime(temp)) {
                    marked[temp] = true;
                    steps[temp] = steps[head] + 1;
                    queue.add(temp);
                }
            }

            for(int i = 0; i <= 9; i++) { //更改十位数
                int temp = (head / 100) * 100 + i * 10 + unit;
                if(!marked[temp] && isPrime(temp)) {
                    marked[temp] = true;
                    steps[temp] = steps[head] + 1;
                    queue.add(temp);
                }
            }

            for(int i = 0; i <= 9; i++) { //更改百位数
                int temp = (head / 1000) * 1000 + i * 100 + deca * 10 + unit;
                if(!marked[temp] && isPrime(temp)) {
                    marked[temp] = true;
                    steps[temp] = steps[head] + 1;
                    queue.add(temp);
                }
            }

            for(int i = 1; i <= 9; i++) { //更改千位数，不包括0
                int temp = head % 1000 + i * 1000;
                if(!marked[temp] && isPrime(temp)) {
                    marked[temp] = true;
                    steps[temp] = steps[head] + 1;
                    queue.add(temp);
                }
            }

            if(marked[goal])
                return true;
        }
        return false;
    }

    private static boolean isPrime(int n) { //判断是否是素数
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

}
