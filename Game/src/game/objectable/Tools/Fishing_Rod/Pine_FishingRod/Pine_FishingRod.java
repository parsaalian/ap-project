package game.objectable.Tools.Fishing_Rod.Pine_FishingRod;

import game.objectable.Goods.Thread.Thread;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Tools.Fishing_Rod.Fishing_Rod;

public class Pine_FishingRod extends Fishing_Rod {
    {
        buildMoney = 100;
        repairMoney = 10;
        for(int i = 0; i < 6; i++) {
            needs.add(new Pine_Lumber());
        }
        for(int i = 0; i < 4; i++) {
            needs.add(new Thread());
        }
        for(int i = 0; i < 3; i++) {
            repairs.add(new Pine_Lumber());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Thread());
        }
    }

    public Pine_FishingRod() {
        super("Pine Fishing Rod");
        this.name = "Pine Fishing Rod";
        this.f = 100;
        this.changeEnergy = 10;
        this.p = 10;
    }
}
