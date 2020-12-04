package day4;

import adventOfCode.day4.FileManager;
import adventOfCode.day4.Passport;
import adventOfCode.day4.PassportManager;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class PassportManagerTest {

    public static final String VALID_ENTRIES = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\day4\\validPassportEntries.txt";

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
        List<Passport> passportList =  fileManager.getPasswordList("C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\day4\\invalidPassports.txt");
        PassportManager passportManager = new PassportManager();

        assertThat(passportManager.countValidPassword(passportList))
                .isEqualTo(0);
    }
}
