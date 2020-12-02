package adventOfCode.day2;

public class PasswordMapper {

    public static Password toPassword(String line){

        String[] splittedLine = line.split(" ");
        String[] splittedOccurences = splittedLine[0].split("-");
        Password password = new Password();
        password.setMinOccurrence(Integer.parseInt(splittedOccurences[0]));
        password.setMaxOccurrence(Integer.parseInt(splittedOccurences[1]));
        password.setCharacter(splittedLine[1].charAt(0));
        password.setSequence(splittedLine[2]);

        return password;
    }

}
