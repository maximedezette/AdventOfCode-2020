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
        while (sc.hasNextLine()){
            String currentLine = sc.nextLine();
            if(!currentLine.isEmpty()){
                answers = addStringWihoutDuplicateChats(answers,currentLine);
            }else{
                entries.add(answers);
                answers = "";
            }
        }

        if(!answers.isEmpty()){
            entries.add(answers);
        }

        return entries;
    }

    private String addStringWihoutDuplicateChats(String line, String lineToAdd) {
        String updatedLine = line;
        for(int i=0; i<lineToAdd.length();i++){
            if(!line.contains((String.valueOf(lineToAdd.charAt(i))))){
                updatedLine += String.valueOf(lineToAdd.charAt(i));
            }
        }

        return updatedLine;
    }
}
