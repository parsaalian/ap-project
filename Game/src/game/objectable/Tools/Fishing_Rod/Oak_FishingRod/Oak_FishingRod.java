package game.objectable.Tools.Fishing_Rod.Oak_FishingRod;

import game.objectable.Goods.Thread.Thread;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Fishing_Rod.Fishing_Rod;

public class Oak_FishingRod extends Fishing_Rod {
    {
        buildMoney = 2000;
        repairMoney = 200;
        for(int i = 0; i < 3; i++) {
            needs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 5; i++) {
            needs.add(new Thread());
        }
        for(int i = 0; i < 3; i++) {
            repairs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 5; i++) {
            repairs.add(new Thread());
        }
    }

    public Oak_FishingRod() {
        super("Oak Fishing Rod");
        this.name = "Oak Fishing Rod";
        this.f = 80;
        this.changeEnergy = 20;
        this.p = 5;
    }
}
