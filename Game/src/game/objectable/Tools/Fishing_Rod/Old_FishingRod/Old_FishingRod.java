package game.objectable.Tools.Fishing_Rod.Old_FishingRod;

import game.objectable.Goods.Thread.Thread;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Fishing_Rod.Fishing_Rod;

public class Old_FishingRod extends Fishing_Rod {
    {
        buildMoney = 300;
        repairMoney = 30;
        for(int i = 0; i < 10; i++) {
            needs.add(new Old_Lumber());
        }
        for(int i = 0; i < 3; i++) {
            needs.add(new Thread());
        }
        for(int i = 0; i < 4; i++) {
            repairs.add(new Old_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Thread());
        }
    }

    public Old_FishingRod() {
        super("Old Fishing Rod");
        this.name = "Old Fishing Rod";
        this.f = 60;
        this.changeEnergy = 40;
        this.p = 15;
    }
}
