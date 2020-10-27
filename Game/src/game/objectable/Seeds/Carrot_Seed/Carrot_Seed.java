package game.objectable.Seeds.Carrot_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Carrot.Carrot;
import game.objectable.Seeds.Seeds;

public class Carrot_Seed extends Seeds {
    public Carrot_Seed() {
        super("Carrot Seed");
        this.seed = new Carrot();
        this.money = seed.money * 5;
    }
}
