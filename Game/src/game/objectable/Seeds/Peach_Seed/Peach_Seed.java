package game.objectable.Seeds.Peach_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Peach.Peach;
import game.objectable.Seeds.Seeds;

public class Peach_Seed extends Seeds {
    public Peach_Seed() {
        super("Peach Seed");
        this.seed = new Peach();
        this.money = seed.money * 5;
    }
}
