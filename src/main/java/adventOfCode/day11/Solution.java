package adventOfCode.day11;

import java.io.FileNotFoundException;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day11\\input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Grid grid = new Grid(FileManager.get(FILE_PATH));
        System.out.println(GridManager.getSeatsEndingUpOccupied(grid));
        System.out.println(GridManager.getSeatsEndingUpOccupiedWithPartTwoRules(grid));
    }
}
