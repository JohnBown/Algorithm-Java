package EarlyStage.SimpleSearch;

import java.util.*;

public class poj3414 {

    static class State {
        int a;
        int b;
        String str;
        State(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    static int A,B,C;
    static Queue<State> queue = new LinkedList<State>();
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        String ans = BFS();

        if (ans != null){
            String ss = ans.trim();
            String s[] = ss.split("\n");
            System.out.println(s.length);
            System.out.println(ss);
        }else {
            System.out.println("impossible");
        }
    }

    static String BFS(){
        State start = new State(0,0);
        start.str = "";
        queue.add(start);
        list.add(""+0+0);

        while (!queue.isEmpty()){
            State next = queue.poll();

            State a1 = new State(A,next.b);
            a1.str = next.str+"\n"+"FILL(1)";
            if (a1.a==C||a1.b==C){
                return a1.str;
            }
            if (!list.contains(""+a1.a+a1.b)){
                queue.add(a1);
                list.add(""+a1.a+a1.b);
            }

            State a2 = new State(next.a,B);
            a2.str = next.str+"\n"+"FILL(2)";
            if (a2.a==C||a2.b==C){
                return a2.str;
            }
            if (!list.contains(""+a2.a+a2.b)){
                queue.add(a2);
                list.add(""+a2.a+a2.b);
            }

            State a3=new State(0,next.b);
            a3.str=next.str+'\n'+"DROP(1)";
            if(a3.a == C || a3.b == C){
                return a3.str;
            }
            if(!list.contains(""+a3.a+a3.b)){
                queue.add(a3);
                list.add(""+a3.a+a3.b);
            }

            State a4=new State(next.a,0);
            a4.str=next.str+'\n'+"DROP(2)";

            if(a4.a == C || a4.b == C){
                return a4.str;
            }
            if(!list.contains(""+a4.a+a4.b)){
                queue.add(a4);
                list.add(""+a4.a+a4.b);
            }

            State a5;
            if(next.b >= 0 && next.a != A){
                if(next.b >= A - next.a){
                    a5=new State(A,next.b-(A-next.a));
                }else{
                    a5=new State(next.a+next.b,0);
                }
                a5.str=next.str+'\n'+"POUR(2,1)";
                if(a5.a == C || a5.b == C){
                    return a5.str;
                }
                if(!list.contains(""+a5.a+a5.b)){
                    queue.add(a5);
                    list.add(""+a5.a+a5.b);
                }
            }

            State a6;
            if(next.a >= 0 && next.b != B){
                if(next.a >= B - next.b){
                    a6=new State(next.a -(B - next.b),B);
                }else{
                    a6=new State(0,next.a+next.b);
                }
                a6.str=next.str+'\n'+"POUR(1,2)";
                if(a6.a == C || a6.b == C){
                    return a6.str;
                }

                if(!list.contains(""+a6.a+a6.b)){
                    queue.add(a6);
                    list.add(""+a6.a+a6.b);
                }
            }
        }
        return null;
    }
}
