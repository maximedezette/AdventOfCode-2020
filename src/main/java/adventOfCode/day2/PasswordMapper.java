package adventOfCode.day2;

public class PasswordMapper {

    public static Password toPassword(String line){

        String[] splittedLine = line.split(" ");
        String[] splittedOccurences = splittedLine[0].split("-");
        Password password = new Password();

        int firstFigure = Integer.parseInt(splittedOccurences[0]);
        int secondFigure = Integer.parseInt(splittedOccurences[1]);

        password.setFirstFigureInRule(firstFigure);
        password.setSecondFigureInRule(secondFigure);
        password.setCharacterInRule(splittedLine[1].charAt(0));
        password.setPasswordString(splittedLine[2]);

        return password;
    }

}
