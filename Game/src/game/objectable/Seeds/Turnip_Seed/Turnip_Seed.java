package game.objectable.Seeds.Turnip_Seed;

import game.objectable.Fruits_and_Vegs.Summer.Turnip.Turnip;
import game.objectable.Seeds.Seeds;

public class Turnip_Seed extends Seeds {
    public Turnip_Seed() {
        super("Turnip Seed");
        this.seed = new Turnip();
        this.money = seed.money * 5;
    }
}
