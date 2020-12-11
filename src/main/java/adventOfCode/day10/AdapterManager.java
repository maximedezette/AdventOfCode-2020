package adventOfCode.day10;

import java.util.List;

public class AdapterManager {

    private List<Adapter> adapters;
    int jolt = 0;

    public AdapterManager(List<Adapter> adapters) {
        this.adapters = addBuiltInAdapter(adapters);
    }

    private List<Adapter> addBuiltInAdapter(List<Adapter> adapters) {
        int higherJolt = adapters.get(adapters.size() - 1).getJoltage();
        adapters.add(new Adapter(higherJolt + 3));
        return adapters;
    }

    public int calculateDifferences() {

        int numberOfOneDifferences = 0;
        int numberOfThreeDifferences = 0;

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
}
