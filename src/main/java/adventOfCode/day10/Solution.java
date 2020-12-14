package adventOfCode.day10;

import java.io.FileNotFoundException;
import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day10\\entries.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<Adapter> adapters =  FileManager.get(FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);

        System.out.println(adapterManager.calculateDifferences());
        System.out.println(adapterManager.getPossibleArrangements());
    }
}
