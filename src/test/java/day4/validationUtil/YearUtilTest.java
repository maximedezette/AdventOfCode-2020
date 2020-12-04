package day4.validationUtil;

import adventOfCode.day4.validationUtils.YearUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YearUtilTest {

    @Test
    void yearShouldBeValidInScope(){
        String year = "2000";
        assertThat(YearUtil.dateIsValid(year,1920,2002)).isTrue();
    }

    @Test
    void yearShouldBeInvalidInScope(){
        String year = "2004";
        assertThat(YearUtil.dateIsValid(year,1920,2002)).isFalse();
    }
}
