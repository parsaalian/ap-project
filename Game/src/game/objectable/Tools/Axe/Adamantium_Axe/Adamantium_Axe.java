package game.objectable.Tools.Axe.Adamantium_Axe;

import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Axe.Axe;

public class Adamantium_Axe extends Axe {
    {
        buildMoney = 7000;
        repairMoney = 700;
        for(int i = 0; i < 4; i++) {
            needs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 2; i++) {
            needs.add(new Adamantium());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Oak_Lumber());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Adamantium());
        }
    }

    public Adamantium_Axe() {
        super("Adamantium Axe");
        this.name = "Adamantium Axe";
        this.Lr = 4;
        this.p = 5;
    }
}
