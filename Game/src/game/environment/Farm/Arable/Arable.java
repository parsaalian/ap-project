package game.environment.Farm.Arable;

import game.environment.Farm.Arable.Field.Bean_Field.Bean_Field;
import game.environment.Farm.Arable.Field.Carrot_Field.Carrot_Field;
import game.environment.Farm.Arable.Field.Cucumber_Field.Cucumber_Field;
import game.environment.Farm.Arable.Field.Eggplant_Field.Eggplant_Field;
import game.environment.Farm.Arable.Field.Garlic_Field.Garlic_Field;
import game.environment.Farm.Arable.Field.Lettuce_Field.Lettuce_Field;
import game.environment.Farm.Arable.Field.Melon_Field.Melon_Field;
import game.environment.Farm.Arable.Field.Onion_Field.Onion_Field;
import game.environment.Farm.Arable.Field.Pepper_Field.Pepper_Field;
import game.environment.Farm.Arable.Field.Potato_Field.Potato_Field;
import game.environment.Farm.Arable.Field.Strawberry_Field.Strawberry_Field;
import game.environment.Farm.Arable.Field.Tomato_Field.Tomato_Field;
import game.environment.Farm.Arable.Field.Turnip_Field.Turnip_Field;
import game.environment.Farm.Arable.Field.Watermelon_Field.Watermelon_Field;
import game.environment.Farm.Arable.Garden.Apple.appleTree;
import game.environment.Farm.Arable.Garden.Lemon.lemonTree;
import game.environment.Farm.Arable.Garden.Orange.orangeTree;
import game.environment.Farm.Arable.Garden.Peach.peachTree;
import game.environment.Farm.Arable.Garden.Pear.pearTree;
import game.environment.Farm.Arable.Garden.Pomegranate.pomegranateTree;
import game.environment.Farm.Arable.Garden.Pineapple.Pineapple_Tree;
import game.Game;
import game.objectable.Fruits_and_Vegs.Fruits_and_Vegs;
import game.objectable.Fruits_and_Vegs.Junk.Junk;
import game.objectable.Objectable;
import game.objectable.Seeds.Seeds;
import game.objectable.Tools.Shovel.Shovel;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.Scanner;

public class Arable {
    public String season = null;
    public String type = null;
    protected String spoilage = null;
    protected boolean growth = false;
    public boolean water = false;
    public boolean plowed = false;
    public int left = 0;
    public int needWater = 1;
    public int age = 0;
    protected Fruits_and_Vegs inside;
    public Fruits_and_Vegs under;

    public String harvest() {
        StringBuilder res = new StringBuilder();
        if(!growth) {
            res.append("Crops are not fully grown yet\n");
        }
        else if(Game.Parsa.backpack.capacity == 0) {
            res.append("Backpack is full.\n");
        }
        else {
            if(age > 7) {
                inside = new Junk();
            }
            for(int i = 0; i < 9; i++) {
                Game.Parsa.backpack.items.add(inside);
            }
            res.append("You have collected this product.\n");
            if(left > 0) {
                left--;
                if (left == 0) {
                    destroy();
                }
            }
        }
        return res.toString();
    }

    public String inspectField() {
        StringBuilder res = new StringBuilder();
        if(!type.equals("Empty")) {
            res.append(type + " Field:\n");
            res.append("1. Status\n");
            res.append("2. Water this field\n");
            res.append("3. Harvest crops\n");
            res.append("4. Destroy crops\n");
        }
        else {
            res.append("Empty Field:\n");
            res.append("1. Status\n");
            res.append("2. Plow this field\n");
            res.append("3. Water this field\n");
            res.append("4. Plant seeds\n");
        }
        return res.toString();
    }

    public String inspectGarden() {
        StringBuilder res = new StringBuilder();
        res.append(type + " Tree\n");
        res.append("1. Status\n");
        res.append("2. Water this tree\n");
        res.append("3. Collect fruits\n");
        return res.toString();
    }

    public String status(){
        return null;
    }

