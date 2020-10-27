package game.environment.Farm.Arable.Garden.Orange;

import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Autumn.Orange.Orange;

public class orangeTree extends Garden {
    public orangeTree() {
        this.type = "Orange";
        this.season = "Autumn";
        this.under = new Orange();
    }
}