package game.objectable.Tools.Axe.Silver_Axe;

import game.objectable.Goods.Stone.Silver.Silver;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Tools.Axe.Axe;

public class Silver_Axe extends Axe {
    {
        buildMoney = 2000;
        repairMoney = 200;
        for (int i = 0; i < 6; i++) {
            needs.add(new Pine_Lumber());
        }
        for (int i = 0; i < 3; i++) {
            needs.add(new Silver());
        }
        for (int i = 0; i < 3; i++) {
            repairs.add(new Pine_Lumber());
        }
        for (int i = 0; i < 1; i++) {
            repairs.add(new Silver());
        }
    }

    public Silver_Axe() {
        super("Silver Axe");
        this.name = "Silver Axe";
        this.Lr = 3;
        this.p = 10;
    }
}
