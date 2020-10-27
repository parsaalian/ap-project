package game.objectable.Food.Human_Food.Other_Foods.Juice.Orange_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Autumn.Orange.Orange;

public class Orange_Juice extends Juice {
    public Orange_Juice() {
        super("Orange Juice");
        this.from = new Orange();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Orange Juice";
    }
}
