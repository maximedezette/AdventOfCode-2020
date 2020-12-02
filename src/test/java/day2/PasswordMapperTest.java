package day2;

import adventOfCode.day2.Password;
import adventOfCode.day2.PasswordMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordMapperTest {

    @Test
    void shouldMapLineToCorrespondingPassword(){
        Password expectedPassword = new Password();
        expectedPassword.setFirstFigureInRule(1);
        expectedPassword.setCharacterInRule('a');
        expectedPassword.setSecondFigureInRule(3);
        expectedPassword.setPasswordString("abcde");

        assertThat(PasswordMapper.toPassword("1-3 a: abcde"))
                .isEqualTo(expectedPassword);
    }

    @Test
    void shouldMapLineToCorrespondingPasswordWhenTwoFiguresOccurence(){
        Password expectedPassword = new Password();
        expectedPassword.setFirstFigureInRule(12);
        expectedPassword.setCharacterInRule('s');
        expectedPassword.setSecondFigureInRule(15);
        expectedPassword.setPasswordString("dsjqsshdssbssstsssss");

        assertThat(PasswordMapper.toPassword("12-15 s: dsjqsshdssbssstsssss"))
                .isEqualTo(expectedPassword);
    }
}
