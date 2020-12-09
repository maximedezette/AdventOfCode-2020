package adventOfCode.day8;

import java.util.Objects;

public class Instruction {

    private String command;
    private int step;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return step == that.step &&
                Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, step);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "command='" + command + '\'' +
                ", step=" + step +
                '}';
    }
}
