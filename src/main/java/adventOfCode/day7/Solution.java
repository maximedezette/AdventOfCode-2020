package adventOfCode.day7;

import java.io.FileNotFoundException;


public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day7\\entries.txt";

    public static void main(String args[]) throws FileNotFoundException {
        BagManager bagManager = new BagManager();

        System.out.println(bagManager.getNumberOfBagsThatCanContainsAShinnyGoldBag(FILE_PATH));
        System.out.println(bagManager.getIndividualBagsInsideShinnyBag(FILE_PATH));
    }
}
