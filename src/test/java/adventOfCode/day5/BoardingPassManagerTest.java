package adventOfCode.day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardingPassManagerTest {

    @Test
    void shouldGetTheCorrectRowForLine(){
        String pass = "FBFBBFFRLR";
        BoardingPassManager boardingPassManager = new BoardingPassManager();
        assertThat(boardingPassManager.getRow(pass)).isEqualTo(44);
    }

    @Test
    void shouldGetTheColumnForLine(){
        String pass = "FBFBBFFRLR";
        BoardingPassManager boardingPassManager = new BoardingPassManager();
        assertThat(boardingPassManager.getColumn(pass)).isEqualTo(5);
    }

    @Test
    void shouldGetSeatId(){
        String pass = "FBFBBFFRLR";
        BoardingPassManager boardingPassManager = new BoardingPassManager();
        assertThat(boardingPassManager.getSeatId(pass)).isEqualTo(357);

    }
}
