package EarlyStage.DataStructure;

import java.util.Hashtable;
import java.util.Scanner;

public class poj2503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<String,String> table = new Hashtable<String,String>();
        String input;
        String[] array = new String[2];
        while(sc.hasNext()){
            input = sc.nextLine();
            if(input.length() == 0) break;
            array = input.split(" ");
            table.put(array[1],array[0]);
        }
        while(sc.hasNext()){
            input = sc.nextLine();
            if(table.get(input)!=null) System.out.println(table.get(input));
            else System.out.println("eh");
        }
    }
}
