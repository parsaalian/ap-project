package game.environment.Farm.Arable.Field.Potato_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Autumn.Potato.Potato;

public class Potato_Field extends Field {
    public Potato_Field() {
        this.type = "Potato";
        this.season = "Autumn";
        this.inside = new Potato();
        this.left = inside.removal;
    }
}
