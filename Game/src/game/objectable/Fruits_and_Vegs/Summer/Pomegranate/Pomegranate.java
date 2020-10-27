package game.objectable.Fruits_and_Vegs.Summer.Pomegranate;

import game.objectable.Fruits_and_Vegs.Summer.Summer;
import java.util.Random;

public class Pomegranate extends Summer {
    private Random random = new Random();

    public Pomegranate() {
        super("Pomegranate");
        this.money = 25;
        this.addMaxEnergy = 5;
        this.addEnergy = 15;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Pomegranate";
    }
}
