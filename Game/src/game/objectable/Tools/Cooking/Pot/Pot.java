package game.objectable.Tools.Cooking.Pot;

import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Tools.Cooking.Cooking;

public class Pot extends Cooking {
    {
        buildMoney = 0;
        for(int i = 0; i < 10; i++) {
            needs.add(new Gravel());
        }
    }

    public Pot(String name, String type) {
        super(name, type);
        this.name = "Pot";
    }

    public Pot() {
        super("Pot", "Pot");
        this.name = "Pot";
    }
}
