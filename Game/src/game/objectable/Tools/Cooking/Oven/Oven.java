package game.objectable.Tools.Cooking.Oven;

import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Cooking.Cooking;

public class Oven extends Cooking {
    {
        buildMoney = 0;
        for(int i = 0; i < 3; i++) {
            needs.add(new Adamantium());
        }
        for(int i = 0; i < 3; i++) {
            needs.add(new Oak_Lumber());
        }
    }

    public Oven(String name, String type) {
        super(name, type);
        this.name = "Oven";
    }

    public Oven() {
        super("Oven", "Oven");
        this.name = "Oven";
    }
}
