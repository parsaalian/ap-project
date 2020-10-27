package game.objectable.Food.Human_Food.French_Fries;

import game.objectable.Food.Human_Food.Human_Food;

public class French_Fries extends Human_Food {
    public French_Fries() {
        super("French Fries");
        this.addEnergy = 100;
        this.addMaxHealth = -15;
        this.money = 10;
    }
}
