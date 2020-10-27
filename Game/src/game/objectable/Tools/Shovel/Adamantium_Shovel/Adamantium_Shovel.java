package game.objectable.Tools.Shovel.Adamantium_Shovel;

import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Shovel.Shovel;

public class Adamantium_Shovel extends Shovel {
    {
        buildMoney = 4000;
        repairMoney = 400;
        for(int i = 0; i < 2; i++) {
            needs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            needs.add(new Adamantium());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Adamantium());
        }
    }

    public Adamantium_Shovel() {
        super("Adamantium Shovel");
        this.name = "Adamantium Shovel";
        this.changeEnergy = -20;
        this.p = 5;
    }
}
