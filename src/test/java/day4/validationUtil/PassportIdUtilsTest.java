package day4.validationUtil;

import adventOfCode.day4.validationUtils.PassportIdUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportIdUtilsTest {

    @Test
    void shouldBeValidWhenMatchFormat(){
        String pid = "000000001";
        assertThat(PassportIdUtil.isValid(pid)).isTrue();
    }
    @Test
    void shouldBeInvalidWhenDontMatchFormat(){
        String pid = "0123456789";
        assertThat(PassportIdUtil.isValid(pid)).isFalse();
    }
}
