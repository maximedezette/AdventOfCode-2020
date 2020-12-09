package adventOfCode.day8;

import java.util.ArrayList;
import java.util.List;

public class InstructionManager {

    public static final String NOP = "nop";
    public static final String ACC = "acc";
    public static final String JMP = "jmp";
    private List<Instruction> instructions;
    private int cursor = 0;
    private int accumulator = 0;
    private List<Integer> cursorHistory = new ArrayList<>();

    public InstructionManager(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public void processInstruction(Instruction instruction) {
        cursorHistory.add(cursor);
        switch (instruction.getCommand()) {
            case NOP:
                cursor++;
                break;
            case ACC:
                accumulator += instruction.getStep();
                cursor++;
                break;
            case JMP:
                cursor += instruction.getStep();
                break;

        }
    }

    public void play(){
        while (canProcessInstruction()){
            processInstruction(instructions.get(cursor));
        }
    }

    private boolean canProcessInstruction() {
        boolean canProcessInstruction = true;
        for (Integer previousCursorPosition : cursorHistory) {
            if (cursor == previousCursorPosition) {
                canProcessInstruction = false;
            }
        }
        return canProcessInstruction;
    }
}
