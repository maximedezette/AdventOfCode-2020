package adventOfCode.day9;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

import static adventOfCode.day9.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class XMASManagerTest {


    @Test
    void shouldGetTheFirstNumberThatCanNotBeObtainedByTheSumOfThePreambles() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<BigInteger> inputs = fileManager.get(FILE_PATH);

        XMASManager xmasManager = new XMASManager(5,inputs);
        assertThat(xmasManager.getNumberNotFollowingTheRule()).isEqualTo(new BigInteger("127"));
    }
}
