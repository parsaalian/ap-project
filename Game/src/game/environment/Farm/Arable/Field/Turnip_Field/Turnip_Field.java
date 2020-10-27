package game.environment.Farm.Arable.Field.Turnip_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Summer.Turnip.Turnip;

public class Turnip_Field extends Field {
    public Turnip_Field() {
        this.type = "Turnip";
        this.season = "Summer";
        this.inside = new Turnip();
        this.left = inside.removal;
    }
}
