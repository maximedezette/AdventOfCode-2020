package adventOfCode.day6;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day6\\entries.txt";

    @Test
    void shouldGetStringOfAnswersCorrespondingToGroups() throws FileNotFoundException {
        FileManager filemanager = new FileManager();
        List<String> entries = filemanager.get(PATH);
        assertThat(entries).hasSize(5);
    }

    @Test
    void shouldGetStringOfAnswersWithoutDuplicates() throws FileNotFoundException {
        FileManager filemanager = new FileManager();
        List<String> entries = filemanager.get(PATH);
        assertThat(entries.get(2)).isEqualTo("a");
    }
}
