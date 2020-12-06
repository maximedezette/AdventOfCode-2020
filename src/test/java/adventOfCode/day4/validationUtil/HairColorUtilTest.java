package adventOfCode.day4.validationUtil;

import adventOfCode.day4.validationUtils.HairColorUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HairColorUtilTest {

    @Test
    void shouldBeValidWhenMatchFormat(){
        String hairColor = "#123abc";

        assertThat(HairColorUtil.isValid(hairColor)).isTrue();
    }

    @Test
    void shouldBeInvalidWhenDontMatchFormat(){
        String hairColorWithLetterOutOfRange = "#123abz";
        String hairColorWithoutFirstChar = "123abc";

        assertThat(HairColorUtil.isValid(hairColorWithLetterOutOfRange)).isFalse();
        assertThat(HairColorUtil.isValid(hairColorWithoutFirstChar)).isFalse();
    }
}
