package game.objectable.Seeds.Bean_Seed;

import game.objectable.Fruits_and_Vegs.Spring.Bean.Bean;
import game.objectable.Seeds.Seeds;

public class Bean_Seed extends Seeds {
    public Bean_Seed() {
        super("Bean Seed");
        this.seed = new Bean();
        this.money = seed.money * 5;
    }
}
