package game.objectable.Tools.Axe.Stone_Axe;

import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Tools.Axe.Axe;

public class Stone_Axe extends Axe {
    {
        buildMoney = 200;
        repairMoney = 20;
        for(int i = 0; i < 10; i++) {
            needs.add(new Branch());
        }
        for(int i = 0; i < 5; i++) {
            needs.add(new Gravel());
        }
        for(int i = 0; i < 5; i++) {
            repairs.add(new Branch());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Gravel());
        }
    }

    public Stone_Axe() {
        super("Stone Axe");
        this.name = "Stone Axe";
        this.Lr = 1;
        this.p = 20;
    }
}
