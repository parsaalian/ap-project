package game.objectable.Tools.Cooking.Knife;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Cooking.Cooking;

public class Knife extends Cooking {
    {
        buildMoney = 0;
        for(int i = 0; i < 3; i++) {
            needs.add(new Iron());
        }
        for(int i = 0; i < 2; i++) {
            needs.add(new Old_Lumber());
        }
    }

    public Knife(String name, String type) {
        super(name, type);
        this.name = "Knife";
    }

    public Knife() {
        super("Knife", "Knife");
        this.name = "Knife";
    }
}
