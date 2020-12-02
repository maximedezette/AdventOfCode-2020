package day2;

import adventOfCode.day2.FileManager;
import adventOfCode.day2.Password;
import adventOfCode.day2.PasswordManager;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static day2.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordManagerTest {

    @Test
    void shouldGetCorrectAmountOfValidPasswordFirstRule() throws FileNotFoundException {
        PasswordManager passwordManager = new PasswordManager();
        FileManager fileManager = new FileManager();
        List<Password> passwordList = fileManager.getEntries(FILE_PATH);
        assertThat(passwordManager.getNumberOfValidPasswordAccordingToFirstRule(passwordList))
                .isEqualTo(2);
    }

    @Test
    void shouldGetCorrectAmountOfValidPasswordSecondRule() throws FileNotFoundException {
        PasswordManager passwordManager = new PasswordManager();
        FileManager fileManager = new FileManager();
        List<Password> passwordList = fileManager.getEntries(FILE_PATH);
        assertThat(passwordManager.getNumberOfValidPasswordAccordingToSecondRule(passwordList))
                .isEqualTo(1);
    }
}
