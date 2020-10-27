package game.environment.Farm.Arable.Field.Carrot_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Autumn.Carrot.Carrot;

public class Carrot_Field extends Field {
    public Carrot_Field() {
        this.type = "Carrot";
        this.season = "Autumn";
        this.inside = new Carrot();
        this.left = inside.removal;
    }
}
