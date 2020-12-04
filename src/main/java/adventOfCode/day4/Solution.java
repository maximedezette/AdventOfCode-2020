package adventOfCode.day4;

import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\day4\\entries.txt";

    public static void main(String[] args) throws Exception {

        FileManager fileManager = new FileManager();
        List<Passport> passportList = fileManager.getPasswordList(FILE_PATH);
        PassportManager passportManager = new PassportManager();

        System.out.println(passportManager.countValidPassword(passportList));

    }
}
