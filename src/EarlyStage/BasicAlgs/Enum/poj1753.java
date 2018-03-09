package EarlyStage.BasicAlgs.Enum;

import java.util.*;

public class poj1753 {

    // 单棋子flip操作
    static char FlipPiece(char piece){
        return piece=='w'?'b':'w';
    }

    // 根据规则对周围棋子flip
    static void ChangeColor(char[] arr, int i){
        arr[i] = FlipPiece(arr[i]);
        int x=i/4;
        int y=i%4;
        if(y<3)
            arr[i+1] = FlipPiece(arr[i+1]);
        if(y>0)
            arr[i-1] = FlipPiece(arr[i-1]);
        if(x>0)
            arr[i-4] = FlipPiece(arr[i-4]);
        if(x<3)
            arr[i+4] = FlipPiece(arr[i+4]);
    }

    // 判断是否全黑或全白
    static boolean allWorB(char[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] !=arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){

        // 读取棋盘
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        for(int i=0;i<4;i++){
            s.append(sc.nextLine());
        }
        char[] array = s.toString().toCharArray();

        // 初始化枚举参数
        // 思想就是利用自然数1~2^16二进制枚举特性
        int n = array.length;
        int nbit = 1<<n;
        int num=16;

        // 枚举检查
        for(int i=0;i<nbit;i++){
            int count = 0;
            char[] arrTemp = array.clone();

            for(int j=0;j<n;j++){
                int tmp = 1<<j;
                if((tmp&i)!=0){
                    ChangeColor(arrTemp,j);
                    count++;
                }
            }

            if(allWorB(arrTemp)){
                if(count<=num){
                    num = count;
                }
            }
        }

        if(num==16) {
            System.out.println("Impossible");
        }
        else{
            System.out.println(num);
        }
    }
}
