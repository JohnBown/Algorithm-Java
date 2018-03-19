package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj2002 {
    // N=1000，四个点N^4暴力肯定会炸，根据矩形的几何特性
    // 已知两点可以推出另外两点（有四种情况）用hash查就好了
    static int TABLE_SIZE = 2003;
    static int[][] P = new int[1005][2];
    static Node[] table = new Node[TABLE_SIZE];

    static class Node{
        int x,y;
        Node next;

        Node(){
            next = null;
        }
        Node(int x, int y, Node node){
            this.x = x;
            this.y = y;
            this.next = node;
        }
    }

    static int hash(int x, int y){
        return (x*x+y*y)%TABLE_SIZE;
    }

    static void insert(int x, int y){
        int key = hash(x,y);
        table[key].next = new Node(x,y,table[key].next);
    }

    static boolean search(int x, int y){
        Node curNode = table[hash(x,y)].next;
        while(curNode != null){
            if(curNode.x == x && curNode.y == y) return true;
            curNode = curNode.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            for(int i=0;i<TABLE_SIZE;i++){
                table[i] = new Node();
            }
            int n = sc.nextInt();
            if(n==0)
                break;
            for(int i=0;i<n;i++){
                P[i][0] = sc.nextInt();
                P[i][1] = sc.nextInt();
                insert(P[i][0],P[i][1]);
            }

            int x1, y1, x2, y2, ans = 0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(i==j) continue;
                    x1 = P[i][0]+P[i][1]-P[j][1];
                    y1 = P[i][1]-P[i][0]+P[j][0];
                    x2 = P[j][0]+P[i][1]-P[j][1];
                    y2 = P[j][1]-P[i][0]+P[j][0];
                    if(search(x1,y1)&&search(x2,y2)) ans++;
                    x1 = P[i][0]-P[i][1]+P[j][1];
                    y1 = P[i][1]+P[i][0]-P[j][0];
                    x2 = P[j][0]-P[i][1]+P[j][1];
                    y2 = P[j][1]+P[i][0]-P[j][0];
                    if(search(x1,y1)&&search(x2,y2)) ans++;
                }
            }
            System.out.println(ans/4);

        }
    }
}
