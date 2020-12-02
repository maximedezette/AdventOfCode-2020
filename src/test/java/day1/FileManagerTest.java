package day1;

import adventOfCode.day1.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\day1\\entries.txt";

    private FileManager fileManager;

    @BeforeEach
    void setup() {
        fileManager = new FileManager();
    }

    @Test
    void shouldThrowExceptionWhenWrongPath() throws FileNotFoundException {
        assertThatThrownBy(() -> fileManager.getEntries("wrongPath.txt"));
    }

    @Test
    void shouldBuildArrayFromTextFile() throws FileNotFoundException {
        assertThat(fileManager.getEntries(FILE_PATH))
                .hasSize(6);
    }
}
