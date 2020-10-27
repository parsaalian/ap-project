package game.objectable.Tools.Pickax.Adamantium_Pickax;

import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Pickax.Pickax;

public class Adamantium_Pickax extends Pickax {
    {
        buildMoney = 7000;
        repairMoney = 700;
        for(int i = 0; i < 2; i++) {
            needs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 4; i++) {
            needs.add(new Adamantium());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Adamantium());
        }
    }

    public Adamantium_Pickax() {
        super("Adamantium Pickax");
        this.name = "Adamantium Pickax";
        this.Lr = 4;
        this.p = 5;
    }
}
