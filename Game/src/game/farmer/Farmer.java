package game.farmer;

import java.util.*;

import game.environment.Village.Cafe.MissionBoard.Mission;
import game.objectable.*;
import game.*;
import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;
import game.objectable.Fruits_and_Vegs.Autumn.Potato.Potato;
import game.objectable.Fruits_and_Vegs.Spring.Garlic.Garlic;
import game.objectable.Goods.Food_Goods.Oil.Oil;
import game.objectable.Goods.Food_Goods.Spices.Salt.Salt;
import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Seeds.Apple_Seed.Apple_Seed;
import game.objectable.Seeds.Garlic_Seed.Garlic_Seed;
import game.objectable.Seeds.Peach_Seed.Peach_Seed;
import game.objectable.Seeds.Pineapple_Seed.Pineapple_Seed;
import game.objectable.Seeds.Pomegranate_Seed.Pomegranate_Seed;
import game.objectable.Seeds.Potato_Seed.Potato_Seed;
import game.objectable.Seeds.Watermelon_Seed.Watermelon_Seed;
import game.objectable.Tools.Axe.Adamantium_Axe.Adamantium_Axe;
import game.objectable.Tools.Cooking.Knife.Knife;
import game.objectable.Tools.Fishing_Rod.Old_FishingRod.Old_FishingRod;
import game.objectable.Tools.Milker.Milker;
import game.objectable.Tools.Pickax.Adamantium_Pickax.Adamantium_Pickax;
import game.objectable.Tools.Shovel.Adamantium_Shovel.Adamantium_Shovel;
import game.objectable.Tools.Watering_Can.Adamantium_WateringCan.Adamantium_WateringCan;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;

public class Farmer {
    public Backpack backpack = new Backpack();
    public static int money = 6000;
    public static double health = 500;
    public static double energy = 1000;
    public static double maxHealth = 500;
    public static double maxEnergy = 1000;
    public static double healthCons = 100;
    public static double healthRefill = 100;
    public static double energyCons = 10;
    public static double energyRefill = 100;
    public static double stamina = 500;
    public static double maxStamina = 500;
    public static double staminaCons = 10;
    public static double staminaRefill = 100;
    public static double satiety = 500;
    public static double maxSatiety = 500;
    public static double satietyCons = 5;

    public String goTo(String place) {
        //void->String, Calls should be checked

        if(Game.gamePlay.places.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Farm") && Game.farm.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Greenhouse") && Game.farm.greenhouse.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Jungle") && Game.jungle.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Village") && Game.village.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Workshop") && Game.village.workshop.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Clinic") && Game.village.clinic.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Rance") && Game.village.ranch.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Laboratory") && Game.village.laboratory.placesToGo.contains(place))
            energy -= 10;
        else if(Game.gamePlay.place.equals("Gym") && Game.village.gym.placesToGo.contains(place))
            energy -= 10;
        else
            return "Invalid Target!";
        Game.gamePlay.setPlace(place);
        return "You Have Entered " + place;
    }

    public ArrayList<Mission> missions = new ArrayList<>();

    public String stats() {
        StringBuilder res = new StringBuilder();
        res.append("Health: " + health + '\n');
        res.append("Energy: " + energy + '\n');
        res.append("Money: " + money + '\n');
        return res.toString();
    }

    public class Backpack {

        public int capacity = 200;
        public ArrayList<Objectable> items = new ArrayList<>(Arrays.asList(new Adamantium_Shovel(), new Adamantium_Axe(), new Adamantium_Pickax(), new Adamantium_WateringCan(), new Apple(), new Apple_Seed(), new Pineapple_Seed(), new Peach_Seed(), new Pomegranate_Seed(), new Garlic_Seed(), new Potato(), new Potato(), new Oil(), new Salt(), new Milker(),new Knife()));

        {
            for(int i = 0; i < 30; i++) {
                items.add(new Iron());
                items.add(new Old_Lumber());
            }
        }

        public Objectable itemClass(Objectable objectable) {
            Objectable ret = null;
            for(Objectable item : items) {
                if(item.name.equals(objectable.name)) {
                    ret = item;
                    break;
                }
            }
            return ret;
        }

        public Objectable geti(int j) {
            String name;
            Objectable ret = null;
            ArrayList<String> items_names = new ArrayList<>();
            for (Objectable objectable : items) {
                items_names.add(objectable.name);
            }
            HashSet<String> items_rep = new HashSet<>(items_names);
            items_names = new ArrayList<>();
            for(String string :items_rep) {
                items_names.add(string);
            }
            name = items_names.get(j - 1);
            for(Objectable item : items) {
                if(Objects.equals(item.name, name)) {
                    ret = item;
                    break;
                }
            }
            return ret;
        }

        public int getRange() {
            ArrayList<String> items_names = new ArrayList<>();
            for (Objectable objectable : items) {
                items_names.add(objectable.name);
            }
            HashSet<String> items_rep = new HashSet<>(items_names);
            items_names = new ArrayList<>();
            for(String string :items_rep) {
                items_names.add(string);
            }
            return items_rep.size();
        }

        public int frequency(Objectable get) {
            ArrayList<String> items_names = new ArrayList<>();
            for (Objectable objectable : items) {
                items_names.add(objectable.name);
            }
            return Collections.frequency(items_names, get.name);
        }

        public String printItems() {
            //void->String, Calls should be checked
            StringBuilder res = new StringBuilder();
            ArrayList<String> items_names = new ArrayList<>();
            for (Objectable objectable : items) {
                items_names.add(objectable.name);
            }
            int i = 1;
            HashSet<String> items_rep = new HashSet<>(items_names);
            for(String string : items_rep) {
                String repeat = "";
                if(Collections.frequency(items_names, string) > 1) {
                    repeat = "x" + Integer.toString(Collections.frequency(items_names, string));
                }
                res.append(i++ + ". " + string + " " + repeat + '\n');
            }
            return res.toString();
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public void putItem(Objectable objectable) {
            items.add(objectable);
            capacity -= objectable.capacity;
        }

        public void takeItem(Objectable item) {
            for(Objectable objectable : items) {
                if(objectable.name.equals(item.name)) {
                    items.remove(objectable);
                    break;
                }
            }
        }


        public void inspectBackpack() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an item:");
            Game.Parsa.backpack.printItems();
            while(true) {
                String line = scanner.nextLine();
                if(line.equals("Back")) {
                    break;
                }
                else if(line.equals("WhereAmI")) {
                    System.out.println("Choose an item:");
                    Game.Parsa.backpack.printItems();
                }
                else {
                    int j;
                    try {
                        j = Integer.parseInt(line);
                    } catch (Exception e) {
                        System.out.println("Invalid Command!");
                        continue;
                    }
                    if(j < 1 || j > getRange()) {
                        System.out.println("Out of range.");
                        continue;
                    }
                    Objectable item = geti(j);
                    if(item.inspectType == 1) {
                        item.inspect1();
                    }
                    else {
                        item.inspect2();
                    }
                }
            }
        }
    }
}
