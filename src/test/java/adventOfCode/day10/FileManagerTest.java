package adventOfCode.day10;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\entries.txt";

    @Test
    void shouldRetrieveAdapterList() throws FileNotFoundException {
        assertThat(FileManager.get(FILE_PATH)).hasSize(11);
    }

}
