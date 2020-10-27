package game.objectable.Seeds.Tomato_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;
import game.objectable.Seeds.Seeds;

public class Tomato_Seed extends Seeds {
    public Tomato_Seed() {
        super("Tomato Seed");
        this.seed = new Tomato();
        this.money = seed.money * 5;
    }
}
