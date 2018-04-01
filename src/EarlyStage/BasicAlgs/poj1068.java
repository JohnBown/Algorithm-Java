package EarlyStage.BasicAlgs;

import java.util.Scanner;
import java.util.Stack;

public class poj1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            int leftpa = 0;
            int m = sc.nextInt();
            for (int j=0;j<m;j++){
                int p = sc.nextInt();
                for(int k=0;k<p-leftpa;k++)
                    str.append("(");
                str.append(")");
                leftpa = p;
            }
            // 栈顶存储当前成对括号的输出量
            Stack<Integer> s = new Stack<Integer>();
            for (int j=0;j<str.length();j++){
                if(str.charAt(j)=='(')
                    s.push(1);
                else {
                    int p = s.pop();
                    System.out.print(p+" ");
                    if(!s.empty()) s.push(s.pop()+p);
                }
            }
            System.out.println();
        }
    }
}
