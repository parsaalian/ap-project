package game.objectable.Tools.Watering_Can.Adamantium_WateringCan;

import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.ArrayList;
import java.util.Arrays;

public class Adamantium_WateringCan extends Watering_Can {
    {
        buildMoney = 2000;
        repairMoney = 200;
        for(int i = 0; i < 2; i++) {
            needs.add(new Adamantium());
        }
        for(int i = 0; i < 1; i++) {
            repairs.add(new Adamantium());
        }
    }

    public Adamantium_WateringCan() {
        super("Adamantium Watering Can", new ArrayList<>(Arrays.asList(new Adamantium(), new Adamantium())), new ArrayList<>(Arrays.asList(new Adamantium())));
        this.name = "Adamantium Watering Can";
        this.max = 16;
        this.inside = 16;
        this.changeEnergy = -20;
        this.p = 5;
        this.range = 9;
        this.buildMoney = 2000;
        this.repairMoney = 200;
    }
}
