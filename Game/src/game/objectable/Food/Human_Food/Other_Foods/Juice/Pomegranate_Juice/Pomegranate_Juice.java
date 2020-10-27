package game.objectable.Food.Human_Food.Other_Foods.Juice.Pomegranate_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Summer.Pomegranate.Pomegranate;

public class Pomegranate_Juice extends Juice {
    public Pomegranate_Juice() {
        super("Pomegranate Juice");
        this.from = new Pomegranate();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Pomegranate Juice";
    }
}
