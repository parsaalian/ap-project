package game.objectable.Tools.Pickax.Iron_Pickax;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Pickax.Pickax;

public class Iron_Pickax extends Pickax {
    {
        buildMoney = 800;
        repairMoney = 80;
        for(int i = 0; i < 4; i++) {
            needs.add(new Old_Lumber());
        }
        for(int i = 0; i < 8; i++) {
            needs.add(new Iron());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Old_Lumber());
        }
        for(int i = 0; i < 4; i++) {
            repairs.add(new Iron());
        }
    }

    public Iron_Pickax() {
        super("Iron Pickax");
        this.name = "Iron Pickax";
        this.Lr = 2;
        this.p = 15;
    }
}
