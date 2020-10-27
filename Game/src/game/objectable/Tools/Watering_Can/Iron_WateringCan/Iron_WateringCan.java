package game.objectable.Tools.Watering_Can.Iron_WateringCan;

import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Iron_WateringCan extends Watering_Can {
    {
        buildMoney = 200;
        repairMoney = 20;
        for(int i = 0; i < 4; i++) {
            needs.add(new Iron());
        }
        for(int i = 0; i < 2; i++) {
            repairs.add(new Iron());
        }
    }

    public Iron_WateringCan() {
        super("Iron Watering Can", new ArrayList<>(Arrays.asList(new Iron(), new Iron(), new Iron(), new Iron())), new ArrayList<>(Arrays.asList(new Iron(), new Iron())));
        this.name = "Iron Watering Can";
        this.max = 4;
        this.inside = 4;
        this.changeEnergy = -60;
        this.p = 15;
        this.range = 2;
        this.buildMoney = 200;
        this.repairMoney = 20;
    }
}
