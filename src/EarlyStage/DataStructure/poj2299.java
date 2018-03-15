package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj2299 {
    static long count;
    static void merge_sort_recursive(long[] arr, long[] result, int start, int end){
        if(start>=end)
            return;
        int len = end-start, mid = (len>>1)+start;
        int start1 = start, end1 = mid;
        int start2 = mid+1, end2 = end;
        merge_sort_recursive(arr,result,start1,end1);
        merge_sort_recursive(arr,result,start2,end2);

        int k = start;
        while(start1<=end1 && start2<=end2){
            if(arr[start1]<=arr[start2]){
                result[k++] = arr[start1++];
            }
            else {
                count += end1 - start1 +1;
                result[k++] = arr[start2++];
            }

            // wiki给的这个式子挺简练的
//            result[k++] = arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
        }
        while(start1<=end1)
            result[k++] = arr[start1++];
        while(start2<=end2)
            result[k++] = arr[start2++];

        // 这个for循环不能去掉
        // 保留这个for循环排序才能收敛
        for(k=start;k<=end;k++)
            arr[k] = result[k];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            count = 0;
            if(n!=0){
                long[] a= new long[n];
                long[] atemp = new long[n];
                for(int i=0;i<n;i++){
                    a[i] = sc.nextLong();
                }
                merge_sort_recursive(a,atemp,0,a.length-1);

            }
            else{
                break;
            }
            System.out.println(count);
        }
    }
}
