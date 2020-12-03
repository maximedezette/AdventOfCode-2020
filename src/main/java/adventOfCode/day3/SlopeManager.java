package adventOfCode.day3;

import java.util.List;

public class SlopeManager {

    public static final char TREE = '#';
    private List<String> area;

    public SlopeManager(List<String> area) {
        this.area = area;
    }

    public char getNextPositionContent(Position startingPosition, Slope slope) {

        int rightPositionToCheck = getRightPositionToCheck(startingPosition, slope);

        return area.get(startingPosition.getY() +slope.down).charAt(rightPositionToCheck);
    }

    private int getRightPositionToCheck(Position startingPosition, Slope slope) {
        int rightPositionToCheck = startingPosition.getX() + slope.right;
        if (startingPosition.getX() + slope.right >= getLineLength()) {
            rightPositionToCheck = rightPositionToCheck - getLineLength();
        }
        return rightPositionToCheck;
    }

    private int getLineLength() {
        return area.get(0).length();
    }
    public Position updatePosition(Position startingPosition, Slope slope) {
        Position updatedPosition = new Position(0,0);
        updatedPosition.setY(startingPosition.getY() + slope.getDown());

        int rightPositionToCheck = getRightPositionToCheck(startingPosition, slope);

        updatedPosition.setX(rightPositionToCheck);

        return updatedPosition;
    }
    public int countTree(Slope slope) {
        int numberOfTree = 0;
        Position startingPosition = new Position(0,0);
        for(int i = 0; i < area.size() -1 ; i++){
            if(getNextPositionContent(startingPosition,slope) == TREE){
                numberOfTree++;
            }
            startingPosition = updatePosition(startingPosition,slope);
        }
        return numberOfTree;
    }


}
