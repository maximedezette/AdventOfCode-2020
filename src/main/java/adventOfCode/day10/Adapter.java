package adventOfCode.day10;

public class Adapter implements Comparable<Adapter>{
    private Integer joltage;

    public Adapter(Integer joltage) {
        this.joltage = joltage;
    }

    public boolean canConnect(int jolt) {
        return  jolt + 3 >= joltage && joltage  >= jolt;
    }

    public int getDifference(int jolt) {
        return joltage - jolt;
    }

    public Integer getJoltage() {
        return joltage;
    }

    @Override
    public int compareTo(Adapter o) {
        return this.getJoltage().compareTo(o.getJoltage());
    }
}
