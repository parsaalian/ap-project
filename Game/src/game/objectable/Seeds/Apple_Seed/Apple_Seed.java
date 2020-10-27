package game.objectable.Seeds.Apple_Seed;

import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;
import game.objectable.Seeds.Seeds;

public class Apple_Seed extends Seeds {
    public Apple_Seed() {
        super("Apple Seed");
        this.seed = new Apple();
        this.money = seed.money * 5;
    }
}
