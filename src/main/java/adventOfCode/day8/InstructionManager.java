package adventOfCode.day8;

import java.util.ArrayList;
import java.util.List;

public class InstructionManager {

    public static final String NOP = "nop";
    public static final String ACC = "acc";
    public static final String JMP = "jmp";
    private List<Instruction> instructions;
    private List<Instruction> originalInstructions;
    private int cursor = 0;
    private int accumulator = 0;
    private List<Integer> cursorHistory = new ArrayList<>();
    private List<Integer> mutationHistory = new ArrayList<>();

    public InstructionManager(List<Instruction> instructions) {
        this.instructions = instructions;
        originalInstructions = new ArrayList<>(instructions);

    }

    public int getCursor() {
        return cursor;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public List<Instruction> getInstructions() {
        return instructions;
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

    public void playWithInterruptionOnError(){
        while (canProcessInstruction()){
            processInstruction(instructions.get(cursor));
        }
    }

    public void playWithMutationOnError(){
        while (canProcessInstruction()){
            processInstruction(instructions.get(cursor));
        }
        if(cursor < instructions.size()){
            doMutation();
            playWithMutationOnError();
        }
    }

    private void reset() {
        this.cursor = 0;
        this.accumulator = 0;
        this.instructions = new ArrayList<>(originalInstructions);
        this.cursorHistory = new ArrayList<>();
    }

    private boolean canProcessInstruction() {
        boolean canProcessInstruction = true;
        for (Integer previousCursorPosition : cursorHistory) {
            if (cursor == previousCursorPosition) {
                canProcessInstruction = false;
            }
        }
        if(cursor >= instructions.size()){
            canProcessInstruction = false;
        }

        return canProcessInstruction;
    }

    public void doMutation() {

        reset();
        boolean hasAlreadyMutateAnInstruction = false;

        for(int i =0; i < instructions.size(); i++){
            if(canMutate(instructions.get(i)) && !hasAlreadyMutateAnInstruction && !hasAlreadyMutateThisInstructionBefore(i)){
                instructions.set(i,mutate(instructions.get(i)));
                hasAlreadyMutateAnInstruction = true;
                mutationHistory.add(i);
            }
        }

    }

    private boolean hasAlreadyMutateThisInstructionBefore(int position) {
        for (Integer positionAlreadyMutatedBefore: mutationHistory) {
            if(position == positionAlreadyMutatedBefore){
                return true;
            }
        }
        return false;
    }

    private Instruction mutate(Instruction instruction) {
        Instruction mutatedInstruction = new Instruction();
        mutatedInstruction.setCommand(instruction.getCommand());
        mutatedInstruction.setStep(instruction.getStep());

        if(mutatedInstruction.getCommand().equals(JMP)){
            mutatedInstruction.setCommand(NOP);
        }else if(mutatedInstruction.getCommand().equals(NOP)){
            mutatedInstruction.setCommand(JMP);
        }
        return mutatedInstruction;
    }

    private boolean canMutate(Instruction instruction) {
        return (instruction.getCommand().equals(NOP) || instruction.getCommand().equals(JMP));
    }
}
