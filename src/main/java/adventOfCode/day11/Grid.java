package adventOfCode.day11;

import java.util.Arrays;
import java.util.List;

import static adventOfCode.day11.Seat.EMPTY;
import static adventOfCode.day11.Seat.OCCUPIED;

public class Grid {

    Seat[][] seats;

    public Grid(List<String> input) {

        seats = new Seat[input.size()][input.get(0).length()];

        int i = 0;
        for (String inputLine : input) {
            for (int j = 0; j < inputLine.length(); j++) {
                Seat currentSeat = new Seat();
                currentSeat.setStatus(inputLine.charAt(j));
                seats[i][j] = currentSeat;
            }
            i++;
        }
    }

    public Grid() {

    }

    public long countOccupiedSeats() {
        return Arrays.stream(seats)
                .flatMap(Arrays::stream)
                .filter(d -> d.getStatus() == OCCUPIED)
                .count();
    }

    public Grid update() {
        Grid updatedGrid = new Grid();
        Seat[][] updatedSeats = new Seat[seats.length][seats[0].length];
        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats[0].length; x++) {
                updatedSeats[y][x] = seats[y][x].update(countOccupiedAdjacentSeat(x,y));
            }
        }
        updatedGrid.setSeats(updatedSeats);
        return updatedGrid;
    }

    public Grid updateWithPartTwoRules() {
        Grid updatedGrid = new Grid();
        Seat[][] updatedSeats = new Seat[seats.length][seats[0].length];
        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats[0].length; x++) {
                updatedSeats[y][x] = seats[y][x].updatePartTwo(countOccupiedSeatsInSight(x,y));
            }
        }
        updatedGrid.setSeats(updatedSeats);
        return updatedGrid;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public int countOccupiedAdjacentSeat(int x, int y) {
        int numberOfOccupiedAjacentSeats = 0;

        for(int i = y-1; i<= y+1; i++){
            for(int j= x-1; j <= x+1; j++){
                if (inBound(j,i)){
                    if(seats[i][j].getStatus()==OCCUPIED && (j != x || i != y)) {
                        numberOfOccupiedAjacentSeats++;
                    }
                }

            }

        }
        return numberOfOccupiedAjacentSeats;
    }

    private boolean inBound(int x, int y) {
        return (x >= 0 && x < seats[0].length) && (y >= 0 && y < seats.length);
    }

    public int countOccupiedSeatsInSight(int x, int y) {
        int numberOfSeatsInSight = 0;

        numberOfSeatsInSight += getNumberOfSeatsInLines(x, y);
        numberOfSeatsInSight += getNumberOfSeatsInDiagonals(x, y);

        return numberOfSeatsInSight;
    }

    private int getNumberOfSeatsInLines(int x, int y) {
        int numberOfSeatsInSight = 0;
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,1,0);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,-1,0);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,0,1);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,0,-1);
        return numberOfSeatsInSight;
    }

    private int getNumberOfSeatsInDiagonals(int x, int y) {
        int numberOfSeatsInSight = 0;
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,1,1);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,-1,1);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,1,-1);
        numberOfSeatsInSight += getOccupiedSeatInDirection(x,y,-1,-1);
        return numberOfSeatsInSight;
    }

    private int getOccupiedSeatInDirection(int xStartingPosition, int yStartingPosition, int xDirection, int yDirection){
        int numberOfOccupiedSeatsInDirection = 0;
        int x= xStartingPosition;
        int y = yStartingPosition;
        boolean found = false;
        x = x+xDirection;
        y = y + yDirection;

        while (inBound(x,y) && found == false){
            if( seats[y][x].getStatus() == OCCUPIED){
                found = true;
                numberOfOccupiedSeatsInDirection = 1;
            }else if(seats[y][x].getStatus() == EMPTY){
                found = true;
            }
            x = x + xDirection;
            y = y + yDirection;
        }

        return numberOfOccupiedSeatsInDirection;
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(seats);
    }

    @Override
    public String toString() {
        String value = "";
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                value += " " + seats[i][j].getStatus();
            }
            value += "\r\n";
        }
        return value;
    }

}
