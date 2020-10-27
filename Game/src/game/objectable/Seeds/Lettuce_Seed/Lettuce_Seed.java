package game.objectable.Seeds.Lettuce_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Lettuce.Lettuce;
import game.objectable.Seeds.Seeds;

public class Lettuce_Seed extends Seeds {
    public Lettuce_Seed() {
        super("Lettuce Seed");
        this.seed = new Lettuce();
        this.money = seed.money * 5;
    }
}
