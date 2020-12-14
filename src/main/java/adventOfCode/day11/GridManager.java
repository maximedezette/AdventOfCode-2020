package adventOfCode.day11;

public class GridManager {
    public static long getSeatsEndingUpOccupied(Grid grid) {
        long emptySeats = grid.countOccupiedSeats() + 1;
        while (grid.countOccupiedSeats() != emptySeats){
            emptySeats = grid.countOccupiedSeats();
            grid = grid.update();
        }
        return emptySeats;
    }

    public static long getSeatsEndingUpOccupiedWithPartTwoRules(Grid grid) {
        long emptySeats = grid.countOccupiedSeats() + 1;
        while (grid.countOccupiedSeats() != emptySeats){
            emptySeats = grid.countOccupiedSeats();
            grid = grid.updateWithPartTwoRules();
        }
        return emptySeats;
    }
}
