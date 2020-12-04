package adventOfCode.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<Passport> getPasswordList(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        Passport passport = new Passport();
        List<Passport> passportList = new ArrayList<>();


        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            if (!currentLine.isEmpty()) {
                passport = PassportMapper.setLineInfo(currentLine,passport);
            } else {
                passportList.add(passport);
                passport = new Passport();
            }
        }

        passportList.add(passport);

        return passportList;
    }
}
