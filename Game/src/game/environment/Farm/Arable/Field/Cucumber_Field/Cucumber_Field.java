package game.environment.Farm.Arable.Field.Cucumber_Field;

import game.environment.Farm.Arable.Field.Field;
import game.objectable.Fruits_and_Vegs.Summer.Cucumber.Cucumber;

public class Cucumber_Field extends Field {
    public Cucumber_Field() {
        this.type = "Cucumber";
        this.season = "Summer";
        this.inside = new Cucumber();
        this.left = inside.removal;
    }
}
