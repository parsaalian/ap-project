package game.objectable.Fruits_and_Vegs.Summer.Lemon;

import game.objectable.Fruits_and_Vegs.Summer.Summer;
import java.util.Random;

public class Lemon extends Summer {
    private Random random = new Random();

    public Lemon() {
        super("Lemon");
        this.money = 15;
        this.addEnergy = 20;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Lemon";
    }
}
