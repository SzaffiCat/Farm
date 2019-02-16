package hu.szaffi.farmsimulator.farm;

import hu.szaffi.farmsimulator.farm.Plant.*;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private List<Plant> allPlants = new ArrayList<>();

    public void simulateMonthlyProduction(int actualMonth) {
        int totalFoodProduced = 0;
        for (Plant plant :
                allPlants) {
            int monthlyProduction = plant.getMonthlyProduction(actualMonth);
            if (monthlyProduction == 0) {
                totalFoodProduced = 0;
                System.out.println(plant.getName() + " is rotten :(");
                break;
            } else {
                totalFoodProduced = monthlyProduction + totalFoodProduced;
            }
        }
        System.out.println("TotalFood: " + totalFoodProduced);
    }

    public void initPlants() {
        for (int i = 0; i < 2; i++) {
            Juniper juniper = new Juniper("Juniper");
            allPlants.add(juniper);
        }
        for (int i = 0; i < 2; i++) {
            Almond almond = new Almond("Almond");
            allPlants.add(almond);
        }
        for (int i = 0; i < 2; i++) {
            Spruce spruce = new Spruce("Spruce");
            allPlants.add(spruce);
        }


    }
}
