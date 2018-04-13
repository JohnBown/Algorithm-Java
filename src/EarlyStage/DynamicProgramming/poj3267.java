package EarlyStage.DynamicProgramming;

import java.util.Scanner;

public class poj3267 {
    /*
    @see: https://blog.csdn.net/kindlucy/article/details/5727672
    考虑 b r o w n d c o d w
      -> 1 2 3 4 5 6 7 8 9 10
       当i=6 dp[i] = dp[i-1]+1
       当i=7 dp[i] = dp[i-1]+1
       ...
       当i=10 dp[i] = dp[i-1] - (word.length - 1)
       但是这种情况会发生问题，就是如果i不在单词末尾
       方程就不成立了
       所以重新来当i=7,判断s[i]是不是字典中单词的前缀
       比较判断，把信息存下来，修正dp方程
     */

    static String[] word;//字典
    static char[] str;//用于判断字符串
    static int[] len;//len[i]第i个单词长度
    static int[] dp;
    static int m;//字符串长度
    static int n;//字典中单词的个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp= new int[m+1];
        word = new String[n];
        len = new int[n];
        String s = sc.next();
        str = s.toCharArray();
        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
            len[i] = word[i].length();
        }

        dp();
        System.out.println(dp[0]);
    }

    static void dp(){
        dp[m] = 0;//dp[i]:表示从第i位到末位需要删除的字符个数
        for (int i = m-1; i >= 0; i--) {
            dp[i] = dp[i+1]+1;
            for (int j = 0; j < n; j++)//循环字典，逐个单词比较
                //若str[i]和word的第一个字符不一样，则str[i]肯定是要删除的
                if((m-i)>=len[j]&&str[i]==word[j].charAt(0)){
                    int wid = 1;//记录单词匹配字母数
                    for(int k=i+1;k<m;k++)//移动指针至m
                        if(str[k]==word[j].charAt(wid)){//比对字母是否匹配
                            wid++;
                            if(wid==len[j]){//如果存在单词，更新dp方程
                                //这里不用担心，因为当首字母匹配的情况下，dp值永远
                                // 是较小的，不会被外层循环覆盖
                                dp[i]=Math.min(dp[i],dp[k+1]+k-i+1-len[j]);
                                break;
                            }
                        }
                }
        }
    }
}
