package game.environment.Farm.Arable.Field.Eggplant_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Spring.Eggplant.Eggplant;

public class Eggplant_Field extends Field {
    public Eggplant_Field() {
        this.type = "Eggplant";
        this.season = "Spring";
        this.inside = new Eggplant();
        this.left = inside.removal;
    }
}
