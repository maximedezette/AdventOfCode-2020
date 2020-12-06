package adventOfCode.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<String> get(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<String> entries = new ArrayList<>();
        while (sc.hasNext()){
            entries.add(sc.nextLine());
        }

        return entries;
    }
}
