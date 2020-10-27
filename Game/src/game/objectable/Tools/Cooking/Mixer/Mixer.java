package game.objectable.Tools.Cooking.Mixer;

import game.objectable.Goods.Stone.Silver.Silver;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Tools.Cooking.Cooking;

public class Mixer extends Cooking {
    {
        buildMoney = 0;
        for(int i = 0; i < 5; i++) {
            needs.add(new Silver());
        }
        for(int i = 0; i < 3; i++) {
            needs.add(new Pine_Lumber());
        }
    }

    public Mixer(String name, String type) {
        super(name, type);
        this.name = "Mixer";
    }

    public Mixer() {
        super("Mixer", "Mixer");
        this.name = "Mixer";
    }
}
