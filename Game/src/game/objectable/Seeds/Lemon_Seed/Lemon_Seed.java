package game.objectable.Seeds.Lemon_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Lemon.Lemon;
import game.objectable.Seeds.Seeds;

public class Lemon_Seed extends Seeds {
    public Lemon_Seed() {
        super("Lemon Seed");
        this.seed = new Lemon();
        this.money = seed.money * 5;
    }
}
