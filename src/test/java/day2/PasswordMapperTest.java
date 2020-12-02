package day2;

import adventOfCode.day2.Password;
import adventOfCode.day2.PasswordMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordMapperTest {

    @Test
    void shouldMapLineToCorrespondingPassword(){
        Password expectedPassword = new Password();
        expectedPassword.setMinOccurrence(1);
        expectedPassword.setCharacter('a');
        expectedPassword.setMaxOccurrence(3);
        expectedPassword.setSequence("abcde");

        assertThat(PasswordMapper.toPassword("1-3 a: abcde"))
                .isEqualTo(expectedPassword);
    }

    @Test
    void shouldMapLineToCorrespondingPasswordWhenTwoFiguresOccurence(){
        Password expectedPassword = new Password();
        expectedPassword.setMinOccurrence(12);
        expectedPassword.setCharacter('s');
        expectedPassword.setMaxOccurrence(15);
        expectedPassword.setSequence("dsjqsshdssbssstsssss");

        assertThat(PasswordMapper.toPassword("12-15 s: dsjqsshdssbssstsssss"))
                .isEqualTo(expectedPassword);
    }
}
