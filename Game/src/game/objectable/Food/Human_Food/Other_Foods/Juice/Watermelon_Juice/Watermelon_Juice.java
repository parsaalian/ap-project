package game.objectable.Food.Human_Food.Other_Foods.Juice.Watermelon_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Summer.Watermelon.Watermelon;

public class Watermelon_Juice extends Juice {
    public Watermelon_Juice() {
        super("Watermelon Juice");
        this.from = new Watermelon();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Watermelon Juice";
    }
}
