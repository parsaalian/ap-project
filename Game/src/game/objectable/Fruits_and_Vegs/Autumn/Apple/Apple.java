package game.objectable.Fruits_and_Vegs.Autumn.Apple;

import game.objectable.Fruits_and_Vegs.Autumn.Autumn;
import java.util.Random;

public class Apple extends Autumn {
    private Random random = new Random();

    public Apple() {
        super("Apple");
        this.money = 20;
        this.addMaxHealth = 5;
        this.addEnergy = 10;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Apple";
    }
}
