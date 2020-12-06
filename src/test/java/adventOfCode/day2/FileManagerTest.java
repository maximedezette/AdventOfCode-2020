package adventOfCode.day2;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day2\\entries.txt.txt";

    @Test
    void shouldGetAllTheEntries() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Password> passwordsFromFile = fileManager.getEntries(FILE_PATH);

       assertThat(passwordsFromFile)
               .hasSize(3);
    }
}
