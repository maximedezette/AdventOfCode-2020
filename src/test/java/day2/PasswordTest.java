package day2;

import adventOfCode.day2.Password;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @Test
    void shouldBeValidWhenFollowRule() {
        Password password = new Password();
        password.setMinOccurrence(1);
        password.setMaxOccurrence(3);
        password.setCharacter('a');
        password.setSequence("abcde");

        assertThat(password.isValidAccordingToFirstRule()).isTrue();

    }

    @Test
    void shouldBeInvalidWhenDontFollowRule() {
        Password password = new Password();
        password.setMinOccurrence(1);
        password.setMaxOccurrence(3);
        password.setCharacter('b');
        password.setSequence("cdefg");

        assertThat(password.isValidAccordingToFirstRule()).isFalse();

    }
}
