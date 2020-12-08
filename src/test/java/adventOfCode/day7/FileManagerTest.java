package adventOfCode.day7;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day7\\entries.txt";
    public static final String LIGHT_RED_BAG = "light red bag";

    @Test
    void shouldInitTheBagList() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        Map<String,Bag> entries = fileManager.get(FILE_PATH);
        assertThat(entries).hasSize(9);
        assertThat(entries.get(LIGHT_RED_BAG).getChildren()).hasSize(2);
    }
}
