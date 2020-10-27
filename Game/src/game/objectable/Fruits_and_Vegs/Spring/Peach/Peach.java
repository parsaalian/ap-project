package game.objectable.Fruits_and_Vegs.Spring.Peach;

import game.objectable.Fruits_and_Vegs.Spring.Spring;
import java.util.Random;

public class Peach extends Spring {
    private Random random = new Random();

    public Peach() {
        super("Peach");
        this.money = 15;
        this.addHealth = 15;
        this.toDrop = random.nextInt(2) + 2;
        this.name = "Peach";
    }
}
