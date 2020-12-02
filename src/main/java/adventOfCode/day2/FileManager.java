package adventOfCode.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<Password> getEntries(String filePath) throws FileNotFoundException {

        List<Password> entries = new ArrayList<>();

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            entries.add(PasswordMapper.toPassword(sc.nextLine()));
        }

        return entries;
    }
}
