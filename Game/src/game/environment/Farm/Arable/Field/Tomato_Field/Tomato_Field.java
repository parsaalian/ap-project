package game.environment.Farm.Arable.Field.Tomato_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;

public class Tomato_Field extends Field {
    public Tomato_Field() {
        this.type = "Tomato";
        this.season = "Autumn";
        this.inside = new Tomato();
        this.left = inside.removal;
    }
}