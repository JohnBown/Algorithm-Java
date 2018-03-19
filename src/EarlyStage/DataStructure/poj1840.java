package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj1840 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();
        int a5 = sc.nextInt();
        System.out.println(hashQuestions(a1, a2, a3, a4, a5));
    }

    private static int hashQuestions(int a1, int a2, int a3, int a4, int a5){
        // 100*100*100*5*5+k=25000010
        // k用来防止OutOfArrayIndexException
        // hash时经常会用到的技巧
        char hash[] = new char[25000010];
        int bigs[] = new int[100];
        int pos = 0;
        int m = 0;
        for(int i=-50;i<=50;i++){
            if(i!=0) bigs[m++]=i*i*i;
        }
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                pos = -(bigs[i]*a1+bigs[j]*a2);
                hash[pos+12500000]++;
            }
        }
        int ans = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                for(int k=0;k<100;k++){
                    pos = bigs[i]*a3+bigs[j]*a4+bigs[k]*a5;
                    if(pos>12500000||pos<-12500000)
                        continue;
                    ans+=hash[pos+12500000];
                }
            }
        }

        return ans;
    }
}
