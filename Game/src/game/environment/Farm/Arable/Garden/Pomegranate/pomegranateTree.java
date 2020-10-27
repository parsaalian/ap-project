package game.environment.Farm.Arable.Garden.Pomegranate;

import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Summer.Pomegranate.Pomegranate;

public class pomegranateTree extends Garden {
    public pomegranateTree() {
        this.type = "Pomegranate";
        this.season = "Summer";
        this.under = new Pomegranate();
    }
}