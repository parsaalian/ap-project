package game.objectable.Seeds.Cucumber_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Cucumber.Cucumber;
import game.objectable.Seeds.Seeds;

public class Cucumber_Seed extends Seeds {
    public Cucumber_Seed() {
        super("Cucumber Seed");
        this.seed = new Cucumber();
        this.money = seed.money * 5;
    }
}
