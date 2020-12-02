package adventOfCode.day2;

import java.util.Objects;

public class Password {

    private int firstFigureInRule;
    private int secondFigureInRule;
    private char characterInRule;
    private String passwordString;


    public void setFirstFigureInRule(int firstFigureInRule) {
        this.firstFigureInRule = firstFigureInRule;
    }


    public void setSecondFigureInRule(int secondFigureInRule) {
        this.secondFigureInRule = secondFigureInRule;
    }


    public void setCharacterInRule(char characterInRule) {
        this.characterInRule = characterInRule;
    }


    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }

    public boolean isValidAccordingToFirstRule() {
        long numberOfSpecifiedLetter = passwordString.chars().filter((c) -> c == characterInRule).count();

        return (numberOfSpecifiedLetter >= firstFigureInRule && numberOfSpecifiedLetter <= secondFigureInRule);
    }

    public boolean isValidAccordingToSecondRule() {
        return charIsPresentOnlyAtFirstPosition() ||
                charIsPresentOnlyAtSecondPosition();
    }

    private boolean charIsPresentOnlyAtSecondPosition() {
        return passwordString.charAt(firstFigureInRule - 1) != characterInRule
                && passwordString.charAt(secondFigureInRule - 1) == characterInRule;
    }

    private boolean charIsPresentOnlyAtFirstPosition() {
        return passwordString.charAt(firstFigureInRule - 1) == characterInRule
                && passwordString.charAt(secondFigureInRule - 1) != characterInRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return firstFigureInRule == password.firstFigureInRule &&
                secondFigureInRule == password.secondFigureInRule &&
                characterInRule == password.characterInRule &&
                Objects.equals(passwordString, password.passwordString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstFigureInRule, secondFigureInRule, characterInRule, passwordString);
    }

    @Override
    public String toString() {
        return "Password{" +
                "minOccurrence=" + firstFigureInRule +
                ", maxOccurrence=" + secondFigureInRule +
                ", character=" + characterInRule +
                ", sequence='" + passwordString + '\'' +
                '}';
    }


}
