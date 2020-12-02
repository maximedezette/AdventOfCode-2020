package adventOfCode.day1;

import java.util.List;

public class ExpenseCalculator {



    public int getMultiplicationSumOfTwo(List<Integer> entries) {
        int result = 0;
        for (Integer entry : entries) {
            for (Integer otherEntry : entries) {
                if (entry + otherEntry == 2020) {
                    result = entry * otherEntry;
                }
            }
        }
        return result;
    }

    public int getMultiplicationSumOfThree(List<Integer> entries) {
        int result = 0;
        for (Integer firstEntry : entries) {
            for (Integer secondEntry : entries) {
                for (Integer thirdEntry : entries) {
                    if (firstEntry + secondEntry + thirdEntry == 2020) {
                        result = firstEntry * secondEntry * thirdEntry;
                    }
                }
            }
        }
        return result;
    }
}
