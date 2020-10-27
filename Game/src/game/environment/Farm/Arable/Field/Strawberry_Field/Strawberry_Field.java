package game.environment.Farm.Arable.Field.Strawberry_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Tropical.Strawberry.Strawberry;

public class Strawberry_Field extends Field {
    public Strawberry_Field() {
        this.type = "Potato";
        this.season = "Tropical";
        this.inside = new Strawberry();
        this.left = inside.removal;
    }
}
