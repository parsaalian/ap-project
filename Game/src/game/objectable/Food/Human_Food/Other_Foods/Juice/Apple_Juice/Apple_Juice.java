package game.objectable.Food.Human_Food.Other_Foods.Juice.Apple_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;

public class Apple_Juice extends Juice {
    public Apple_Juice() {
        super("Apple Juice");
        this.from = new Apple();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Apple Juice";
    }
}
