package EarlyStage.DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class poj3349 {
    // TODO TLE
    static class Node{
        int [] num = new int[6];
        Node next;
        Node(){
            Arrays.fill(num,-1);
            next = null;
        }

        Node(int[] num){
            this.num = num.clone();
             next = null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] edges = new int[6];
        boolean isFound = false;
        Node[] nodes = new Node[100001];

        for(int i = 0,len=nodes.length;i<len;++i){
            nodes[i] = new Node();
        }

        int sum;
        for(int i=0;i<n;i++){
            sum = 0;
            for(int j=0;j<6;j++){
                edges[j] = sc.nextInt();
                sum +=edges[j];
            }

            if(!isFound){
                Arrays.sort(edges);
                Node pNode = nodes[sum%100000];
                while(pNode.next != null && !isFound){
                    pNode = pNode.next;
                    for(int j=0;j<6;j++){
                        if(pNode.num[j]!=edges[j]){
                            break;
                        }else if(j==5){
                            isFound = true;
                        }
                    }
                }
                pNode.next = new Node(edges);
            }
        }
        if(isFound){
            System.out.println("Twin snowflakes found.");
        }
        else{
            System.out.println("No two snowflakes are alike.");
        }
    }

}
