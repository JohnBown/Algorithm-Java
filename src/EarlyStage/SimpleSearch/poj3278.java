package EarlyStage.SimpleSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class poj3278 {

    //把wait队列打印出来就可以理解算法了
    public static void main(String[] args) {
         Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int k = reader.nextInt();

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        final int MAX_N = 1000000;
        int[] step = new int[MAX_N + 5];
        boolean[] visited = new boolean[MAX_N + 5];
        // 宽搜部分↓
        Queue<Integer> wait = new LinkedList<Integer>();
        wait.add(n);
        visited[n] = true;
        int cur = 0;
        int next = 0;
        while (!wait.isEmpty()) {
            cur = wait.poll();
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        next = cur + 1;
                        break;
                    case 1:
                        next = cur - 1;
                        break;
                    case 2:
                        next = cur * 2;
                    default:
                        break;
                }
                System.out.println("next: "+next);
                if (next >= 0 && next <= MAX_N) {
                    if (!visited[next]) {
                        step[next] = step[cur] + 1;
                        wait.add(next);
                        visited[next] = true;
                    }
                    if (next == k) {
                        System.out.println(step[next]);
                        return;
                    }
                }
            }
        }
    }
}
