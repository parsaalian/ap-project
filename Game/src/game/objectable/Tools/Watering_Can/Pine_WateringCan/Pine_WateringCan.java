package game.objectable.Tools.Watering_Can.Pine_WateringCan;

import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Pine_WateringCan extends Watering_Can {
    public Pine_WateringCan() {
        super("Pine Watering Can", new ArrayList<>(Arrays.asList(new Pine_Lumber(), new Pine_Lumber(), new Pine_Lumber())), new ArrayList<>(Arrays.asList(new Pine_Lumber())));
        this.name = "Pine Watering Can";
        this.max = 4;
        this.inside = 4;
        this.changeEnergy = -20;
        this.p = 10;
        this.range = 3;
        this.buildMoney = 500;
        this.repairMoney = 50;
    }
}
