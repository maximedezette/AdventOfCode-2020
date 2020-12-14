package adventOfCode.day12;

import java.util.ArrayList;
import java.util.List;

public class NavigationComputer {
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String FORWARD = "F";
    public static final String ROTATE_RIGHT = "R";
    public static final String ROTATE_LEFT = "L";
    List<Action> actionList;
    String currentType = EAST;
    int northSouthPosition;
    int eastWestPosition;

    public NavigationComputer(List<String> inputs) {

        actionList = generateActionList(inputs);
    }

    private List<Action> generateActionList(List<String> inputs) {
        List<Action> actionList = new ArrayList<>();
        for(String inputLine: inputs){
            String type = String.valueOf(inputLine.charAt(0));
            int value = Integer.parseInt(inputLine.substring(1));
            Action action = new Action(type,value);
            actionList.add(action);
        }

        return actionList;
    }

    public String getCurrentType() {
        return currentType;
    }

    public int getNorthSouthPosition() {
        return northSouthPosition;
    }

    public void setNorthSouthPosition(int northSouthPosition) {
        this.northSouthPosition = northSouthPosition;
    }

    public int getEastWestPosition() {
        return eastWestPosition;
    }

    public void setEastWestPosition(int eastWestPosition) {
        this.eastWestPosition = eastWestPosition;
    }

    public void process(Action action) {

        int numberOfTurnRequired= 0;
        switch (action.getType()) {
            case NORTH:
                northSouthPosition += action.getValue();
                break;
            case SOUTH:
                northSouthPosition -= action.getValue();
                break;
            case EAST:
                eastWestPosition += action.getValue();
                break;
            case WEST:
                eastWestPosition -= action.getValue();
                break;
            case FORWARD:
                Action substituteAction = new Action(currentType, action.getValue());
                process(substituteAction);
                break;
            case ROTATE_RIGHT:
                numberOfTurnRequired = action.getValue() / 90;
                for (int i = 0; i < numberOfTurnRequired; i++) {
                    turnBoatFromNinetyDegrees();
                }
                break;
            case ROTATE_LEFT:
                numberOfTurnRequired = ( 360 - action.getValue() )/ 90 ;
                for (int i = 0; i < numberOfTurnRequired; i++) {
                    turnBoatFromNinetyDegrees();
                }
                break;
        }
    }

    private void turnBoatFromNinetyDegrees() {
        if (currentType.equals(EAST)) {
            currentType = SOUTH;
        } else if (currentType.equals(SOUTH)) {
            currentType = WEST;
        } else if (currentType.equals(WEST)) {
            currentType = NORTH;
        } else if (currentType.equals(NORTH)) {
            currentType = EAST;
        }
    }

    public int getManhattanDistance() {
        for (Action action : actionList) {
            process(action);
        }
        return Math.abs(eastWestPosition) + Math.abs(northSouthPosition) ;
    }
}
