package hu.szaffi.farmsimulator;

import hu.szaffi.farmsimulator.farm.Farm;

public class Mars {
    public static void main(String[] args) {
        Farm marsFarm = new Farm();
        int testMonths = 80;
        marsFarm.initPlants();
        for (int actualMonth = 1; actualMonth < testMonths; actualMonth++) {
            marsFarm.simulateMonthlyProduction(actualMonth);
        }
    }
}
