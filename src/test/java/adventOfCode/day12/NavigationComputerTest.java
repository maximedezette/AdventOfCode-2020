package adventOfCode.day12;

import adventOfCode.day11.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day12.NavigationComputer.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigationComputerTest {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day12\\input.txt";


    private NavigationComputer navigationComputer;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        List<String> inputs = FileManager.get(FILE_PATH);
        navigationComputer = new NavigationComputer(inputs);
    }


    @Test
    void shouldProcessGoingNorth()  {
        Action moveNorth = new Action(NORTH, 3);

        navigationComputer.process(moveNorth);

        assertThat(navigationComputer.getNorthSouthPosition()).isEqualTo(3);
    }

    @Test
    void shouldProcessGoingSouth()  {
        Action moveSouth = new Action(SOUTH, 3);

        navigationComputer.process(moveSouth);

        assertThat(navigationComputer.getNorthSouthPosition()).isEqualTo(-3);
    }

    @Test
    void shouldProcessGoingEast()  {
        Action moveEast = new Action(EAST, 3);

        navigationComputer.process(moveEast);

        assertThat(navigationComputer.getEastWestPosition()).isEqualTo(3);
    }

    @Test
    void shouldProcessGoingWest()  {
        Action moveWest = new Action(WEST, 3);

        navigationComputer.process(moveWest);

        assertThat(navigationComputer.getEastWestPosition()).isEqualTo(-3);
    }

    @Test
    void shouldProcessGoingForward()  {
        Action moveWest = new Action(WEST, 3);
        Action forward = new Action(FORWARD, 2);

        navigationComputer.process(moveWest);
        navigationComputer.process(forward);

        assertThat(navigationComputer.getEastWestPosition()).isEqualTo(-1);
    }

    @Test
    void shouldProcessRightRotation()  {
        Action rotateRight = new Action(ROTATE_RIGHT, 180);

        navigationComputer.process(rotateRight);

        assertThat(navigationComputer.getCurrentType()).isEqualTo(WEST);
    }

    @Test
    void shouldProcessLeftRotation()  {
        Action rotateLeft = new Action(ROTATE_LEFT, 180);

        navigationComputer.process(rotateLeft);

        assertThat(navigationComputer.getCurrentType()).isEqualTo(WEST);
    }

    @Test
    void shouldGetTheManhattanDistance() throws FileNotFoundException {
        List<String> inputs = FileManager.get(FILE_PATH);
        NavigationComputer navigationComputer = new NavigationComputer(inputs);
        assertThat(navigationComputer.getManhattanDistance()).isEqualTo(25);
    }
}
