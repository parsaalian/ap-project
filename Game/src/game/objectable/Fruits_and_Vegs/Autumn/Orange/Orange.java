package game.objectable.Fruits_and_Vegs.Autumn.Orange;

import game.objectable.Fruits_and_Vegs.Autumn.Autumn;
import java.util.Random;

public class Orange extends Autumn {
    private Random random = new Random();

    public Orange() {
        super("Orange");
        this.money = 20;
        this.addMaxEnergy = 5;
        this.addHealth = 10;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Orange";
    }
}
