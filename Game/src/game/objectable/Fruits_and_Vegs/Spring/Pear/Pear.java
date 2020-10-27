package game.objectable.Fruits_and_Vegs.Spring.Pear;

import game.objectable.Fruits_and_Vegs.Spring.Spring;
import java.util.Random;

public class Pear extends Spring {
    private Random random = new Random();

    public Pear() {
        super("Pear");
        this.money = 15;
        this.addEnergy = 20;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Pear";
    }
}
