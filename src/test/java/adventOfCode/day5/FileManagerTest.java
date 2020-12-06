package adventOfCode.day5;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {
    @Test
    void shouldRetrieveAllEntries() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<String> entries = fileManager.get("C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day5\\entries.txt.txt");
        assertThat(entries).hasSize(3);
    }
}
