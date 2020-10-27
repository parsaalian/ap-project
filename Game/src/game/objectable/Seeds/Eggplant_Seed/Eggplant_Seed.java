package game.objectable.Seeds.Eggplant_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Eggplant.Eggplant;
import game.objectable.Seeds.Seeds;

public class Eggplant_Seed extends Seeds {
    public Eggplant_Seed() {
        super("Eggplant Seed");
        this.seed = new Eggplant();
        this.money = seed.money * 5;
    }
}
