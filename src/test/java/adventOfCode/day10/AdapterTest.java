package adventOfCode.day10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdapterTest {

    @Test
    void shouldConnectToJoltage(){
        Adapter adapter = new Adapter(3);

        assertThat(adapter.canConnect(0)).isTrue();
        assertThat(adapter.canConnect(1)).isTrue();
        assertThat(adapter.canConnect(2)).isTrue();
        assertThat(adapter.canConnect(3)).isTrue();
        assertThat(adapter.canConnect(4)).isFalse();
    }

    @Test
    void shouldIndicateTheDifference(){
        Adapter adapter = new Adapter(1);

        assertThat(adapter.getDifference(0)).isEqualTo(1);
    }
}
