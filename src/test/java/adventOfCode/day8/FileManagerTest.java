package adventOfCode.day8;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day8\\entries.txt";

    @Test
    void shouldRetrieveAllInstructions() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> entries = fileManager.get(FILE_PATH);
        assertThat(entries).hasSize(9);
        assertThat(entries.get(0).getCommand()).isEqualTo("nop");
        assertThat(entries.get(0).getStep()).isEqualTo(0);
    }
}
