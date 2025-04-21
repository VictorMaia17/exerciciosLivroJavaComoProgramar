public class Turtle {

    private int positionX;
    private int positionY;
    private PositionPen positionPen;
    private DirectionTurtle directionTurtle;
    private int[][] floor;

    Turtle(int positionX, int positionY, PositionPen positionPen, DirectionTurtle directionTurtle, int[][] floor) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.positionPen = positionPen;
        this.directionTurtle = directionTurtle;
        this.floor = floor;

    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public PositionPen getPositionPen() {
        return positionPen;
    }

    public void upPen(){

        if(positionPen == PositionPen.DOWN){
            positionPen = PositionPen.UP;
        }
        else{
            System.out.println("The turtle already has its pen up");
        }

    }

    public void downPen(){

        if(positionPen == PositionPen.UP){
            positionPen = PositionPen.DOWN;
        }
        else{
            System.out.println("The turtle already has its pen down");
        }

    }

    public void turtleTurnTop(){

        if(directionTurtle != DirectionTurtle.TOP){
            directionTurtle = DirectionTurtle.TOP;
        }
        else{
            System.out.println("The turtle already is turned to top");
        }

    }

    public void turtleTurnRight(){

        if(directionTurtle != DirectionTurtle.RIGHT){
            directionTurtle = DirectionTurtle.RIGHT;
        }
        else{
            System.out.println("The turtle already is turned to right");
        }

    }

    public void turtleTurnBottom(){

        if(directionTurtle != DirectionTurtle.BOTTOM){
            directionTurtle = DirectionTurtle.BOTTOM;
        }
        else{
            System.out.println("The turtle already is turned to bottom");
        }

    }

    public void turtleTurnLeft(){

        if(directionTurtle != DirectionTurtle.LEFT){
            directionTurtle = DirectionTurtle.LEFT;
        }
        else{
            System.out.println("The turtle already is turned to left");
        }

    }

    public void turtleWalk(int distance){

        switch (directionTurtle){

            case TOP:
                if(positionY - distance < 0){
                    System.out.println("Map limit achieved");
                }
                else{
                    for(int i = 1; i < distance; i++){

                        paintFloor(floor, positionX, positionY, positionPen);
                        positionY--;

                    }
                }
                break;

            case RIGHT:
                if(positionX + distance > 19){
                    System.out.println("Map limit achieved");
                }
                else{
                    for(int i = 1; i < distance; i++){

                        paintFloor(floor, positionX, positionY, positionPen);
                        positionX++;

                    }
                }
                break;

            case BOTTOM:
                if(positionY + distance > 19){
                    System.out.println("Map limit achieved");
                }
                else{
                    for(int i = 1; i < distance; i++){

                        paintFloor(floor, positionX, positionY, positionPen);
                        positionY++;

                    }
                }
                break;

            case LEFT:
                if(positionX - distance < 0){
                    System.out.println("Map limit achieved");
                }
                else{
                    for(int i = 1; i < distance; i++){

                        paintFloor(floor, positionX, positionY, positionPen);
                        positionX--;

                    }
                }
                break;
        }

    }

    private static void paintFloor(int[][] floor, int x, int y, PositionPen positionPen) {

        if (positionPen == PositionPen.DOWN) {
            floor[y][x] = 1;
        }

    }

}
