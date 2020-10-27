package game.objectable.Tools.Pickax.Stone_Piackax;

import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Tools.Pickax.Pickax;

public class Stone_Pickax extends Pickax {
    {
        buildMoney = 200;
        repairMoney = 20;
        for(int i = 0; i < 5; i++) {
            needs.add(new Branch());
        }
        for(int i = 0; i < 10; i++) {
            needs.add(new Gravel());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Branch());
        }
        for(int i = 0; i < 5; i++) {
            repairs.add(new Gravel());
        }
    }

    public Stone_Pickax() {
        super("Stone Pickax");
        this.name = "Stone Pickax";
        this.Lr = 1;
        this.p = 20;
    }
}
