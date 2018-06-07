package EarlyStage.SimpleSearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class poj3087 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=1;i<=t;i++){

            n = sc.nextInt();
            sc.nextLine();

            char[] ss1 = sc.nextLine().toCharArray();
            char[] ss2 = sc.nextLine().toCharArray();
            String s = sc.nextLine();
            Map<String,Boolean> map = new HashMap<String,Boolean>();
            map.put(s,true);
            int step = 0;
            while (true){
                char[] a = new char[201];
                int ps = 0;
                for (int j = 0; j < n; j++) {
                    a[ps++] = ss2[j];
                    a[ps++] = ss1[j];
                }
                step++;

                String ss="";
                for (int j = 0; j < ps; j++) {//洗牌后字符串
                    ss+=a[j];
                }
                if (ss.equals(s)){//存在输出
                    System.out.println(i+" "+step);
                    break;
                } else if (map.containsKey(ss)){
                    if (map.get(ss)&&!ss.equals(s)){//如果map存在ss且ss！=s，则无解
                        System.out.println(i+" "+"-1");
                        break;
                    }
                }

                map.put(ss,true);
                for (int j = 0; j < n; j++) {
                    ss1[j] = a[j];
                }
                for (int k=0,j=n;j < 2*n; k++,j++) {
                    ss2[k] = a[j];
                }
            }
        }
    }
}
