package adventOfCode.day9;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
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

    @Test
    void shouldGetTheContiguousSet() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<BigInteger> inputs = fileManager.get(FILE_PATH);
        List<BigInteger> expectedContigousSet = new ArrayList<>();
        expectedContigousSet.add(new BigInteger("15"));
        expectedContigousSet.add(new BigInteger("25"));
        expectedContigousSet.add(new BigInteger("47"));
        expectedContigousSet.add(new BigInteger("40"));

        XMASManager xmasManager = new XMASManager(5,inputs);
        assertThat(xmasManager.getContiguousSet(new BigInteger("127"))).isEqualTo(expectedContigousSet);
    }

    @Test
    void shouldGetExtremumValues() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<BigInteger> inputs = fileManager.get(FILE_PATH);
        List<BigInteger> contiguousSet = new ArrayList<>();
        contiguousSet.add(new BigInteger("15"));
        contiguousSet.add(new BigInteger("25"));
        contiguousSet.add(new BigInteger("47"));
        contiguousSet.add(new BigInteger("40"));

        XMASManager xmasManager = new XMASManager(5,inputs);
        assertThat(xmasManager.getSumOfExtremaContiguousList(new BigInteger("127"))).isEqualTo(new BigInteger("62"));
    }
}
