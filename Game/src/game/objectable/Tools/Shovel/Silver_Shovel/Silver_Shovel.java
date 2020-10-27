package game.objectable.Tools.Shovel.Silver_Shovel;

import game.objectable.Goods.Stone.Silver.Silver;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Tools.Shovel.Shovel;

public class Silver_Shovel extends Shovel {
    {
        buildMoney = 1000;
        repairMoney = 100;
        for (int i = 0; i < 3; i++) {
            needs.add(new Pine_Lumber());
        }
        for (int i = 0; i < 3; i++) {
            needs.add(new Silver());
        }
        for (int i = 0; i < 1; i++) {
            repairs.add(new Pine_Lumber());
        }
        for (int i = 0; i < 1; i++) {
            repairs.add(new Silver());
        }
    }

    public Silver_Shovel() {
        super("Silver Shovel");
        this.name = "Silver Shovel";
        this.changeEnergy = -40;
        this.p = 10;
    }
}
