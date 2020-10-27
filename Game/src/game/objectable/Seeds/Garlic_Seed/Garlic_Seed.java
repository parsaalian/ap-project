package game.objectable.Seeds.Garlic_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Garlic.Garlic;
import game.objectable.Seeds.Seeds;

public class Garlic_Seed extends Seeds {
    public Garlic_Seed() {
        super("Garlic Seed");
        this.seed = new Garlic();
        this.money = seed.money * 5;
    }
}
