import java.util.Scanner;
import utils.ValidEntry;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] floor = new int[20][20];

        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j] = 0;
            }
        }

        Turtle turtle = new Turtle(0,0, PositionPen.UP, DirectionTurtle.RIGHT, floor);

        int choice;
        boolean continueProgram = true;
        while(continueProgram) {

            System.out.println("The position of turtle is\nX: " + turtle.getPositionX()
                    + "\nY: " + turtle.getPositionY()
                    + "\nThe position of pen is: " + turtle.getPositionPen() + "\n");

            choice = ValidEntry.verifyResponseLimitedOptions("Type the command:" +
                    "\n1.Pen Up" +
                    "\n2.Pen Down" +
                    "\n3.turn Right" +
                    "\n4.turn Left" +
                    "\n5.turn Top" +
                    "\n6.turn Bottom" +
                    "\n7.walk(after you type the distance)" +
                    "\n8.Display" +
                    "\n9.Exit",
                    1, 2, 3, 4, 5, 6, 7, 8, 9);

            switch(choice){
                case 1:
                    turtle.upPen();
                    break;
                case 2:
                    turtle.downPen();
                    break;
                case 3:
                    turtle.turtleTurnRight();
                    break;
                case 4:
                    turtle.turtleTurnLeft();
                    break;
                case 5:
                    turtle.turtleTurnTop();
                    break;
                case 6:
                    turtle.turtleTurnBottom();
                    break;
                case 7:
                    int distance = ValidEntry.verifyResponseInt("enter the distance to be traveled: ");
                    turtle.turtleWalk(distance);
                    break;

                case 8:
                    displayFloor(floor, turtle);
                    break;
                case 9:
                    continueProgram = false;
                    break;
            }
        }

    }

    public static void displayFloor(int[][] floor, Turtle turtle){

        System.out.println("\n");
        for(int k = 0; k < 21; k++){
            System.out.print("-");
        }

        System.out.print("\n");

        for(int i = 0; i < floor.length; i++){
            System.out.print("|");
            for(int j = 0; j < floor[i].length; j++){
                if(turtle.getPositionY() == i && turtle.getPositionX() == j){
                    System.out.print("T");
                }
                else if(floor[i][j] == 0){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.print("|");
            System.out.print("\n");
        }

        for(int k = 0; k < 21; k++){
            System.out.print("-");
        }

        System.out.print("\n");

    }

}