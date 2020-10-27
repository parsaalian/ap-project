package game.objectable.Seeds.Potato_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Potato.Potato;
import game.objectable.Seeds.Seeds;

public class Potato_Seed extends Seeds {
    public Potato_Seed() {
        super("Potato Seed");
        this.seed = new Potato();
        this.money = seed.money * 5;
    }
}
