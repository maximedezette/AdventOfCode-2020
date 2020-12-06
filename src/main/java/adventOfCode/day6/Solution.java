package adventOfCode.day6;

import java.io.FileNotFoundException;
import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\adventOfCode\\day6\\entries.txt";

    public static void main(String args[]) throws FileNotFoundException {
        int count = 0;
        FileManager fileManager = new FileManager();
        List<String> entries = fileManager.get(FILE_PATH);
        AnswerManager answerManager = new AnswerManager();
        System.out.println(answerManager.getAmountOfUnanimousAnswer(entries));
    }
}
