package game.objectable.Tools.Shovel.Stone_Shovel;

import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Tools.Shovel.Shovel;

public class Stone_Shovel extends Shovel {
    {
        buildMoney = 100;
        repairMoney = 10;
        for(int i = 0; i < 5; i++) {
            needs.add(new Branch());
        }
        for(int i = 0; i < 5; i++) {
            needs.add(new Gravel());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Branch());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Gravel());
        }
    }

    public Stone_Shovel() {
        super("Stone Shovel");
        this.name = "Stone Shovel";
        this.changeEnergy = -150;
        this.p = 20;
    }
}
