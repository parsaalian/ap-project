package game.objectable.Seeds.Onion_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Onion.Onion;
import game.objectable.Seeds.Seeds;

public class Onion_Seed extends Seeds {
    public Onion_Seed() {
        super("Onion Seed");
        this.seed = new Onion();
        this.money = seed.money * 5;
    }
}
