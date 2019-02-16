package hu.szaffi.farmsimulator.farm.Plant;

public abstract class Evergreen extends Plant {
    final int maxProduction = 70;

    public Evergreen(String name) {
        super(name);
    }

    void checkFullProduction() {
        if (production >= maxProduction) {
            this.production = maxProduction;
            System.out.println(name + "- full production!");
        } else {
            System.out.println(name + ": " + production);
        }

    }

    int leafyProductionBoost(int actualMonth) {
        return (actualMonth % 5 == 0 ? 8 : 0);
    }


}
