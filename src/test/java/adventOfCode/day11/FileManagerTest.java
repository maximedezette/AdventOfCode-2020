package adventOfCode.day11;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day11\\part1\\entries.txt";

    @Test
    void shouldGetTheInputsContent() throws FileNotFoundException {
        assertThat(FileManager.get(FILE_PATH)).hasSize(10);
    }
}
