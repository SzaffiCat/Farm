package hu.szaffi.farmsimulator.farm.Plant;

public abstract class Plant {

    protected int production;
    protected final int monthlyProductionBoost = 4;
    String name;

    public Plant(String name) {
        this.name = name;
    }

    public abstract int getMonthlyProduction(int actualMonth);

    abstract int boostProduction(int actualMonth);

    boolean hasChance(int chance) {
        double randomNumber = Math.random() * 100;
        return (randomNumber <= chance);
    }

    public String getName() {
        return name;
    }
}
