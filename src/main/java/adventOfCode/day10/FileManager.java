package adventOfCode.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static List<Adapter> get(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        List<Adapter> adapters = new ArrayList<>();

        while (sc.hasNext()){
            String line = sc.nextLine();
            adapters.add(new Adapter(Integer.parseInt(line)));
        }
        Collections.sort(adapters);
        return adapters;
    }
}
