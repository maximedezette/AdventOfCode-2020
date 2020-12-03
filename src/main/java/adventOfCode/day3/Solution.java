package adventOfCode.day3;

import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\day3\\entries.txt";

    public static void main(String[] args) throws Exception {

        FileManager filemanager = new FileManager();
        List<String> area = filemanager.getEntries(FILE_PATH);
        SlopeManager slopeManager = new SlopeManager(area);
        Slope slope = new Slope(3,1);

        System.out.println(slopeManager.countTree(slope));
    }
}
