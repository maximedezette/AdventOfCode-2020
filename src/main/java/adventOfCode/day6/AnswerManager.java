package adventOfCode.day6;

import java.util.List;

public class AnswerManager {
    public int getAmountOfUnanimousAnswer(List<String> entries) {
        int count = 0;
        for(String entry: entries){
            count += entry.length();
        }

        return count;
    }


}
