package adventOfCode.day7;

import java.io.FileNotFoundException;
import java.util.Map;

import static adventOfCode.day7.Constants.shinyBagLibelle;

public class BagManager {

    public int getNumberOfBagsThatCanContainsAShinnyGoldBag(String path) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        int numberOfBagThatCanContainsShinnyGoldBag = 0;
        Map<String,Bag> bags = fileManager.get(path);
        for (Map.Entry<String, Bag> entry : bags.entrySet()) {
            Bag bag = entry.getValue();
            if (bag.getAmountOfShinyGoldBag() > 0) {
                numberOfBagThatCanContainsShinnyGoldBag++;
            }
        }
        return numberOfBagThatCanContainsShinnyGoldBag;
    }

    public int getIndividualBagsInsideShinnyBag(String path) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        Map<String,Bag> bags = fileManager.get(path);
        Bag shinnyGoldBag = bags.get(shinyBagLibelle);

        return shinnyGoldBag.getAmountOfIndividualBag();
    }
}
