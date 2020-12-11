package adventOfCode.day10;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day10.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class AdapterManagerTest {

    public static final String SECOND_FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\entries2.txt";

    @Test
    void shouldGetDifferenceNumber() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.calculateDifferences()).isEqualTo(35);
    }

    @Test
    void shouldGetDifferenceNumberOnLargerFile() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(SECOND_FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.calculateDifferences()).isEqualTo(220);
    }
}
