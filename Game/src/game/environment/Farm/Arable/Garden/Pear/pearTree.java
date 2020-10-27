package game.environment.Farm.Arable.Garden.Pear;

import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Spring.Pear.Pear;

public class pearTree extends Garden {
    public pearTree() {
        this.type = "Pear";
        this.season = "Spring";
        this.under = new Pear();
    }
}
