package adventOfCode.day2;

import java.util.Objects;

public class Password {

    private int minOccurrence;
    private int maxOccurrence;
    private char character;
    private String sequence;

    public int getMinOccurrence() {
        return minOccurrence;
    }

    public void setMinOccurrence(int minOccurrence) {
        this.minOccurrence = minOccurrence;
    }

    public int getMaxOccurrence() {
        return maxOccurrence;
    }

    public void setMaxOccurrence(int maxOccurrence) {
        this.maxOccurrence = maxOccurrence;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }


    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    public boolean isValidAccordingToFirstRule() {
        long numberOfSpecifiedLetter = sequence.chars().filter( (c) -> c == character).count();

        return (numberOfSpecifiedLetter >= minOccurrence && numberOfSpecifiedLetter <= maxOccurrence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return minOccurrence == password.minOccurrence &&
                maxOccurrence == password.maxOccurrence &&
                character == password.character &&
                Objects.equals(sequence, password.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minOccurrence, maxOccurrence, character, sequence);
    }

    @Override
    public String toString() {
        return "Password{" +
                "minOccurrence=" + minOccurrence +
                ", maxOccurrence=" + maxOccurrence +
                ", character=" + character +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
