package adventOfCode.day8;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static adventOfCode.day8.FileManagerTest.FILE_PATH;
import static adventOfCode.day8.InstructionManager.JMP;
import static adventOfCode.day8.InstructionManager.NOP;
import static org.assertj.core.api.Assertions.assertThat;

public class InstructionProcessorTest {

    FileManager fileManager;
    List<Instruction> entries;
    InstructionManager instructionManager;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        fileManager = new FileManager();
        entries = fileManager.get(FILE_PATH);
        instructionManager = new InstructionManager(entries);
    }

    @Test
    void shouldProcessTheNopInstructions() throws FileNotFoundException {
        Instruction nopInstruction = new Instruction();
        nopInstruction.setCommand("nop");
        nopInstruction.setStep(0);

        instructionManager.processInstruction(nopInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(0);
        assertThat(instructionManager.getCursor()).isEqualTo(1);
    }

    @Test
    void shouldProcessTheAccInstructions() throws FileNotFoundException {
        Instruction accInstruction = new Instruction();
        accInstruction.setCommand("acc");
        accInstruction.setStep(3);

        instructionManager.processInstruction(accInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(3);
        assertThat(instructionManager.getCursor()).isEqualTo(1);
    }

    @Test
    void shouldProcessTheJmpInstructions() throws FileNotFoundException {
        Instruction jpmInstruction = new Instruction();
        jpmInstruction.setCommand("jmp");
        jpmInstruction.setStep(3);

        instructionManager.processInstruction(jpmInstruction);

        assertThat(instructionManager.getAccumulator()).isEqualTo(0);
        assertThat(instructionManager.getCursor()).isEqualTo(3);
    }

    @Test
    void shouldGetCorrectValueInAccumulator() throws FileNotFoundException {

        instructionManager.playWithInterruptionOnError();

        assertThat(instructionManager.getAccumulator()).isEqualTo(5);
    }

    @Test
    void shouldChangeInstructionWhenMutate(){
        Instruction expectedInstruction = new Instruction();
        expectedInstruction.setCommand(JMP);
        expectedInstruction.setStep(0);

        instructionManager.doMutation();

        assertThat(instructionManager.getInstructions().get(0)).isEqualTo(expectedInstruction);
    }

    @Test
    void shouldChangeInstructionWhenMutateMultipleTimes(){
        Instruction expectedInstruction = new Instruction();
        expectedInstruction.setCommand(NOP);
        expectedInstruction.setStep(4);

        instructionManager.doMutation();
        instructionManager.doMutation();

        assertThat(instructionManager.getInstructions().get(2)).isEqualTo(expectedInstruction);
    }

    @Test
    void shouldRollbackInstructionAlreadyMutatedWhenMutateMultipleTimes(){
        Instruction expectedInstruction = new Instruction();
        expectedInstruction.setCommand(NOP);
        expectedInstruction.setStep(0);

        instructionManager.doMutation();
        instructionManager.doMutation();

        assertThat(instructionManager.getInstructions().get(0)).isEqualTo(expectedInstruction);
    }

    @Test
    void shouldGetToTheEndOfProgram(){
        instructionManager.playWithMutationOnError();
        assertThat(instructionManager.getAccumulator()).isEqualTo(8);
    }


}
