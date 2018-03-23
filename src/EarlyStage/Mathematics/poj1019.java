package EarlyStage.Mathematics;

import java.util.Scanner;

public class poj1019 {
    static long a[] = new long[31270];
    static long s[] = new long[31270];

    static void reset(){
        a[1] = 1;
        s[1] = 1;
        for(int i=2;i<31270;i++){
            // 每组数字都比上一组长 (int)Math.log10((double)i)+1
            // 这个公式不好理解，这也许就是数学的魅力吧
            //TODO 其实我没看懂：（
            a[i] = a[i-1]+(int)Math.log10((double)i)+1;
            s[i] = s[i-1]+a[i];
        }
    }

    static int work(int n){
        int i=1;
        int length = 0;
        while(s[i]<n) i++;
        long pos = n - s[i-1];
        for(i=1;length<pos;i++){
            length += (int)Math.log10((double)i)+1;
        }
        return ((i-1)/(int)Math.pow((double)10,length-pos))%10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reset();
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            System.out.println(work(n));
        }
    }
}
