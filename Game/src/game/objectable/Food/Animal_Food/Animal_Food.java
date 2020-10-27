package game.objectable.Food.Animal_Food;

import game.objectable.Food.Food;

public class Animal_Food extends Food {
    public String status() {
        if(type.equals("Seed")) {
            return ("Food for Chickens.");
        }
        else {
            return ("Food for Sheep and Cows.");
        }
    }

    public Animal_Food(String name) {
        super(name);
        this.inspectType = 2;
    }
}
