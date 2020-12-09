package adventOfCode.day8;

import java.io.FileNotFoundException;
import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day8\\entries.txt";

    public static void main(String args[]) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        List<Instruction> instructions = fileManager.get(FILE_PATH);
        InstructionManager instructionManager = new InstructionManager(instructions);

        // part 1
        instructionManager.playWithInterruptionOnError();
        System.out.println(instructionManager.getAccumulator());

        // part 2
        instructionManager.playWithMutationOnError();
        System.out.println(instructionManager.getAccumulator());
    }
}
