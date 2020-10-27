package game.objectable.Food.Human_Food.Other_Foods.Juice.Pineapple_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Tropical.Pineapple.Pineapple;

public class Pineapple_Juice extends Juice {
    public Pineapple_Juice() {
        super("Pineapple Juice");
        this.from = new Pineapple();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Pineapple Juice";
    }
}
