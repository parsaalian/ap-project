package game.environment.Farm.Arable.Garden.Lemon;

import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Summer.Lemon.Lemon;

public class lemonTree extends Garden {
    public lemonTree() {
        this.type = "Lemon";
        this.season = "Summer";
        this.under = new Lemon();
    }
}