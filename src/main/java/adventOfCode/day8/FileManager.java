package adventOfCode.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<Instruction> get(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<Instruction> instructions = new ArrayList<>();

        while (sc.hasNext()){
            String line = sc.nextLine();
            Instruction instruction = new Instruction();
            instruction.setCommand(getCommand(line));
            instruction.setStep(getStep(line));
            instructions.add(instruction);
        }
        return instructions;
    }

    private String getCommand(String line) {
        return line.split(" ")[0];
    }

    private Integer getStep(String line){
        return Integer.valueOf(line.split(" ")[1]);
    }
}
