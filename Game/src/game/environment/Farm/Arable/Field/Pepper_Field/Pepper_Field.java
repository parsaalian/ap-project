package game.environment.Farm.Arable.Field.Pepper_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Tropical.Pepper.Pepper;

public class Pepper_Field extends Field {
    public Pepper_Field() {
        this.type = "Potato";
        this.season = "Autumn";
        this.inside = new Pepper();
        this.left = inside.removal;
    }
}
