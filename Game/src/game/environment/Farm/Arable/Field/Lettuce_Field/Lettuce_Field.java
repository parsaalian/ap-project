package game.environment.Farm.Arable.Field.Lettuce_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Spring.Lettuce.Lettuce;

public class Lettuce_Field extends Field {
    public Lettuce_Field() {
        this.type = "Lettuce";
        this.season = "Spring";
        this.inside = new Lettuce();
        this.left = inside.removal;
    }
}