package adventOfCode.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> getEntries(String filePath) throws FileNotFoundException {

        List<String> entries = new ArrayList<>();

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            entries.add(sc.nextLine());
        }

        return entries;
    }
}
