package adventOfCode.day9;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day9\\entries.txt";

    @Test
    void shouldGetTheData() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        assertThat(fileManager.get(FILE_PATH)).hasSize(20);
    }
}
