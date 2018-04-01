package EarlyStage.BasicAlgs;

import java.util.Scanner;

// 像这样的模拟题，内存开销总是很大，根据题意
// 设计类并模拟操作虽然直观，代码也易于理解
// 但若程序员水平不够，设计出的代码就不够OOP
// 效率差则是必然，同时随着代码复用率增高，这种
// 设计上的弊端则日益显著

enum Direction{
    N,S,W,E
}

class Robot{
    int id;
    int x;
    int y;
    private Direction direction;

    Robot(int i, int x, int y, String direction){
        this.id = i;
        this.x = x;
        this.y = y;
        if(direction.equalsIgnoreCase("N"))
            this.direction = Direction.N;
        else if(direction.equalsIgnoreCase("S"))
            this.direction = Direction.S;
        else if(direction.equalsIgnoreCase("W"))
            this.direction = Direction.W;
        else if(direction.equalsIgnoreCase("E"))
            this.direction = Direction.E;
    }

    public void move(String command){
        if(command.equalsIgnoreCase("F")){
            switch (this.direction){
                case N:
                    this.y++;
                    break;
                case S:
                    this.y--;
                    break;
                case W:
                    this.x--;
                    break;
                case E:
                    this.x++;
                    break;
            }
        }else {
            this.rotate(command);
        }
    }

    private void rotate(String s){
        if(s.equalsIgnoreCase("L")){
            switch (this.direction){
                case N:
                    this.direction = Direction.W;
                    break;
                case S:
                    this.direction = Direction.E;
                    break;
                case W:
                    this.direction = Direction.S;
                    break;
                case E:
                    this.direction = Direction.N;
                    break;
            }
        }else {
            switch (this.direction){
                case N:
                    this.direction = Direction.E;
                    break;
                case S:
                    this.direction = Direction.W;
                    break;
                case W:
                    this.direction = Direction.N;
                    break;
                case E:
                    this.direction = Direction.S;
                    break;
            }
        }
    }
}

public class poj2632 {

    private static String collision(Robot[] robots, Robot r, int x_dim, int y_dim){
        int num = robots.length;
        if(r.x<=0||r.x>x_dim||r.y<=0||r.y>y_dim){
            return "Robot " + r.id + " crashes into the wall";
        }
        for (Robot robot : robots) {
            if (r.x == robot.x && r.y == robot.y && r.id != robot.id) {
                return "Robot " + r.id + " crashes into " + "robot "
                        + robot.id;
            }
        }
        return "OK";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for (int i=0;i<rounds;i++){
            int x_dimension = sc.nextInt();
            int y_dimension = sc.nextInt();
            int num_robots = sc.nextInt();
            int num_ins = sc.nextInt();
            String response = "OK",temp;
            Robot[] robots = new Robot[num_robots];

            for (int j=1;j<=num_robots;j++){
                robots[j-1] = new Robot(j,sc.nextInt(),sc.nextInt(),sc.next());
            }

            for (int k=0;k<num_ins;k++){
                int r_id = sc.nextInt();
                String command = sc.next();
                int num_iteration = sc.nextInt();
                Robot robot = robots[r_id-1] ;
                for(int m=0;m<num_iteration;m++){
                    robot.move(command);
                    temp = collision(robots,robot,x_dimension,y_dimension);
                    if(response.startsWith("O")&&!temp.startsWith("O"))
                        response = temp;
                }
            }
            System.out.println(response);
        }
    }
}
