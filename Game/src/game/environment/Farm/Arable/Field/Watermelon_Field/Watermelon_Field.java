package game.environment.Farm.Arable.Field.Watermelon_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Summer.Watermelon.Watermelon;

public class Watermelon_Field extends Field {
    public Watermelon_Field() {
        this.type = "Watermelon";
        this.season = "Summer";
        this.inside = new Watermelon();
        this.left = inside.removal;
    }
}
