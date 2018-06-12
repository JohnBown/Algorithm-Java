package EarlyStage.GraphAlgs;

import java.util.Scanner;

public class poj2253 {

    static int n;
    static int cases;
    static int[][] stone;
    static double[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){
            cases++;
            n = sc.nextInt();
            if (n==0){
                return;
            }
            stone = new int[n][2];
            map = new double[n][n];

            for (int i = 0; i < n; i++) {
                stone[i][0] = sc.nextInt();
                stone[i][1] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.sqrt((stone[i][0] - stone[j][0])
                    * (stone[i][0] - stone[j][0])
                    + (stone[i][1] - stone[j][1])
                    * (stone[i][1] - stone[j][1]));
                }
            }

            solve();
        }

    }

    private static void solve() {

        System.out.println("Scenario #" + cases);
        System.out.printf("Frog Distance = %.3f\n\n", floyd());
    }

    private static double floyd() {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j]>(map[i][k]>map[k][j]?map[i][k]:map[k][j])
                            && map[i][k]!=0
                            && map[k][j]!=0){
                        map[i][j] = (map[i][k] > map[k][j] ? map[i][k] : map[k][j]);
                    }
                }
            }
        }
        return map[0][1];
    }
}
