package adventOfCode.day3;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day3\\entries.txt";

    @Test
    void shouldGetAllTheLinesFromEntry() throws FileNotFoundException {
        FileManager filemanager = new FileManager();
        assertThat(filemanager.getEntries(FILE_PATH))
                .hasSize(11);
    }

    @Test
    void shouldMatchTheLinesFromEntry() throws FileNotFoundException {
        FileManager filemanager = new FileManager();
        assertThat(filemanager.getEntries(FILE_PATH).get(0))
                .isEqualTo("..##.......");

    }
}
