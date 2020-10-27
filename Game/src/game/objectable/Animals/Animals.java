package game.objectable.Animals;

import game.Game;
import game.objectable.*;
import game.objectable.Animals.Chicken.Chicken;
import game.objectable.Animals.Cow.Cow;
import game.objectable.Animals.Sheep.Sheep;
import game.objectable.Animals.Fish.Fish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Animals extends Objectable {
    public int name;
    protected int health = 100;
    protected int satiety = 100;
    public boolean feedToday;

    protected void feedCowAndSheep() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Alfalfa to eat:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose Alfalfa to eat:");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j = 0;
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
                Objectable item = Game.Parsa.backpack.geti(j);
                if(!item.name.equals("Alfalfa")) {
                    System.out.println("You have to choose alfalfa.");
                }
                else {
                    satiety = 100;
                    System.out.println("Your animal has been feed.");
                    feedToday = true;
                    Game.Parsa.backpack.takeItem(item);
                    break;
                }
            }
        }
    }

    protected void heal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Animal Medicine:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose Animal Medicine to heal:");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j = 0;
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
                Objectable item = Game.Parsa.backpack.geti(j);
                if(!item.name.equals("Animal Medicine")) {
                    System.out.println("You have to choose animal medicine.");
                }
                else {
                    health = 100;
                    Game.Parsa.backpack.takeItem(item);
                }
            }
        }
    }

    public String status() {
        return null;
    }

    public String sellStatus() {
        StringBuilder res = new StringBuilder();
        res.append(type + ":\n");
        res.append("Cost: " + money + '\n');
        System.out.print("Food: \n");
        if(!type.equals("Chicken\n")) {
            res.append("Alfalfa\n");
        }
        else {
            res.append("Seed\n");
        }
        return res.toString();
    }

    public Animals(String name, String type) {
        super(name, type);
    }

    public static ArrayList <Animals> animals = new ArrayList<>(Arrays.asList(new Chicken("no-name"), new Cow("no-name"), new Fish(), new Sheep("no-name")));
}
