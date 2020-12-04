package day4.validationUtil;

import adventOfCode.day4.validationUtils.EyeColorUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EyeColorUtilTest {

    @Test
    void shouldBeValidWhenMatchFormat(){
        String eyeColor = "brn";
        assertThat(EyeColorUtil.isValid(eyeColor)).isTrue();
    }

    @Test
    void shouldBeInvalidWhenDontMatchFormat(){
        String eyeColor = "wat";
        assertThat(EyeColorUtil.isValid(eyeColor)).isFalse();
    }
}
