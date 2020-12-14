package adventOfCode.day11;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day11.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class GridManagerTest {

    @Test
    void shouldGetTheNumberOfSeatsThatEndUpOccupied() throws FileNotFoundException {
        List<String> input = FileManager.get(FILE_PATH);
        Grid grid = new Grid(input);
        assertThat(GridManager.getSeatsEndingUpOccupied(grid)).isEqualTo(37);
    }
    @Test
    void shouldGetTheNumberOfSeatsThatEndUpOccupiedWithPartTwoRules() throws FileNotFoundException {
        List<String> input = FileManager.get(FILE_PATH);
        Grid grid = new Grid(input);
        assertThat(GridManager.getSeatsEndingUpOccupiedWithPartTwoRules(grid)).isEqualTo(26);
    }
}
