package adventOfCode.day1;

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

    @Test
    void shouldMultiplyTheThreeEntriesCorrespondingTo2020WithN() throws FileNotFoundException {

        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        FileManager fileManager = new FileManager();
        List<Integer> entries = fileManager.getEntries(FileManagerTest.FILE_PATH);

        assertThat(expenseCalculator.getMultiplicationSumOfN(entries,3))
                .isEqualTo(241861950);
    }

    @Test
    void shouldMultiplyTheTwoEntriesCorrespondingTo2020WithN() throws FileNotFoundException {

        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        FileManager fileManager = new FileManager();
        List<Integer> entries = fileManager.getEntries(FileManagerTest.FILE_PATH);

        assertThat(expenseCalculator.getMultiplicationSumOfN(entries,2))
                .isEqualTo(514579);
    }

}
