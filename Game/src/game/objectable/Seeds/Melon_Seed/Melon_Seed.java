package game.objectable.Seeds.Melon_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Melon.Melon;
import game.objectable.Seeds.Seeds;

public class Melon_Seed extends Seeds {
    public Melon_Seed() {
        super("Melon Seed");
        this.seed = new Melon();
        this.money = seed.money * 5;
    }
}
