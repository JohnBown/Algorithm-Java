package EarlyStage.DataStructure;

import java.util.Scanner;

public class poj3080 {

    static boolean ok(String t, int n, String s[]){
        for(int i=1;i<n;i++){
            if(!s[i].contains(t)){  // string contains the specified sequence of char values.
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String[] s = new String[23];

            s[0] = sc.nextLine();
            for(int i=0;i<n;i++){
                s[i] = sc.nextLine();
            }

            String ans="";
            for(int i=0;i<s[0].length();i++){
                for(int j=i;j<s[0].length();j++){
                    String te = s[0].substring(i,j+1);
                    if(ok(te,n,s)){
                        // 存储较长substring
                        if(ans.length()<te.length()){
                            ans=te;
                        }
                        // 存储字典序较前的substring
                        if(ans.length()==te.length()&&ans.compareTo(te)>0){
                            ans=te;
                        }
                    }
                }
            }
            if(ans.length()>=3) System.out.println(ans);
            else System.out.println("no significant commonalities");
        }
        sc.close();
    }
}
