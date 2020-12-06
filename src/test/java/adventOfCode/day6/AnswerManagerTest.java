package adventOfCode.day6;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;


import static adventOfCode.day6.FileManagerTest.PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerManagerTest {

    @Test
    void shouldGetSumOfUnanimousAnswers() throws FileNotFoundException {
        AnswerManager answerManager = new AnswerManager();
        FileManager fileManager = new FileManager();
        List<String> entries = fileManager.get(PATH);
        assertThat(answerManager.getAmountOfUnanimousAnswer(entries)).isEqualTo(6);
    }
}
