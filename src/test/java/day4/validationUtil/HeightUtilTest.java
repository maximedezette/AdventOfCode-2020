package day4.validationUtil;

import adventOfCode.day4.validationUtils.HeightUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightUtilTest {

    @Test
    void shouldBeValidIfMatchScopeInCentimeters(){
        String height="190cm";
        assertThat(HeightUtil.isValid(height)).isTrue();
    }

    @Test
    void shouldBeInvalidIfDontMatchScopeInCentimeters(){
        String height="10cm";
        assertThat(HeightUtil.isValid(height)).isFalse();
    }

    @Test
    void shouldBeValidIfMatchScopeInInch(){
        String height="60in";
        assertThat(HeightUtil.isValid(height)).isTrue();
    }

    @Test
    void shouldBeInvalidIfDontMatchScopeInInch(){
        String height="190in";
        assertThat(HeightUtil.isValid(height)).isFalse();
    }

    @Test
    void shouldBeInvalidIfDontMatchFormat(){
        String height="190";
        assertThat(HeightUtil.isValid(height)).isFalse();
    }

}
