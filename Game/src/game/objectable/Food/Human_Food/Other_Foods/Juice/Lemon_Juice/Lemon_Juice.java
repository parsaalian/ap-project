package game.objectable.Food.Human_Food.Other_Foods.Juice.Lemon_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Summer.Lemon.Lemon;

public class Lemon_Juice extends Juice {
    public Lemon_Juice() {
        super("Lemon Juice");
        this.from = new Lemon();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Lemon Juice";
    }
}
