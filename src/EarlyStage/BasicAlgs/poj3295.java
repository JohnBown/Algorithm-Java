package EarlyStage.BasicAlgs;

import java.util.Scanner;

public class poj3295 {

    static char[] ss = new char[250];
    static int sig;
    static int i;

    static int fun(){
        char c = ss[sig++];
        int k;
        if('p'<=c && c<='t'){
            // 此处移位用于取p~t每个真假值的返回值
            if((i&(1<<(c-'p')))!=0) k=1;
            else k=0;
            return k;
        }
        // 真值表，看过好多解法，都是用if打表
        // 但这里用了递归，真牛逼！
        switch (c){
            case 'K':
                return fun()&fun();
            case 'A':
                return fun()|fun();
            case 'N':
                return fun()==0?1:0;
            case 'C':
                return (fun()==0?1:0)|fun();
            case 'E':
                return (fun()^fun())==0?1:0;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext("0")){
            String str = sc.nextLine();
            ss = str.toCharArray();
            boolean pp = true;
            for(i=0;i<(1<<5);i++){  // i枚举全组合，用于遍历判断
                sig =0;
                if(fun()==0){
                    pp=false;
                    break;
                }
            }
            if(pp) System.out.println("tautology");
            else System.out.println("not");
        }
    }
}
