package game.environment.Farm.Arable.Field.Melon_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Autumn.Melon.Melon;

public class Melon_Field extends Field {
    public Melon_Field() {
        this.type = "Melon";
        this.season = "Autumn";
        this.inside = new Melon();
        this.left = inside.removal;
    }
}
