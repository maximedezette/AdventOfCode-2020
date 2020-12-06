package adventOfCode.day5;

import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\day5\\entries";

    public static void main(String[] args) throws Exception {
        int maxSeatId = 0;
        FileManager fileManager = new FileManager();
        List<String> boardingPasses = fileManager.get(FILE_PATH);
        BoardingPassManager boardingPassManager = new BoardingPassManager();
        for (String boardingPass: boardingPasses) {
            int currentSeatId = boardingPassManager.getSeatId(boardingPass);
            if(currentSeatId > maxSeatId){
                maxSeatId = currentSeatId;
            }
        }
        System.out.println(maxSeatId);
    }
}
