package adventOfCode.day11;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day11.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    public static final String FIRST_UPDATE_INPUT = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day11\\firstUpdate.txt";
    public static final String SECOND_UPDATE_INPUT = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day11\\secondUpdate.txt";

    @Test
    void shouldCountNumberOfOccupiedSeats() throws FileNotFoundException {
        List<String> input = FileManager.get(FILE_PATH);
        Grid grid = new Grid(input);
        assertThat(grid.countOccupiedSeats()).isEqualTo(0);
        assertThat(grid.update().countOccupiedSeats()).isEqualTo(71);
    }

    @Test
    void shouldUpdateAfterFirstRound() throws FileNotFoundException {
        List<String> input = FileManager.get(FILE_PATH);
        Grid grid = new Grid(input);
        List<String> inputAfterFirstUpdate = FileManager.get(FIRST_UPDATE_INPUT);
        Grid expectedGrid = new Grid(inputAfterFirstUpdate);

        assertThat(grid.update()).isEqualTo(expectedGrid);
    }

    @Test
    void shouldUpdateAfterSecondRound() throws FileNotFoundException {
        List<String> input = FileManager.get(FILE_PATH);
        Grid grid = new Grid(input);
        List<String> inputAfterSecondUpdate = FileManager.get(SECOND_UPDATE_INPUT);
        Grid expectedGrid = new Grid(inputAfterSecondUpdate);
        grid = grid.update();
        grid = grid.update();

        assertThat(grid).isEqualTo(expectedGrid);
    }

    @Test
    void shouldGetAdjacentOccupiedSeats() throws FileNotFoundException {
        List<String> inputAfterFirstUpdate = FileManager.get(FIRST_UPDATE_INPUT);
        Grid grid = new Grid(inputAfterFirstUpdate);
        assertThat(grid.countOccupiedAdjacentSeat(2,1)).isEqualTo(5);

    }
    @Test
    void shouldGetAdjacentOccupiedSeatsOnTopLeftCorner() throws FileNotFoundException {
        List<String> inputAfterFirstUpdate = FileManager.get(FIRST_UPDATE_INPUT);
        Grid grid = new Grid(inputAfterFirstUpdate);
        assertThat(grid.countOccupiedAdjacentSeat(0,0)).isEqualTo(2);

    }

    @Test
    void shouldGetAdjacentOccupiedSeatsOnBottomRightCorner() throws FileNotFoundException {
        List<String> inputAfterFirstUpdate = FileManager.get(FIRST_UPDATE_INPUT);
        Grid grid = new Grid(inputAfterFirstUpdate);
        assertThat(grid.countOccupiedAdjacentSeat(9,9)).isEqualTo(2);

    }
}
