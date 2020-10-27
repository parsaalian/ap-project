package game.objectable.Food.Human_Food.Other_Foods.Juice.Pear_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Spring.Pear.Pear;

public class Pear_Juice extends Juice {
    public Pear_Juice() {
        super("Pear Juice");
        this.from = new Pear();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Pear Juice";
    }
}
