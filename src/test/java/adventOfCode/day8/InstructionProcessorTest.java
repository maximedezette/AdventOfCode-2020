package adventOfCode.day8;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day8.FileManagerTest.FILE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class InstructionProcessorTest {

    @Test
    void shouldProcessTheNopInstructions() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> entries = fileManager.get(FILE_PATH);
        InstructionManager instructionManager = new InstructionManager(entries);
        Instruction nopInstruction = new Instruction();
        nopInstruction.setCommand("nop");
        nopInstruction.setStep(0);

        instructionManager.processInstruction(nopInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(0);
        assertThat(instructionManager.getCursor()).isEqualTo(1);
    }
    @Test
    void shouldProcessTheAccInstructions() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> entries = fileManager.get(FILE_PATH);
        InstructionManager instructionManager = new InstructionManager(entries);
        Instruction accInstruction = new Instruction();
        accInstruction.setCommand("acc");
        accInstruction.setStep(3);

        instructionManager.processInstruction(accInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(3);
        assertThat(instructionManager.getCursor()).isEqualTo(1);
    }

    @Test
    void shouldProcessTheJmpInstructions() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> entries = fileManager.get(FILE_PATH);
        InstructionManager instructionManager = new InstructionManager(entries);
        Instruction jpmInstruction = new Instruction();
        jpmInstruction.setCommand("jmp");
        jpmInstruction.setStep(3);

        instructionManager.processInstruction(jpmInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(0);
        assertThat(instructionManager.getCursor()).isEqualTo(3);
    }

    @Test
    void shouldGetCorrectValueInAccumulator() throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> entries = fileManager.get(FILE_PATH);
        InstructionManager instructionManager = new InstructionManager(entries);

        instructionManager.play();

        assertThat(instructionManager.getAccumulator()).isEqualTo(5);
    }
}
