package game.objectable.Tools.Watering_Can.Old_WateringCan;

import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Old_WateringCan extends Watering_Can {
    public Old_WateringCan() {
        super("Old Watering Can", new ArrayList<>(Arrays.asList(new Old_Lumber(), new Old_Lumber(), new Old_Lumber(), new Old_Lumber())), new ArrayList<>(Arrays.asList(new Old_Lumber(), new Old_Lumber())));
        this.name = "Old Watering Can";
        this.max = 2;
        this.inside = 2;
        this.changeEnergy = -30;
        this.p = 15;
        this.range = 2;
        this.buildMoney = 200;
        this.repairMoney = 20;
    }
}
