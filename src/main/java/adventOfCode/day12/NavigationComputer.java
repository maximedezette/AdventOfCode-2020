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
    private List<Action> actionList;
    private int northSouthPosition;
    private int eastWestPosition;
    private WayPoint wayPoint;


    public NavigationComputer(List<String> inputs) {

        actionList = generateActionList(inputs);
        wayPoint = new WayPoint();
    }


    private List<Action> generateActionList(List<String> inputs) {
        List<Action> actionList = new ArrayList<>();
        for (String inputLine : inputs) {
            String type = String.valueOf(inputLine.charAt(0));
            int value = Integer.parseInt(inputLine.substring(1));
            Action action = new Action(type, value);
            actionList.add(action);
        }

        return actionList;
    }

    public int getNorthSouthPosition() {
        return northSouthPosition;
    }

    public int getEastWestPosition() {
        return eastWestPosition;
    }

    public void process(Action action) {

        int numberOfTurnRequired = 0;
        switch (action.getType()) {
            case NORTH:
                wayPoint.addToNorthSouthPosition(action.getValue());
                break;
            case SOUTH:
                wayPoint.addToNorthSouthPosition(-action.getValue());
                break;
            case EAST:
                wayPoint.addToEastWestPosition(action.getValue());
                break;
            case WEST:
                wayPoint.addToEastWestPosition(-action.getValue());
                break;
            case FORWARD:
                eastWestPosition += wayPoint.getEastWestPosition() * action.getValue();
                northSouthPosition += wayPoint.getNorthSouthPosition() * action.getValue();
                break;
            case ROTATE_RIGHT:
                numberOfTurnRequired = action.getValue() / 90;
                wayPoint.turn(numberOfTurnRequired);
                break;
            case ROTATE_LEFT:
                numberOfTurnRequired = (360 - action.getValue()) / 90;
                wayPoint.turn(numberOfTurnRequired);
                break;
        }
    }



    public WayPoint getWayPoint() {
        return wayPoint;
    }


    public int getManhattanDistance() {
        for (Action action : actionList) {
            process(action);
        }
        return Math.abs(eastWestPosition) + Math.abs(northSouthPosition);
    }
}
