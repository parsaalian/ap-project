package game.objectable.Seeds.Orange_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Orange.Orange;
import game.objectable.Seeds.Seeds;

public class Orange_Seed extends Seeds {
    public Orange_Seed() {
        super("Orange Seed");
        this.seed = new Orange();
        this.money = seed.money * 5;
    }
}
