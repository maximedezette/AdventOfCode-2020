package adventOfCode.day9;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day9\\entries.txt";

    public static void main(String args[]) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<BigInteger> inputs = fileManager.get(FILE_PATH);
        XMASManager xmasManager = new XMASManager(25,inputs);

        System.out.println(xmasManager.getNumberNotFollowingTheRule());

    }
}
