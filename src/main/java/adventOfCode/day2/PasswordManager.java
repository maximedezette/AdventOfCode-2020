package adventOfCode.day2;

import java.util.List;

public class PasswordManager {

    public int getNumberOfValidPassword(List<Password> passwordList){
        int numberOfValidPassword = 0;
        for (Password password : passwordList) {
            if (password.isValidAccordingToFirstRule()) {
                numberOfValidPassword++;
            }
        }
        return numberOfValidPassword;
    }
}
