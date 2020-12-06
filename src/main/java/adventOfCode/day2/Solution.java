package adventOfCode.day2;

import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode.day2\\entries.txt";

    public static void main(String[] args) throws Exception {

        FileManager fileManager = new FileManager();
        List<Password> passwordList = fileManager.getEntries(FILE_PATH);
        PasswordManager passwordManager = new PasswordManager();

        // part 1
        System.out.println(passwordManager.getNumberOfValidPasswordAccordingToFirstRule(passwordList));

        // part 2
        System.out.println(passwordManager.getNumberOfValidPasswordAccordingToSecondRule(passwordList));

    }
}
