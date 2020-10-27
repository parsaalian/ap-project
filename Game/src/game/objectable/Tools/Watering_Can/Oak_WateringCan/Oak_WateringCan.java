package game.objectable.Tools.Watering_Can.Oak_WateringCan;

import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Oak_WateringCan extends Watering_Can {
    public Oak_WateringCan() {
        super("Oak Watering Can", new ArrayList<>(Arrays.asList(new Oak_Lumber(), new Oak_Lumber())), new ArrayList<>(Arrays.asList(new Oak_Lumber())));
        this.name = "Oak Watering Can";
        this.max = 8;
        this.inside = 8;
        this.changeEnergy = -10;
        this.p = 5;
        this.range = 9;
        this.buildMoney = 2000;
        this.repairMoney = 200;
    }
}
