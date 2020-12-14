package adventOfCode.day10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdapterManager {

    private List<Adapter> adapters;
    int jolt = 0;

    public AdapterManager(List<Adapter> adapters) {
        this.adapters = adapters;
    }

    private List<Adapter> addBuiltInAdapter(List<Adapter> adapters) {
        int higherJolt = adapters.get(adapters.size() - 1).getJoltage();
        adapters.add(new Adapter(higherJolt + 3));
        return adapters;
    }

    public int calculateDifferences() {

        int numberOfOneDifferences = 0;
        int numberOfThreeDifferences = 0;
        addBuiltInAdapter(adapters);

        for (int i = 0; i < adapters.size(); i++) {
            if (adapters.get(i).canConnect(jolt)) {
                if (adapters.get(i).getDifference(jolt) == 1) {
                    numberOfOneDifferences++;
                } else if (adapters.get(i).getDifference(jolt) == 3) {
                    numberOfThreeDifferences++;
                }
                jolt = adapters.get(i).getJoltage();
            }
        }


        return numberOfOneDifferences * (numberOfThreeDifferences);
    }

    public BigInteger getPossibleArrangements() {
/*        addBuiltInAdapter(adapters);
        jolt = 0;
        BigInteger possiblePaths = BigInteger.valueOf(1);
        for (int i = 0; i < adapters.size(); i++) {
            int numberOfAdaptersThatCanConnect = adaptersThatCanConnect(adapters.get(i).getJoltage()).size();
            if (numberOfAdaptersThatCanConnect > 1) {
                if (numberOfAdaptersThatCanConnect == 3) {
                    possiblePaths = possiblePaths.add(BigInteger.valueOf(4));
                } else if (numberOfAdaptersThatCanConnect == 2) {
                    possiblePaths = possiblePaths.add(BigInteger.valueOf(3));

                }
            }

        }*/


      addBuiltInAdapter(adapters);
        jolt = 0;
        int maxJolt = adapters.get(adapters.size() -1).getJoltage();
        BigInteger possiblePaths = BigInteger.valueOf(1);
        while (jolt < maxJolt){
            List<Adapter> suitableAdapters = adaptersThatCanConnect(jolt);

            if(suitableAdapters.size() == 1){
                jolt = suitableAdapters.get(suitableAdapters.size() -1).getJoltage();
                adapters.removeAll(suitableAdapters);
            }else if(suitableAdapters.size() > 1){
                suitableAdapters = getSequence(jolt);
                jolt = suitableAdapters.get(suitableAdapters.size() -1).getJoltage();
                possiblePaths = possiblePaths.multiply(new BigInteger(String.valueOf(possibleCombinaisons(suitableAdapters))));
                adapters.removeAll(suitableAdapters);
            }
        }
        return possiblePaths;
    }

/*    private int getNumberOfValuesThatCanConnect(int i) {
        int numberOfAdaptersThatCanConnect = 0;
        for(int j = i; j < i+3; j++){
            if()
        }
        return 0;
    }*/

    private List<Adapter> adaptersThatCanConnect(int jolt) {
        List<Adapter> adaptersThatCanConnect = new ArrayList<>();
        for (Adapter adapter : adapters) {
            if (adapter.canConnect(jolt)) {
                adaptersThatCanConnect.add(adapter);
            }
        }
        return adaptersThatCanConnect;
    }

    private List<Adapter> getSequence(int jolt){
        int currentJolt = jolt;
        List<Adapter> adaptersThatCanConnect = new ArrayList<>();
        for (Adapter adapter : adapters) {
            if (adapter.getJoltage() > currentJolt  && adapter.getJoltage() <= currentJolt + 2  ) {
                adaptersThatCanConnect.add(adapter);
                currentJolt = adapter.getJoltage();
            }
        }
        return adaptersThatCanConnect;
    }

    public int possibleCombinaisons(List<Adapter> adapters) {
        int possibleCombinaisons = 0;
        for (int i = 0; i < adapters.size(); i++) {
            for (int j = 0; j < adapters.size(); j++) {
                if (i != j && adapters.get(i).canConnect(adapters.get(j).getJoltage())) {
                    possibleCombinaisons++;
                }
            }

        }
        return possibleCombinaisons + 1;
    }

    public int getJolt() {
        return this.jolt;
    }
}
