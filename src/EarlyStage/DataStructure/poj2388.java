package EarlyStage.DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class poj2388 {
    // 之前听过@Simons大神讲这道题，可以优化
    // 因为求中位数，不是出在左边，就是出在右边
    // 所以可以之间剪枝一半，只递归另一半。
    // 因为可以直接AC，就懒得改了。
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        System.out.println(a[n/2]);
    }
}
