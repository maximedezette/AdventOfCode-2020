package adventOfCode.day10;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static adventOfCode.day10.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class AdapterManagerTest {

    public static final String SECOND_FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\entries2.txt";

    @Test
    void shouldGetDifferenceNumber() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.calculateDifferences()).isEqualTo(35);
    }

    @Test
    void shouldGetDifferenceNumberOnLargerFile() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(SECOND_FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.calculateDifferences()).isEqualTo(220);
    }

    @Test
    void shouldGetTheNumberOfPath() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.getPossibleArrangements()).isEqualTo(new BigInteger("8"));
    }

    @Test
    void shouldGetTheNumberOfPathFirstExample() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get("C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\example1_from_reddit.txt");
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.getPossibleArrangements()).isEqualTo(new BigInteger("4"));
    }

    @Test
    void shouldGetTheNumberOfPathSecondExampe() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get("C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\example2_from_reddit.txt");
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.getPossibleArrangements()).isEqualTo(new BigInteger("7"));
    }

    @Test
    void shouldGetTheNumberOfPathFourthExample() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get("C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\test\\ressources\\adventOfCode\\day10\\example4_from_reddit.txt");
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.getPossibleArrangements()).isEqualTo(new BigInteger("28"));
    }

    @Test
    void shouldGetTheNumberOfPathLargerFile() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(SECOND_FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        assertThat(adapterManager.getPossibleArrangements()).isEqualTo(new BigInteger("19208"));
    }

    @Test
    void shouldGetTheAmountOfCombinaisonWithTwoElements(){
        List<Adapter> adapters = new ArrayList<>();
        adapters.add(new Adapter(1));
        adapters.add(new Adapter(2));
        AdapterManager adapterManager = new AdapterManager(adapters);

        assertThat(adapterManager.possibleCombinaisons(adapters)).isEqualTo(2);
    }

    @Test
    void shouldGetTheAmountOfCombinaisonWithThreeElements(){
        List<Adapter> adapters = new ArrayList<>();
        adapters.add(new Adapter(1));
        adapters.add(new Adapter(2));
        adapters.add(new Adapter(3));
        AdapterManager adapterManager = new AdapterManager(adapters);

        assertThat(adapterManager.possibleCombinaisons(adapters)).isEqualTo(4);
    }
    @Test
    void shouldGetTheAmountOfCombinaisonWithFourElements(){
        List<Adapter> adapters = new ArrayList<>();
        adapters.add(new Adapter(5));
        adapters.add(new Adapter(6));
        adapters.add(new Adapter(7));
        adapters.add(new Adapter(8));
        AdapterManager adapterManager = new AdapterManager(adapters);

        assertThat(adapterManager.possibleCombinaisons(adapters)).isEqualTo(7);
    }

    @Test
    void shouldStopAtMaxJolt() throws FileNotFoundException {
        List<Adapter> adapters = FileManager.get(SECOND_FILE_PATH);
        AdapterManager adapterManager = new AdapterManager(adapters);
        adapterManager.getPossibleArrangements();
        assertThat(adapterManager.getJolt()).isEqualTo(52);
    }

}
