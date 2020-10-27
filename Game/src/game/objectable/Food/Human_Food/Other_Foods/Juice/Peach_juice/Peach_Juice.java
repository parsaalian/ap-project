package game.objectable.Food.Human_Food.Other_Foods.Juice.Peach_juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Spring.Peach.Peach;

public class Peach_Juice extends Juice {
    public Peach_Juice() {
        super("Peach Juice");
        this.from = new Peach();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Peach Juice";
    }
}
