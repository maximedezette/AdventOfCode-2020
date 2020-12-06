package adventOfCode.day4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day4\\entries.txt.txt";

    @Test
    void shouldGetRightAmountOfPassword() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Passport> passportList = fileManager.getPasswordList(FILE_PATH);
        assertThat(passportList).hasSize(4);
    }
}
