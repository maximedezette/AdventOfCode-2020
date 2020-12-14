package adventOfCode.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static List<String> get(String path) throws FileNotFoundException {
        List<String> inputs = new ArrayList<>();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            inputs.add(sc.nextLine());
        }

        return inputs;
    }
}
