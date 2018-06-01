package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj2251 {
    //像这样的迷宫题还是我的弱项，有机会开个专题加强训练一下
    //https://blog.csdn.net/emslie/article/details/54584184
    static class Node {
        int z;
        int x;
        int y;
        int step;
    }

    static int L, R, C;
    static int[] Dx = { -1, 1, 0, 0, 0, 0 };
    static int[] Dy = { 0, 0, -1, 1, 0, 0 };
    static int[] Dz = { 0, 0, 0, 0, -1, 1 };
    static char[][][] map;
    static int[][][] data;
    static int sx, sy, sz;
    static int ex, ey, ez;
    static boolean isFind;
    static Node[] queue;// 队列里数组node[x,y,z,step]

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            map = new char[L][R][C];
            data = new int[L][R][C];
            queue = new Node[L * R * C];
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            sc.nextLine();
            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    char[] line = sc.nextLine().toCharArray();
                    for (int y = 0; y < line.length; y++) {
                        map[z][x][y] = line[y];
                        if (map[z][x][y] == 'S') {
                            data[z][x][y] = 2;
                            sx = x;
                            sy = y;
                            sz = z;
                        }
                        if (map[z][x][y] == 'E') {
                            data[z][x][y] = 3;
                            ex = x;
                            ey = y;
                            ez = z;
                        }
                        if (map[z][x][y] == '.') {
                            data[z][x][y] = 0;
                        }
                        if (map[z][x][y] == '#') {
                            data[z][x][y] = 1;
                        }
                    }
                }
                sc.nextLine();
            }
            isFind = false;
            bfs(sz, sx, sy);
            if (!isFind) {
                System.out.println("Trapped!");
            }
        }
    }

    private static void bfs(int z, int x, int y) {
        int head = 0;// 头指针
        int tail = 0;// 尾指针
        Node node = new Node();
        node.z = z;
        node.x = x;
        node.y = y;
        node.step=data[z][x][y];
        queue[tail++] = node;
        while (head < tail) {
            for (int i = 0; i < 6; i++) {
                int dx = queue[head].x + Dx[i];
                int dy = queue[head].y + Dy[i];
                int dz = queue[head].z + Dz[i];
                if (dx >= 0 && dx < R && dy < C && dy >= 0 && dz >= 0 && dz < L) {
                    if (data[dz][dx][dy] == 0) {
                        data[dz][dx][dy] = 4;
                        Node node1 = new Node();// 满足传染的node
                        node1.z =queue[head].z + Dz[i];
                        node1.x =queue[head].x + Dx[i];
                        node1.y =queue[head].y + Dy[i];
                        node1.step=queue[head].step+1;
                        queue[tail++] = node1;
                    }
                    if (dx == ex && dy == ey && dz == ez) {
                        System.out.println("Escaped in " + (queue[head].step+1 - 2)
                                + " minute(s).");
                        head = tail;
                        isFind = true;
                        break;
                    }
                }
            }
            head++;
        }
    }
}