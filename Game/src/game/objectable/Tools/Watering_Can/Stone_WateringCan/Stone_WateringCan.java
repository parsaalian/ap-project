package game.objectable.Tools.Watering_Can.Stone_WateringCan;

import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Stone_WateringCan extends Watering_Can {
    public Stone_WateringCan() {
        super("Stone Watering Can", new ArrayList<>(Arrays.asList(new Gravel(), new Gravel(), new Gravel(), new Gravel(), new Gravel())), new ArrayList<>(Arrays.asList(new Gravel(), new Gravel())));
        this.name = "Stone Watering Can";
        this.max = 2;
        this.inside = 2;
        this.changeEnergy = -80;
        this.p = 20;
        this.range = 1;
        this.buildMoney = 50;
        this.repairMoney = 5;
    }
}
