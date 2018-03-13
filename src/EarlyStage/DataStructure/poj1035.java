package EarlyStage.DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class poj1035 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String[] dic= new String[10001];
        int[] index=new int[10000];

        int i=0;
        int size=0;
        while(true){
            dic[i]= "";
            if((dic[i]=sc.next()).equals("#")){
                size=i;
                i=0;
                while(true){
                    String temp=null;
                    int po=0;
                    int flag=0;
                    boolean bool=true;
                    Arrays.fill(index, -1);
                    if((temp=sc.next()).equals("#"))
                        break;
                    for(int j=0;j<size;j++){
                        // stra.length == strb.length -/+ 1
                        // 这里的处理很巧妙
                        if(temp.length()>dic[j].length()){
                            flag=comp(temp,dic[j]);
                        }else{
                            flag=comp(dic[j],temp);
                        }
                        if(flag==2)continue;
                        if(flag==1){
                            index[po++]=j;
                            continue;
                        }
                        if(flag==3){
                            bool=false;
                            System.out.println(temp+" is correct");
                            Arrays.fill(index, -1);
                        }
                    }
                    if(bool){
                        System.out.print(temp+":");
                        for(int j=0;j<10000;j++){
                            if(index[j]==-1)break;
                            else System.out.print(" "+dic[index[j]]);
                        }
                        System.out.println();
                    }
                    i++;
                }
                break;
            }
            i++;
        }
    }

    // str1.length >= str2.length
    public static int comp(String str1,String str2){
        int ab=Math.abs(str1.length()-str2.length());
        int len=str2.length();
        if(ab>=2)
            return 2;
        else if(ab==1){
            for(int k=0;k<len;k++){
                if(str1.charAt(k)!=str2.charAt(k)){
                    if(str1.substring(k+1).endsWith(str2.substring(k)))
                        return 1;
                    else return 2;
                }
                if(k==len-1)return 1;
            }
        }else{
            if(str1.equals(str2))return 3;
            for(int k=0;k<len;k++){
                if(str1.charAt(k)!=str2.charAt(k)){
                    if(str1.substring(k+1).endsWith(str2.substring(k+1)))
                        return 1;
                    else return 2;
                }
                if(k==len-1)return 1;
            }
        }
        return 2;
    }
}
