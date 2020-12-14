package adventOfCode.day11;

public class Seat {

    public static final char OCCUPIED = '#';
    public static final char EMPTY = 'L';
    public static final char FLOOR = '.';

    private char status;

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Seat update(int adjacentOccupiedSeats) {
        Seat updatedSeat = new Seat();

        updatedSeat.setStatus(this.status);

        if(this.status != FLOOR) {
            if (adjacentOccupiedSeats == 0) {
                updatedSeat.setStatus(OCCUPIED);
            } else if (adjacentOccupiedSeats >= 4) {
                updatedSeat.setStatus(EMPTY);
            }
        }

        return updatedSeat;
    }
    public Seat updatePartTwo(int adjacentOccupiedSeats) {
        Seat updatedSeat = new Seat();

        updatedSeat.setStatus(this.status);

        if(this.status != FLOOR) {
            if (adjacentOccupiedSeats == 0) {
                updatedSeat.setStatus(OCCUPIED);
                // 4 in part 1
            } else if (adjacentOccupiedSeats >= 5) {
                updatedSeat.setStatus(EMPTY);
            }
        }

        return updatedSeat;
    }

    @Override
    public String toString() {
        return  String.valueOf(status);
    }
}
