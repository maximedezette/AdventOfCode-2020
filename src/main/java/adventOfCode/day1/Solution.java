package adventOfCode.day1;

import java.util.List;

public class Solution {

    public static final String FILE_PATH = "C:\\Users\\mdeze\\Documents\\Projets\\advent-of-code\\src\\main\\resources\\day1\\entries.txt";

    public static void main(String[] args) throws Exception {

        FileManager fileManager = new FileManager();
        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        List<Integer> entries = fileManager.getEntries(FILE_PATH);
        System.out.println(expenseCalculator.getMultiplicationSumOfN(entries,3));


    }
}
