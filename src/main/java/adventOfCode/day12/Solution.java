package adventOfCode.day12;

import adventOfCode.day11.FileManager;

import java.io.FileNotFoundException;
import java.util.List;

public class Solution {

    public static final String INPUTS = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day12\\inputs.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<String> inputs = FileManager.get(INPUTS);
        NavigationComputer navigationComputer = new NavigationComputer(inputs);
        System.out.println(navigationComputer.getManhattanDistance());
    }
}
