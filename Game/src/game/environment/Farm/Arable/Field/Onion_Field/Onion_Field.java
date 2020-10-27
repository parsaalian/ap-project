package game.environment.Farm.Arable.Field.Onion_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Summer.Onion.Onion;

public class Onion_Field extends Field {
    public Onion_Field() {
        this.type = "Onion";
        this.season = "Summer";
        this.inside = new Onion();
        this.left = inside.removal;
    }
}