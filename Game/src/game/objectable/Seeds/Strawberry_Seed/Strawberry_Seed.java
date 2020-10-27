package game.objectable.Seeds.Strawberry_Seed;

import game.objectable.Fruits_and_Vegs.Tropical.Strawberry.Strawberry;
import game.objectable.Seeds.Seeds;

public class Strawberry_Seed extends Seeds {
    public Strawberry_Seed() {
        super("Strawberry Seed");
        this.seed = new Strawberry();
        this.money = seed.money * 5;
    }
}
