package adventOfCode.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * If we want to be more generic with a variable number of entries to sum
     * @param entries
     * @param numberOfFigureWeWantToSum
     * @return
     */
    public int getMultiplicationSumOfN(List<Integer> entries, int numberOfFigureWeWantToSum) {

        Map<Integer, Integer> processedMap =  initProcessedMap(entries);

        for (int i = 0; i < (numberOfFigureWeWantToSum - 1); i++) {
            processedMap  = getNextMap(entries, processedMap);
        }

        return getMultiplicationValue(processedMap);
    }

    private  Map<Integer, Integer> getNextMap(List<Integer> entries, Map<Integer, Integer> processedMap) {

        Map<Integer, Integer> tempMap = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : processedMap.entrySet()) {
            Integer distanceTo2020 = entry.getKey();
            Integer currentMultiplication = entry.getValue();
            for (Integer initialEntryValue : entries) {
                if ( distanceTo2020 - initialEntryValue >= 0) {
                    tempMap.put(distanceTo2020 - initialEntryValue, currentMultiplication * initialEntryValue);
                }
            }
        }
        return tempMap;
    }

    private int getMultiplicationValue(Map<Integer, Integer> processedMap) {
        for (Map.Entry<Integer, Integer> entry : processedMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key == 0){
                return value;
            }
        }
      return 0;
    }

    private Map<Integer, Integer> copyMap(Map<Integer, Integer> tempMap) {
        Map<Integer, Integer> processedMap = new HashMap<>();
        processedMap.putAll(tempMap);
        return processedMap;
    }

    private boolean lastTurnAndSumEqual2020(int n, int i, Integer key, Integer firstEntry) {
        return i == (n-2) && key - firstEntry == 0;
    }

    private Map<Integer, Integer> initProcessedMap(List<Integer> entries) {
        Map<Integer, Integer> processedMap = new HashMap<>();
        for (Integer firstEntry : entries) {
            processedMap.put(2020 - firstEntry, firstEntry);
        }
        return processedMap;
    }
}
