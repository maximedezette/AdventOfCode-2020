package adventOfCode.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<BigInteger> get(String filePath) throws FileNotFoundException {
        List<BigInteger> inputs = new ArrayList<>();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            inputs.add(new BigInteger(sc.nextLine()));
        }
        return inputs;
    }
}
