package game.objectable.Tools.Fishing_Rod.Small_FishingRod;

import game.objectable.Goods.Thread.Thread;
import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Tools.Fishing_Rod.Fishing_Rod;

public class Small_FishingRod extends Fishing_Rod {
    {
        buildMoney = 100;
        repairMoney = 10;
        for(int i = 0; i < 15; i++) {
            needs.add(new Branch());
        }
        for(int i = 0; i < 2; i++) {
            needs.add(new Thread());
        }
        for(int i = 0; i < 5; i++) {
            repairs.add(new Branch());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Thread());
        }
    }

    public Small_FishingRod() {
        super("Small Fishing Rod");
        this.name = "Small Fishing Rod";
        this.f = 40;
        this.changeEnergy = 80;
        this.p = 20;
    }
}
