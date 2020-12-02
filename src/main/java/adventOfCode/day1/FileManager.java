package adventOfCode.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<Integer> getEntries(String filePath) throws FileNotFoundException {

        List<Integer> entries = new ArrayList<>();

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            entries.add(Integer.parseInt(sc.nextLine()));
        }

        return entries;
    }
}
