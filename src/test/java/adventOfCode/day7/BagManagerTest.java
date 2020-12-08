package adventOfCode.day7;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static adventOfCode.day7.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class BagManagerTest {

    public static final String SECOND_FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day7\\entries2.txt";

    @Test
    void shouldGetTheRightAmountOfBagsThatCanContainsShinnyGoldBags() throws FileNotFoundException {
            BagManager bagManager = new BagManager();
            assertThat(bagManager.getNumberOfBagsThatCanContainsAShinnyGoldBag(FILE_PATH)).isEqualTo(4);

    }

    @Test
    void shouldGetTheRightNumberOfBagsInsideShinnyGoldBags() throws FileNotFoundException {
            BagManager bagManager = new BagManager();
            assertThat(bagManager.getIndividualBagsInsideShinnyBag(FILE_PATH) ).isEqualTo(32);
            assertThat(bagManager.getIndividualBagsInsideShinnyBag(SECOND_FILE_PATH) ).isEqualTo(126);

    }
}
