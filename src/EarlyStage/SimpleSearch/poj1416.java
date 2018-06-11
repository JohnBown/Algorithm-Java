package EarlyStage.SimpleSearch;

import java.util.Scanner;

public class poj1416 {
    //https://tw.saowen.com/a/87c753453109a9e8ba18cf4bc8ab559c9042cd6e375a49290765a38bed16103f
    //剪枝思路：在搜索时发现部分和大于（不能等于）target时，则可结束搜索
    static int targ;
    static int a;
    static class Node
    {
        int x;int y;Node pre;
        Node(int x, int y, Node pre)
        {
            this.x=x;
            this.y=y;
            this.pre=pre;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        targ=sc.nextInt();
        a=sc.nextInt();
        while(a!=0 && targ!=0)
        {
            count=0;
            sum=-1;
            Node begin=new Node(a, -1, null);
            dfs(a, 0, 0, begin);
            if(count==0)
            {
                System.out.println("error");
            }else if (count==1)
            {
                System.out.print(sum+" ");
                print(p);
            }else
            {
                System.out.println("rejected");
            }
            targ=sc.nextInt();
            a=sc.nextInt();
        }
    }

    static int count=0;
    static int sum=-1;
    static Node p;
    static void dfs(int x,int y,int z,Node node)//
    {
        int tmp=x+y+z;
        if(tmp<=targ && tmp>sum)
        {
            sum=tmp;
            count=1;
            p=node;
        }else if(tmp==sum)
        {
            count++;
        }
        if(x/10==0) return;
        for(int i=1;i<=5;i++)
        {
            int dx=x/(int)Math.pow(10, i);
            int dy=x%(int)Math.pow(10, i);
            if(dx==0) break;
            Node next=new Node(dx, dy, node);
            dfs(dx, dy, z+y,next);//将x拆成dx和dy,z+y:表示除dx和dy外其余已拆部分的和
        }
    }
    static void print(Node p)
    {
        if(p.y!=-1)
        {
            System.out.print(p.x+" "+p.y);
        }else
        {
            System.out.print(p.x);
        }
        while(p.pre!=null && p.pre.y!=-1)
        {
            p=p.pre;
            System.out.print(" "+p.y);
        }
        System.out.println();
    }
}