    public void water() {
        water = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Watering Can to use:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("Back")) {
                break;
            } else if (choice.equals("WhereAmI")) {
                Game.Parsa.backpack.printItems();
            } else {
                int j;
                try {
                    j = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable waterCan = Game.Parsa.backpack.geti(j);
                if (!waterCan.type.equals("Watering Can")) {
                    System.out.println("You have to choose a Watering Can");
                } else {
                    Watering_Can can = (Watering_Can) Game.Parsa.backpack.geti(j);
                    if (can.getInside() == 0) {
                        System.out.println("Watering Can is empty");
                    } else if (can.broken) {
                        System.out.println("Watering Can is broken");
                    } else {
                        can.setInside(can.getInside() - needWater);
                        System.out.println("Your " + type + " Field has been watered");
                        water = true;
                        if(can.breaking(can.p)) {
                            System.out.println("Your can broke during the operation.");
                            can.broken = true;
                        }
                        Game.Parsa.energy += can.changeEnergy;
                        break;
                    }
                }
            }
        }
    }

    public void plow() {
        plowed = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Shovel to use:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("Back")) {
                break;
            } else if (choice.equals("WhereAmI")) {
                Game.Parsa.backpack.printItems();
            } else {
                int j;
                try {
                    j = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable shovelCheck = Game.Parsa.backpack.geti(j);
                if (!shovelCheck.type.equals("Shovel")) {
                    System.out.println("You have to choose a Shovel");
                } else {
                    Shovel shovel = (Shovel) Game.Parsa.backpack.geti(j);
                    if (shovel.broken) {
                        System.out.println("Shovel is broken");
                    } else {
                        System.out.println("Your " + type + " Field has been plowed");
                        plowed = true;
                        if(shovel.breaking(shovel.p)) {
                            System.out.println("Your shovel broke during the operation.");
                            shovel.broken = true;
                        }
                        Game.Parsa.energy += shovel.changeEnergy;
                        break;
                    }
                    System.out.println(shovel.name);
                }
            }
        }
    }

    public void destroy() {
        type = "Empty";
        season = null;
        growth = false;
        water = false;
        spoilage = Integer.toString(0);
        left = 0;
    }

    public boolean plant() {
        boolean planted = false;
        if(water && plowed) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a seed to plant:");
            Game.Parsa.backpack.printItems();
            while (true) {
                String line = scanner.nextLine();
                if(line.equals("Back")) {
                    break;
                }
                else if(line.equals("WhereAmI")) {
                    System.out.println("Choose a seed to plant:");
                    Game.Parsa.backpack.printItems();
                }
                int j;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable seedCheck = Game.Parsa.backpack.geti(j);
                if(!seedCheck.type.equals("Seed")) {
                    System.out.println("You have to choose a seed.");
                }
                else {
                    Seeds seed = (Seeds) Game.Parsa.backpack.geti(j);
                    if(seed.name.equals("Carrot Seed")) {
                        if(Game.season.equals("Autumn")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Carrot_Field());
                            System.out.println("You have planted carrot in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Garlic Seed")) {
                        if(Game.season.equals("Spring")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Garlic_Field());
                            System.out.println("You have planted garlic in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Lettuce Seed")) {
                        if(Game.season.equals("Spring")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Lettuce_Field());
                            System.out.println("You have planted lettuce in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Onion Seed")) {
                        if(Game.season.equals("Summer")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Onion_Field());
                            System.out.println("You have planted onion in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Tomato Seed")) {
                        if(Game.season.equals("Autumn")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Tomato_Field());
                            System.out.println("You have planted tomato in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Bean Seed")) {
                        if(Game.season.equals("Spring")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Bean_Field());
                            System.out.println("You have planted bean in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Cucumber Seed")) {
                        if(Game.season.equals("Summer")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Cucumber_Field());
                            System.out.println("You have planted cucumber in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Eggplant Seed")) {
                        if(Game.season.equals("Spring")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Eggplant_Field());
                            System.out.println("You have planted eggplant in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Melon Seed")) {
                        if(Game.season.equals("Autumn")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Melon_Field());
                            System.out.println("You have planted melon in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Potato Seed")) {
                        if(Game.season.equals("Autumn")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Potato_Field());
                            System.out.println("You have planted potato in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Turnip Seed")) {
                        if(Game.season.equals("Summer")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Turnip_Field());
                            System.out.println("You have planted turnip in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Watermelon Seed")) {
                        if(Game.season.equals("Summer")) {
                            planted = true;
                            Game.farm.fields.set(Game.farm.fields.indexOf(this), new Watermelon_Field());
                            System.out.println("You have planted watermelon in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else {
                        System.out.println("You can't plant this seed in the fields.");
                    }
                }
            }
        }
        else if(!water && !plowed) {
            System.out.println("You have to water and plow this field.");
            planted = true;
        }
        else if(!water) {
            System.out.println("You have to water this field.");
            planted = true;
        }
        else {
            System.out.println("You have to plow this field.");
            planted = true;
        }
        return planted;
    }

    public boolean plantInGreenhouse() {
        boolean planted = false;
        if(water && plowed) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a seed to plant:");
            Game.Parsa.backpack.printItems();
            while (true) {
                String line = scanner.nextLine();
                if(line.equals("Back")) {
                    break;
                }
                else if(line.equals("WhereAmI")) {
                    System.out.println("Choose a seed to plant:");
                    Game.Parsa.backpack.printItems();
                }
                int j;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable seedCheck = Game.Parsa.backpack.geti(j);
                if(!seedCheck.type.equals("Seed")) {
                    System.out.println("You have to choose a seed.");
                }
                else {
                    Seeds seed = (Seeds) Game.Parsa.backpack.geti(j);
                    if(seed.name.equals("Carrot Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Carrot_Field());
                            System.out.println("You have planted carrot in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Garlic Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Garlic_Field());
                            System.out.println("You have planted garlic in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Lettuce Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Lettuce_Field());
                            System.out.println("You have planted lettuce in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Onion Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Onion_Field());
                            System.out.println("You have planted onion in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Tomato Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Tomato_Field());
                            System.out.println("You have planted tomato in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Bean Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Bean_Field());
                            System.out.println("You have planted bean in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Cucumber Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Cucumber_Field());
                            System.out.println("You have planted cucumber in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Eggplant Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Eggplant_Field());
                            System.out.println("You have planted eggplant in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Melon Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Melon_Field());
                            System.out.println("You have planted melon in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Potato Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Potato_Field());
                            System.out.println("You have planted potato in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Turnip Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Turnip_Field());
                            System.out.println("You have planted turnip in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Watermelon Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Watermelon_Field());
                            System.out.println("You have planted watermelon in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Apple Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new appleTree());
                            System.out.println("You have planted apple in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Lemon Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new lemonTree());
                            System.out.println("You have planted lemon in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Orange Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Autumn")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new orangeTree());
                            System.out.println("You have planted orange in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Peach Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new peachTree());
                            System.out.println("You have planted peach in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Pear Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Spring")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new pearTree());
                            System.out.println("You have planted pear in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Pomegranate Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Summer")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new pomegranateTree());
                            System.out.println("You have planted pomegranate in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Pineapple Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Tropical")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Pineapple_Tree());
                            System.out.println("You have planted pineapple in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Strawberry Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Tropical")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Strawberry_Field());
                            System.out.println("You have planted strawberry in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                    else if(seed.name.equals("Pepper Seed")) {
                        if(Game.farm.greenhouse.Weather.equals("Tropical")) {
                            planted = true;
                            Game.farm.greenhouse.fields.set(Game.farm.greenhouse.fields.indexOf(this), new Pepper_Field());
                            System.out.println("You have planted pepper in this field.");
                            Game.Parsa.backpack.takeItem(seed);
                            break;
                        }
                        else {
                            System.out.println("You can't plant this seed in this season.");
                        }
                    }
                }
            }
        }
        else if(!water && !plowed) {
            System.out.println("You have to water and plow this field.");
            planted = true;
        }
        else if(!water) {
            System.out.println("You have to water this field.");
            planted = true;
        }
        else {
            System.out.println("You have to plow this field.");
            planted = true;
        }
        return planted;
    }

    public Arable() {

    }
}
