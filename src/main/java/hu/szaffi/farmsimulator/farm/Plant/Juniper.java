package hu.szaffi.farmsimulator.farm.Plant;

public class Juniper extends Evergreen {

    public Juniper(String name) {
        super(name);
        this.production = 14;
    }

    @Override
    public int getMonthlyProduction(int actualMonth) {
        this.production += boostProduction(actualMonth);
        checkFullProduction();
        return production;
    }

    @Override
    int boostProduction(int actualMonth) {
        return monthlyProductionBoost + leafyProductionBoost(actualMonth);
    }


}
