package day2;

import adventOfCode.day2.Password;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @Test
    void shouldBeValidWhenFollowFirstRule() {
        Password password = new Password();
        password.setFirstFigureInRule(1);
        password.setSecondFigureInRule(3);
        password.setCharacterInRule('a');
        password.setPasswordString("abcde");

        assertThat(password.isValidAccordingToFirstRule()).isTrue();

    }

    @Test
    void shouldBeInvalidWhenDontFollowFirstRule() {
        Password password = new Password();
        password.setFirstFigureInRule(1);
        password.setSecondFigureInRule(3);
        password.setCharacterInRule('b');
        password.setPasswordString("cdefg");

        assertThat(password.isValidAccordingToFirstRule()).isFalse();

    }

    @Test
    void shouldBeValidWhenFollowSecondRule(){
        Password password = new Password();
        password.setFirstFigureInRule(1);
        password.setSecondFigureInRule(3);
        password.setCharacterInRule('a');
        password.setPasswordString("abcde");

        assertThat(password.isValidAccordingToSecondRule()).isTrue();
    }

    @Test
    void shouldBeInvalidWhenDontFollowSecondRule(){
        Password password = new Password();
        password.setFirstFigureInRule(1);
        password.setSecondFigureInRule(3);
        password.setCharacterInRule('b');
        password.setPasswordString("cdefg");

        Password secondIncorrectPassword = new Password();
        secondIncorrectPassword.setFirstFigureInRule(2);
        secondIncorrectPassword.setSecondFigureInRule(9);
        secondIncorrectPassword.setCharacterInRule('c');
        secondIncorrectPassword.setPasswordString("ccccccccc");

        assertThat(password.isValidAccordingToSecondRule()).isFalse();
        assertThat(secondIncorrectPassword.isValidAccordingToSecondRule()).isFalse();
    }
}
