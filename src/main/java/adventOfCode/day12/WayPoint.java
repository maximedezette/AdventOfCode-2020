package adventOfCode.day12;

import static adventOfCode.day12.NavigationComputer.*;

public class WayPoint {

    private int northSouthPosition = 1;
    private int eastWestPosition = 10;

    public int getNorthSouthPosition() {
        return northSouthPosition;
    }


    public int getEastWestPosition() {
        return eastWestPosition;
    }

    public void addToNorthSouthPosition(int value) {
        this.northSouthPosition += value;
    }

    public void addToEastWestPosition(int value) {
        this.eastWestPosition += value;
    }

    public void turnBoatFromNinetyDegrees() {
        int tmpNorthPosition = northSouthPosition;
        northSouthPosition = -eastWestPosition;
        eastWestPosition = tmpNorthPosition;
    }

    public void turn(int numberOfTurnRequired) {
        for (int i = 0; i < numberOfTurnRequired; i++) {
            turnBoatFromNinetyDegrees();
        }
    }
}
