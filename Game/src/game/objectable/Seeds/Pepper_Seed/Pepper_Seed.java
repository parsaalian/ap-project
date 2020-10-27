package game.objectable.Seeds.Pepper_Seed;

import game.objectable.Fruits_and_Vegs.Tropical.Pepper.Pepper;
import game.objectable.Seeds.Seeds;

public class Pepper_Seed extends Seeds {
    public Pepper_Seed() {
        super("Pepper Seed");
        this.seed = new Pepper();
        this.money = seed.money * 5;
    }
}
