package EarlyStage.BasicAlgs;

import java.util.Scanner;

/**
 * TODO: TLE，我将状态进行位字节压缩，但还是AC不了
 */

public class poj2965 {

    // 根据规则switch同行列把手
    static int ChangeHandles(int refrig, int n){
        refrig ^= (1<<n);
        for(int i=0;i<4;i++){
            refrig ^= (1<< (n/4*4+i));
            refrig ^= (1<< (i*4+n%4));
        }
        return refrig;
    }

    public static void main(String[] args){

        // 读取棋盘
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        for(int i=0;i<4;i++){
            s.append(sc.nextLine());
        }

        // 将输入字符压缩二进制
        int refrigerator=0;
        for(int i=0;i<s.length();i++){
            refrigerator = refrigerator << 1;
            if(s.charAt(i)=='-'){
                refrigerator += 1;
            }
        }

        // 枚举
        int nbit = 1<<16;
        int num = 16;
        int[] numArr = new int[16];

        for(int i=0;i<nbit;i++){
            int count = 0;
            int refrigTemp = refrigerator;
            int[] numArrTemp = new int[16];

            for(int j=0;j<16;j++){
                if(count>num) break;
                int tmp = 1<<j;
                if((tmp&i)!=0){
                    refrigTemp = ChangeHandles(refrigTemp,j);
                    numArrTemp[count] = j;
                    count++;
                }
            }

            // 判断开关全开
            if(refrigTemp==0xffff){
                num = count;
                System.arraycopy(numArrTemp, 0, numArr, 0, num);
            }
        }

        System.out.println(num);
        for(int i=0;i<num;i++){
            System.out.println((4-numArr[i]/4) +" "+(4-numArr[i]%4));
        }
    }
}
