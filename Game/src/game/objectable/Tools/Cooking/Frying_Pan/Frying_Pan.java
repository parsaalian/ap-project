package game.objectable.Tools.Cooking.Frying_Pan;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Tools.Cooking.Cooking;

public class Frying_Pan extends Cooking {
    {
        buildMoney = 0;
        for(int i = 0; i < 7; i++) {
            needs.add(new Iron());
        }
    }

    public Frying_Pan(String name, String type) {
        super(name, type);
        this.name = "Frying Pan";
    }

    public Frying_Pan() {
        super("Frying Pan", "Frying Pan");
        this.name = "Frying Pan";
    }
}
