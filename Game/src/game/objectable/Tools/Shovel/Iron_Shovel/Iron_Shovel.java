package game.objectable.Tools.Shovel.Iron_Shovel;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Shovel.Shovel;

public class Iron_Shovel extends Shovel {
    {
        buildMoney = 500;
        repairMoney = 50;
        for(int i = 0; i < 4; i++) {
            needs.add(new Old_Lumber());
        }
        for(int i = 0; i < 4; i++) {
            needs.add(new Iron());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Old_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Iron());
        }
    }

    public Iron_Shovel() {
        super("Iron Shovel");
        this.name = "Iron Shovel";
        this.changeEnergy = -80;
        this.p = 15;
    }
}
