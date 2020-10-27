package game.environment.Farm.Arable.Field.Garlic_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Spring.Garlic.Garlic;

public class Garlic_Field extends Field {
    public Garlic_Field() {
        this.type = "Garlic";
        this.season = "Spring";
        this.inside = new Garlic();
        this.left = inside.removal;
    }
}