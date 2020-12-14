package adventOfCode.day11;

import org.junit.jupiter.api.Test;

import static adventOfCode.day11.Seat.EMPTY;
import static adventOfCode.day11.Seat.OCCUPIED;
import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {


    @Test
    void shouldNotChangeStateInRegularCases(){
        Seat seat = new Seat();
        seat.setStatus(EMPTY);
        assertThat(seat.update(1).getStatus()).isEqualTo(EMPTY);
    }

    @Test
    void shouldBeOccupiedWhenNoAdjacentSeat(){
        Seat seat = new Seat();
        seat.setStatus(EMPTY);
        assertThat(seat.update(0).getStatus()).isEqualTo(OCCUPIED);
    }

    @Test
    void shouldBeEmptyWhenOvercrowded(){
        Seat seat = new Seat();
        seat.setStatus(OCCUPIED);
        assertThat(seat.update(4).getStatus()).isEqualTo(EMPTY);
    }
}
