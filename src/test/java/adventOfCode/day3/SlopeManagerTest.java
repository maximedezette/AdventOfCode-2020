package adventOfCode.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static adventOfCode.day3.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class SlopeManagerTest {

    private FileManager filemanager;
    private  List<String> area;
    private  SlopeManager slopeManager;
    private  Slope slope;

    @BeforeEach
    void setup() throws FileNotFoundException {
         filemanager = new FileManager();
         area = filemanager.getEntries(FILE_PATH);
         slopeManager = new SlopeManager(area);
         slope = new Slope(3,1);
    }

    @Test
    void shouldGetNextPositionContentWhenNoTree()  {

        Position startingPosition = new Position(0,0);
        assertThat(slopeManager.getNextPositionContent(startingPosition,slope))
                .isEqualTo('.');

    }

    @Test
    void shouldGetNextPositionContentWhenTree() {

        Position startingPosition = new Position(3,1);
        assertThat(slopeManager.getNextPositionContent(startingPosition,slope))
                .isEqualTo('#');

    }

    @Test
    void shouldGetNextPositionContentWhenBorderOfArea()  {

        Position startingPosition = new Position(9,3);
        Slope slope = new Slope(3,1);
        assertThat(slopeManager.getNextPositionContent(startingPosition,slope))
                .isEqualTo('#');

    }

    @Test
    void shouldGetNextPosition() {
        Position startingPosition = new Position(0,0);
        Position expectedUpdatedPosition = new Position(3,1);

        assertThat(slopeManager.updatePosition(startingPosition,slope))
                .isEqualTo(expectedUpdatedPosition);

    }

    @Test
    void shouldGetNextPositionOnBorder()  {
        Position startingPosition = new Position(9,3);
        Position expectedUpdatedPosition = new Position(1,4);

        assertThat(slopeManager.updatePosition(startingPosition,slope))
                .isEqualTo(expectedUpdatedPosition);

    }

    @Test
    void shouldGetNumberOfTreesOnSingleSlope() {
        assertThat(slopeManager.countTree(slope))
                .isEqualTo(7);

    }

    @Test
    void shouldGetMultiplicationOfNumberOfTreesOnMultipleSlope() {
        List<Slope> slopes = new ArrayList<>();
        slopes.add(new Slope(1,1));
        slopes.add(new Slope(3,1));
        slopes.add(new Slope(5,1));
        slopes.add(new Slope(7,1));
        slopes.add(new Slope(1,2));


        assertThat(slopeManager.multiplyNumberOfTrees(slopes))
                .isEqualTo(336);

    }
}
