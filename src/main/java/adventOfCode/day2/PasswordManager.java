package adventOfCode.day2;

import java.util.List;

public class PasswordManager {

    public int getNumberOfValidPasswordAccordingToFirstRule(List<Password> passwordList){
        int numberOfValidPassword = 0;
        for (Password password : passwordList) {
            if (password.isValidAccordingToFirstRule()) {
                numberOfValidPassword++;
            }
        }
        return numberOfValidPassword;
    }
    public int getNumberOfValidPasswordAccordingToSecondRule(List<Password> passwordList){
        int numberOfValidPassword = 0;
        for (Password password : passwordList) {
            if (password.isValidAccordingToSecondRule()) {
                numberOfValidPassword++;
            }
        }
        return numberOfValidPassword;
    }
}
