package game.objectable.Tools.Axe.Iron_Axe;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Axe.Axe;

public class Iron_Axe extends Axe {
    {
        buildMoney = 800;
        repairMoney = 80;
        for(int i = 0; i < 8; i++) {
            needs.add(new Old_Lumber());
        }
        for(int i = 0; i < 4; i++) {
            needs.add(new Iron());
        }
        for(int i = 0; i < 4; i++) {
            repairs.add(new Old_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Iron());
        }
    }

    public Iron_Axe() {
        super("Iron Axe");
        this.name = "Iron Axe";
        this.Lr = 2;
        this.p = 15;
    }
}
