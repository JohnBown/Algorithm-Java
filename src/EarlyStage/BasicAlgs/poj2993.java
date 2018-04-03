package EarlyStage.BasicAlgs;

import java.util.Scanner;

public class poj2993 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[8][8];
        String s1 = sc.nextLine();
        s1 = s1.substring(7);
        String[] ws = s1.split(",");

        for (String w : ws) {
            if (w.length() == 3) {
                int x = 8 - w.charAt(2) + '0';
                int y = w.charAt(1) - 'a';
                arr[x][y] = w.charAt(0);
            } else if (w.length() == 2) {
                int x = 8 - w.charAt(1) + '0';
                int y = w.charAt(0) - 'a';
                arr[x][y] = 'P';
            }
        }

        String s2 = sc.nextLine();
        s2 = s2.substring(7);
        String[] bs = s2.split(",");
        for (String b : bs) {
            if (b.length() == 3) {
                int x = 8 - b.charAt(2) + '0';
                int y = b.charAt(1) - 'a';
                arr[x][y] = (char) (b.charAt(0) + 32);
            } else if (b.length() == 2) {
                int x = 8 - b.charAt(1) + '0';
                int y = b.charAt(0) - 'a';
                arr[x][y] = 'p';
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("+---+---+---+---+---+---+---+---+");
            for (int j = 0; j < 8; j++) {
                if(arr[i][j]==0){
                    if((i+j)%2==0) System.out.print("|...");
                    else System.out.print("|:::");
                }else {
                    if((i+j)%2==0) System.out.print("|."+arr[i][j]+".");
                    else System.out.print("|:"+arr[i][j]+":");
                }
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+---+---+---+---+---+");
    }
}
