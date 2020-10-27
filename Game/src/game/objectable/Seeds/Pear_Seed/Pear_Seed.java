package game.objectable.Seeds.Pear_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Pear.Pear;
import game.objectable.Seeds.Seeds;

public class Pear_Seed extends Seeds {
    public Pear_Seed() {
        super("Pear Seed");
        this.seed = new Pear();
        this.money = seed.money * 5;
    }
}
