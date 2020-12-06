package adventOfCode.day4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportManagerTest {

    public static final String VALID_ENTRIES = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day4\\validPassportEntries.txt";
    public static final String INVALID_ENTRIES = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day4\\invalidPassports.txt";

    @Test
    void shouldIndicateTheNumberOfValidPassportsWhenAllCorrects() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Passport> passportList =  fileManager.getPasswordList(VALID_ENTRIES);
        PassportManager passportManager = new PassportManager();

        assertThat(passportManager.countValidPassword(passportList))
                .isEqualTo(4);
    }

    @Test
    void shouldIndicateTheNumberOfValidPassportsWhenWrongFormats() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Passport> passportList =  fileManager.getPasswordList(INVALID_ENTRIES);
        PassportManager passportManager = new PassportManager();

        assertThat(passportManager.countValidPassword(passportList))
                .isEqualTo(0);
    }
}
