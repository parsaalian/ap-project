package game.environment.Farm.Arable.Field.Bean_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Spring.Bean.Bean;

public class Bean_Field extends Field {
    public Bean_Field() {
        this.type = "Bean";
        this.season = "Spring";
        this.inside = new Bean();
        this.left = inside.removal;
    }
}
