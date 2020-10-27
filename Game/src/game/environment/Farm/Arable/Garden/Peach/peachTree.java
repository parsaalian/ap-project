package game.environment.Farm.Arable.Garden.Peach;

import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Spring.Peach.Peach;

public class peachTree extends Garden {
    public peachTree() {
        this.type = "Peach";
        this.season = "Spring";
        this.under = new Peach();
    }
}