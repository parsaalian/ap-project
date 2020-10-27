package game.objectable.Tools.Watering_Can.Silver_WateringCan;

import game.objectable.Goods.Stone.Silver.Silver;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Silver_WateringCan extends Watering_Can {
    public Silver_WateringCan() {
        super("Silver Watering Can", new ArrayList<>(Arrays.asList(new Silver(), new Silver(), new Silver())), new ArrayList<>(Arrays.asList(new Silver())));
        this.name = "Silver Watering Can";
        this.max = 8;
        this.inside = 8;
        this.changeEnergy = -40;
        this.p = 15;
        this.range = 3;
        this.buildMoney = 500;
        this.repairMoney = 50;
    }
}
