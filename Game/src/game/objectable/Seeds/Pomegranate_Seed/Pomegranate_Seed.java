package game.objectable.Seeds.Pomegranate_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Pomegranate.Pomegranate;
import game.objectable.Seeds.Seeds;

public class Pomegranate_Seed extends Seeds {
    public Pomegranate_Seed() {
        super("Pomegranate Seed");
        this.seed = new Pomegranate();
        this.money = seed.money * 5;
    }
}
