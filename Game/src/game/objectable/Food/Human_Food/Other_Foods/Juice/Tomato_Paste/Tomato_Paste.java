package game.objectable.Food.Human_Food.Other_Foods.Juice.Tomato_Paste;

import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;

public class Tomato_Paste extends Juice {
    public Tomato_Paste() {
        super("Tomato Paste");
        this.from = new Tomato();
        this.money = (int) (from.money * 1.2);
        this.addHealth = (int) (from.addHealth * 1.25);
        this.addEnergy = (int) (from.addEnergy * 1.25);
        this.addMaxHealth = (int) (from.addMaxHealth * 1.25);
        this.addMaxEnergy = (int) (from.addMaxEnergy * 1.25);
        this.name = "Tomato Paste";
    }
}
