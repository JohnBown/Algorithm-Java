package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj1850 {

    static int c[][] = new int[27][27]; // 计算组合数很容易越界
    public static void Init(){
        // Pascal’s triangle
        for(int i=0;i<c.length;i++){
            c[i][0] = c[i][i] = 1;
            for(int j=1;j<i;j++){
                c[i][j] = c[i-1][j]+c[i-1][j-1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] code = sc.nextLine().toCharArray();
        for(int i=0;i<code.length-1;i++){
            if(code[i]>=code[i+1]){
                System.out.println(0);
                return;
            }
        }

        Init();
        int sum = 0;
        // 计算长度比code.len()小的字符串个数
        for(int i=1;i<code.length;i++) {
//            System.out.println("c[26]["+i+"] = "+c[26][i]);
            sum += c[26][i]; // 26抽i的组合数
        }
        // 计算等于code.len()但值比code小的字符串个数
        char last = 'a';
        for(int i=0; i<code.length; i++){   // i为code的指针，对每个位置枚举
            for(char j=last;j<code[i];j++){ // 根据升序规则，当前位置值比str小的数
                // 这段最好举例，列出n=str.len时，满足条件的所有组合，观察规律
                // C[n][m] = Sum_{i=1}^{n-1}C[i][m-1]
                sum += c['z'-j][code.length-i-1];
            }
            last= (char) (code[i]+1);
        }
        System.out.println(sum+1);
    }
}
