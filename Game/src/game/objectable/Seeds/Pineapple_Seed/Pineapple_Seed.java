package game.objectable.Seeds.Pineapple_Seed;

import game.objectable.Fruits_and_Vegs.Tropical.Pineapple.Pineapple;
import game.objectable.Seeds.Seeds;

public class Pineapple_Seed extends Seeds {
    public Pineapple_Seed() {
        super("Pineapple Seed");
        this.seed = new Pineapple();
        this.money = seed.money * 5;
    }
}
