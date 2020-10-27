package game.environment.Farm.Arable.Field;

import game.environment.Farm.Arable.*;

public class Field extends Arable {
    public String status() {
        StringBuilder res = new StringBuilder();
        if(!type.equals("Empty")) {
            String growthString;
            if (age < 5) {
                growthString = Integer.toString(5 - age) + " day(s) to full growth.";
                spoilage = "Not grown yet.";
            } else if (age >= 5 && age < 7) {
                growth = true;
                growthString = "Fully grown!";
                spoilage = Integer.toString(7 - age) + " day(s)";
            } else {
                spoilage = "The product is spoiled.";
                growthString = "The product is spoiled.";
            }
            res.append("Status:\n");
            res.append("Crop type: " + type + '\n');
            res.append("Crop season: " + season + '\n');
            res.append("Days until full growth: " + growthString + '\n');
            res.append("Watered today: " + water + '\n');
            res.append("Days until spoilage: " + spoilage + '\n');
            res.append("Crop harvests left: " + left + " time(s)\n");
        }
        else {
            res.append("Status:\n");
            res.append("Crop type: Empty\n");
            res.append("is Watered today: " + water + '\n');
            res.append("is Plowed today: " + plowed + '\n');
        }
        return res.toString();
    }

    public Field() {
        super();
    }
}
