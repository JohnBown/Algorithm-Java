package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String t = sc.next();

            int i = 0;
            int j = -1;
//            boolean flag = false;

            if(s.length()==1){
                System.out.println(t.contains(s)?"Yes":"No");
            }
            else{
                for(;i<s.length()&&j<t.length();i++){
                    while(++j<t.length()&&t.charAt(j)!=s.charAt(i));
                }
                System.out.println(i==s.length()&&j!=t.length()?"Yes":"No");
            }
        }
    }
}
