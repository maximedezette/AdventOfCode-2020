package adventOfCode.day9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XMASManager {

    private int preambleSize;
    private List<BigInteger> preambles;
    private List<BigInteger> numbers;
    private List<BigInteger> sumsOfThePreambles;
    private List<BigInteger> inputs;
    int cursor = 0;

    public XMASManager(int preambleSize, List<BigInteger> inputs) {
        this.preambleSize = preambleSize;
        this.preambles = inputs.subList(0,preambleSize);
        this.numbers = inputs.subList(preambleSize,inputs.size());
        this.sumsOfThePreambles = getTheSumsOfThePreambles();
        this.inputs = inputs;
    }

    private List<BigInteger> getTheSumsOfThePreambles() {
        List<BigInteger> sums = new ArrayList<>();
        for (BigInteger preamble1: preambles){
            for(BigInteger preamble2: preambles){
                if(preamble1 != preamble2){
                    sums.add(preamble1.add(preamble2));
                }
            }
        }

        return sums;
    }

    public BigInteger getNumberNotFollowingTheRule() {
        for(BigInteger number: numbers){
            if(!sumsOfThePreambles.contains(number)){
                return number;
            }
            cursor++;
            preambles = this.inputs.subList(cursor, preambleSize + cursor);
            sumsOfThePreambles = getTheSumsOfThePreambles();
        }
        return new BigInteger("");
    }

    public List<BigInteger> getContiguousSet(BigInteger invalidNumber) {
        List<BigInteger> contiguousList = new ArrayList<>();

        for(int i =0; i< inputs.size(); i++){
            contiguousList.clear();
            BigInteger sum = new BigInteger("0");
            int j = i;
            while (shouldSumNextNumber(invalidNumber, sum, j)){
                contiguousList.add(inputs.get(j));
                sum = sum.add(inputs.get(j));
                j++;
            }

            if(sum.compareTo(invalidNumber) == 0){
                return contiguousList;
            }
        }
        return contiguousList;
    }

    private boolean shouldSumNextNumber(BigInteger invalidNumber, BigInteger sum, int j) {
        return sum.compareTo(invalidNumber) < 0 && j < inputs.size() && inputs.get(j).compareTo(invalidNumber) != 0;
    }

    public BigInteger getSumOfExtremaContiguousList(BigInteger invalidNumber){
        List<BigInteger> contiguousList = getContiguousSet(invalidNumber);
        return Collections.min(contiguousList).add(Collections.max(contiguousList));
    }
}
