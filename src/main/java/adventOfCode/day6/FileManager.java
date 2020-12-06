package adventOfCode.day6;

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

        String answers = "";
        int groupSize = 0;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            if (!currentLine.isEmpty()) {
                groupSize++;
                answers += currentLine;

            } else {
                answers = keepOnlyUnanimousAnswers(answers,groupSize);
                entries.add(answers);
                answers = "";
                groupSize = 0;
            }

        }

        if (!answers.isEmpty()) {
            answers = keepOnlyUnanimousAnswers(answers,groupSize);
            entries.add(answers);
        }

        return entries;
    }
    private String keepOnlyUnanimousAnswers(String answers, int groupSize) {
        String unanimousAnswers = "";
        for (int i = 0; i < answers.length(); i++) {
            int finalI = i;
            if(answers.chars()
                    .filter(c -> c == answers.charAt(finalI))
                    .count() == groupSize){
                unanimousAnswers = addWithoutDuplicates(unanimousAnswers, String.valueOf( answers.charAt(finalI)));
            }
        }


        return unanimousAnswers;
    }

    private String addWithoutDuplicates(String line, String lineToAdd) {
        String updatedLine = line;
        for (int i = 0; i < lineToAdd.length(); i++) {
            if (!line.contains((String.valueOf(lineToAdd.charAt(i))))) {
                updatedLine += String.valueOf(lineToAdd.charAt(i));
            }
        }

        return updatedLine;
    }


}
