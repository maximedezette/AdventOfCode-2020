package day1;

import adventOfCode.day1.ExpenseCalculator;
import adventOfCode.day1.FileManager;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseCalculatorTest {



    @Test
    void shouldMultiplyTheTwoEntriesCorrespondingTo2020() throws FileNotFoundException {

        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        FileManager fileManager = new FileManager();
        List<Integer> entries = fileManager.getEntries(FileManagerTest.FILE_PATH);

        assertThat(expenseCalculator.getMultiplicationSumOfTwo(entries))
                .isEqualTo(514579);
    }

    @Test
    void shouldMultiplyTheThreeEntriesCorrespondingTo2020() throws FileNotFoundException {

        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        FileManager fileManager = new FileManager();
        List<Integer> entries = fileManager.getEntries(FileManagerTest.FILE_PATH);

        assertThat(expenseCalculator.getMultiplicationSumOfThree(entries))
                .isEqualTo(241861950);
    }
}