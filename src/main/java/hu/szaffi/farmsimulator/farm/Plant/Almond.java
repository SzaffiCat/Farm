package hu.szaffi.farmsimulator.farm.Plant;

public class Almond extends Plant implements HaveScroom {
    private int chanceToScroom = 8;
    private int chanceToRoot = 13;
    private int monthlyProdWithSchroom = 14;


    public Almond(String name) {
        super(name);
        this.production = 50;
    }

    @Override
    public int SchroomBoost(int chance) {
        return (hasChance(chance) ? 10 : 0);
    }

    @Override
    public int rottenReduceProd(int chance) {
        return (hasChance(chance) ? -18 : 0);
    }

    @Override
    public int getMonthlyProduction(int actualMonth) {
        int boostProduction = boostProduction(actualMonth);
        if (boostProduction == monthlyProdWithSchroom) {
            this.production += monthlyProdWithSchroom;
            checkProduction();
            return production;
        } else {
            int rottenReduceProd = rottenReduceProd(chanceToRoot);
            if (rottenReduceProd == -18) {
                this.production += rottenReduceProd;
                return 0;
            } else {
                this.production += monthlyProductionBoost;
                checkProduction();
                return production;
            }
        }
    }

    @Override
    int boostProduction(int actualMonth) {
        return monthlyProductionBoost + SchroomBoost(chanceToScroom);
    }

    private void checkProduction() {
        if (production < 40) {
            this.production = production*2;
        }
        System.out.println(name + ": " + production);

    }

}
