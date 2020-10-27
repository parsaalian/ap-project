package game.objectable.Tools.Watering_Can.Small_WateringCan;

import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Small_WateringCan extends Watering_Can {
    public Small_WateringCan() {
        super("Small Watering Can", new ArrayList<>(Arrays.asList(new Branch(), new Branch(), new Branch(), new Branch(), new Branch())), new ArrayList<>(Arrays.asList(new Branch(), new Branch())));
        this.name = "Small Watering Can";
        this.max = 1;
        this.inside = 1;
        this.changeEnergy = -40;
        this.p = 20;
        this.range = 1;
        this.buildMoney = 50;
        this.repairMoney = 5;
    }
}
