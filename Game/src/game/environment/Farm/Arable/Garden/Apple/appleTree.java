package game.environment.Farm.Arable.Garden.Apple;


import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;

public class appleTree extends Garden {
    public appleTree() {
        this.type = "Apple";
        this.season = "Autumn";
        this.under = new Apple();
    }
}