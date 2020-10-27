package game.objectable.Seeds.Watermelon_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Watermelon.Watermelon;
import game.objectable.Seeds.Seeds;

public class Watermelon_Seed extends Seeds {
    public Watermelon_Seed() {
        super("Watermelon Seed");
        this.seed = new Watermelon();
        this.money = seed.money * 5;
    }
}
