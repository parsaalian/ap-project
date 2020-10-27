package game.environment.Farm.Home.Kitchen.Recipe;

import game.Game;
import game.objectable.Objectable;
import game.objectable.Tools.Cooking.Cooking;
import graphic.Menu.Menu;

import java.util.Scanner;

public abstract class Recipe {
    protected boolean checkInBackpack(Objectable item) {
        boolean ret = false;
        for(Objectable objectable : Game.Parsa.backpack.items) {
            if(item.name.equals(objectable.name)) {
                ret = true;
            }
        }
        return ret;
    }

    protected boolean checkInShelf(Cooking item) {
        Cooking check = null;
        for(Cooking tool : Game.farm.home.kitchen.shelf.tools) {
            if(item.name.equals(tool.name)) {
                check = tool;
            }
        }
        return check.isInShelf;
    }

    protected boolean checkIsBroken(Cooking item) {
        Cooking check = null;
        for(Cooking tool : Game.farm.home.kitchen.shelf.tools) {
            if(item.name.equals(tool.name)) {
                check = tool;
            }
        }
        return check.broken;
    }

    protected boolean get(Objectable need, int r, String recipei) {
        boolean ret = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println(recipei + ":");
        System.out.println("Add " + need.name + " x" + r);
        Game.Parsa.backpack.printItems();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                Game.Parsa.backpack.printItems();
            }
            else {
                int i;
                try {
                    i = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command");
                    continue;
                }
                if(i < 1 || i > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(i);
                if(item.name.equals(need.name) && Game.Parsa.backpack.frequency(item) >= r) {
                    for(int j = 0; j < r; j++) {
                        Game.Parsa.backpack.takeItem(item);
                        ret = true;
                    }
                    System.out.println("You have chosen " + r + " " + need.name + "(s)");
                    break;
                }
                else if(item.name.equals(need.name) && Game.Parsa.backpack.frequency(item) < r) {
                    System.out.println("You don't have enough amount of this item.");
                    break;
                }
                else {
                    System.out.println("You have chosen wrong item.");
                }
            }
        }
        return ret;
    }
    public abstract String getStatus();

    public abstract Menu getItemsMenu();
}
