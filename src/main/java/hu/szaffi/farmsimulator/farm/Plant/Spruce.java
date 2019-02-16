package hu.szaffi.farmsimulator.farm.Plant;

public class Spruce extends Evergreen implements HaveScroom {
    private int chanceToScroom = 5;
    private int chanceToRoot = 4;
    private int monthlyProdWithSchroom = 19;


    public Spruce(String name) {
        super(name);
        this.production = 26;
    }

    @Override
    public int SchroomBoost(int chance) {
        return (hasChance(chance) ? 15 : 0);
    }

    @Override
    public int rottenReduceProd(int chance) {
        return (hasChance(chance) ? -20 : 0);
    }

    @Override
    public int getMonthlyProduction(int actualMonth) {
        if (boostProduction(actualMonth) == monthlyProdWithSchroom) {
            this.production += monthlyProdWithSchroom + leafyProductionBoost(actualMonth);
            checkFullProduction();
            return production;
        } else {
            if (rottenReduceProd(chanceToRoot) == -20) {
                this.production += rottenReduceProd(chanceToRoot) + leafyProductionBoost(actualMonth);
                return 0;
            } else {
                this.production += monthlyProductionBoost + leafyProductionBoost(actualMonth);
                checkFullProduction();
                return production;
            }
        }
    }

    @Override
    int boostProduction(int actualMonth) {
        return monthlyProductionBoost + SchroomBoost(chanceToScroom);
    }

}
