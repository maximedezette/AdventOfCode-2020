package adventOfCode.day3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode.day3\\entries.txt";

    public static void main(String[] args) throws Exception {

        FileManager filemanager = new FileManager();
        List<String> area = filemanager.getEntries(FILE_PATH);
        SlopeManager slopeManager = new SlopeManager(area);
        Slope slope = new Slope(3,1);

        System.out.println(slopeManager.countTree(slope));

        /**
         * PART 2
         */

        List<Slope> slopes = new ArrayList<>();
        slopes.add(new Slope(1,1));
        slopes.add(new Slope(3,1));
        slopes.add(new Slope(5,1));
        slopes.add(new Slope(7,1));
        slopes.add(new Slope(1,2));

        System.out.println(slopeManager.multiplyNumberOfTrees(slopes));
    }
}
