package EarlyStage.DynamicProgramming;
import java.io.*;
import java.util.*;
/**
 * @see <a herf="http://blog.csdn.net/deng_hui_long/article/details/10803617"/>
 * todo 今天抽了两个小时看这个多重背包，有点没太看懂
 * todo 标记一下，等做到贪心算法的完全背包部分在回头整
 * todo 理：）先commit
 */
public class poj1276 {
    int Case,n;
    int dp[]=new int[1000000];
    public static void main(String[] args) {
        new poj1276().work();
    }
    void work(){
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        while(sc.hasNext()){
            Case=sc.nextInt();
            n=sc.nextInt();
            if(n==0&&Case==0)
                break;
            Node node[]=new Node[n];
            Arrays.fill(dp,0);
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                node[i]=new Node(a,b);
            }
            for(int i=0;i<n;i++){
                multiplePack(node[i].val,node[i].val,node[i].cost);
            }
            System.out.println(dp[Case]);
        }
    }
    //多重背包
    void multiplePack(int cost,int weight,int amount){
        if(cost*amount>=Case)//超过最大的钱数，按完全背包处理
            completePack(cost,weight);
        else{//小于最大的钱数，按01背包处理
            int k=1;
            while(k<amount){
                zeroOnePack(k*cost,k*weight);
                amount-=k;
                k<<=1;//左移一位，表示乘以2
            }
            zeroOnePack(amount*cost,amount*weight);
        }
    }
    //完全背包
    void completePack(int cost,int weight){
        for(int i=cost;i<=Case;i++){
            dp[i]=Math.max(dp[i],dp[i-cost]+weight);
        }
    }
    //01背包
    void zeroOnePack(int cost,int weight){
        for(int i=Case;i>=cost;i--)
            dp[i]=Math.max(dp[i],dp[i-cost]+weight);
    }
    class Node{
        int cost;
        int val;
        Node(int cost,int val){
            this.cost=cost;
            this.val=val;
        }
    }
}
