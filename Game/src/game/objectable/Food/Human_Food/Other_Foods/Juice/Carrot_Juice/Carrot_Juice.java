package game.objectable.Food.Human_Food.Other_Foods.Juice.Carrot_Juice;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Autumn.Carrot.Carrot;

public class Carrot_Juice extends Juice {
    public Carrot_Juice() {
        super("Carrot Juice");
        this.from = new Carrot();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Carrot Juice";
    }
}
