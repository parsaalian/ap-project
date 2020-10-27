package game.environment.Farm.Home.Kitchen.Recipe.French_Fries_Recipe;

import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.Game;
import game.objectable.Food.Human_Food.French_Fries.French_Fries;
import game.objectable.Fruits_and_Vegs.Autumn.Potato.Potato;
import game.objectable.Goods.Food_Goods.Oil.Oil;
import game.objectable.Goods.Food_Goods.Spices.Salt.Salt;
import game.objectable.Tools.Cooking.Cooking;
import game.objectable.Tools.Cooking.Frying_Pan.Frying_Pan;
import game.objectable.Tools.Cooking.Knife.Knife;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class French_Fries_Recipe extends Recipe {
    ArrayList<Cooking> tools = new ArrayList<>(Arrays.asList(new Knife(), new Frying_Pan()));
    French_Fries french_fries = new French_Fries();

    public String toString(){
        return "French Fries";
    }

    public Menu getItemsMenu() {
        if (Game.Parsa.backpack.capacity < 1)
            return new Message("You don't have enough capacity.");
        boolean cooked = false;
        boolean hasTools = true;
        boolean hasBroken = false;
        for (Cooking tool : tools) {
            hasTools = hasTools && checkInShelf(tool);
            hasBroken = hasBroken || checkIsBroken(tool);
        }
        Menu menu = new Menu("Do you want to cook this meal? (Y/N)\n" + getStatus());
        MenuItem yes = new MenuItem("Yes"), no = new MenuItem("No");
        menu.addAll(yes, no);
        menu.setBack(no);
        Menu toCook;
        if (!hasTools) {
            toCook = new Message("You don't have the needed tools in shelf.");
        } else if (hasTools && hasBroken) {
            StringBuilder message = new StringBuilder();
            for (Cooking tool : tools) {
                if (tool.broken) {
                    message.append(tool.name + " is broken.");
                }
            }
            toCook = new Message(message.toString());
        } else {
            if (checkInBackpack(new Potato()) && get(new Potato(), 2, "French Fries")) {
                if (checkInBackpack(new Oil()) && get(new Oil(), 1, "French Fries")) {
                    if (checkInBackpack(new Salt()) && get(new Salt(), 1, "French Fries")) {
                        cooked = true;
                        Game.Parsa.backpack.putItem(french_fries);
                        toCook = new Message("You have cooked french fries.");
                    }
                    else {
                        toCook = new Message("There is no salt in backpack.");
                        Game.Parsa.backpack.putItem(new Potato());
                        Game.Parsa.backpack.putItem(new Oil());
                    }
                }
                else {
                    toCook = new Message("There is no oil in backpack.");
                    Game.Parsa.backpack.putItem(new Potato());
                }
            }
            else {
                toCook = new Message("There is no potato in backpack.");
            }
        }
        yes.setGoesTo(toCook);
        return menu;
    }

    public void getItems() {
        Scanner scanner = new Scanner(System.in);
        boolean cooked = false;
        boolean hasTools = true;
        boolean hasBroken = false;
        if (Game.Parsa.backpack.capacity < 1) {
            System.out.println("You don't have enough capacity.");
            return;
        }
        for (Cooking tool : tools) {
            hasTools = hasTools && checkInShelf(tool);
            hasBroken = hasBroken || checkIsBroken(tool);
        }
        status();
        System.out.println("\nDo you want to cook this meal? (Y/N)");
        String yn = scanner.nextLine();
        if (yn.equals("Back")) {

        }
        else if (yn.equals("WhereAmI")) {
            status();
            System.out.println("\nDo you want to cook this meal? (Y/N)");
        }
        else if (yn.equals("Y")) {
            if (!hasTools) {
                System.out.println("You don't have the needed tools in shelf.");
            }
            else if (hasTools && hasBroken) {
                for (Cooking tool : tools) {
                    if (tool.broken) {
                        System.out.println(tool.name + " is broken.");
                    }
                }
            }
            else {
                if (checkInBackpack(new Potato()) && get(new Potato(), 2, "French Fries")) {
                    if (checkInBackpack(new Oil()) && get(new Oil(), 1, "French Fries")) {
                        if (checkInBackpack(new Salt()) && get(new Salt(), 1, "French Fries")) {
                            cooked = true;
                        }
                        else {
                            System.out.println("There is no salt in backpack.");
                            Game.Parsa.backpack.putItem(new Potato());
                            Game.Parsa.backpack.putItem(new Oil());
                        }
                    }
                    else {
                        System.out.println("There is no oil in backpack.");
                        Game.Parsa.backpack.putItem(new Potato());
                    }
                }
                else {
                    System.out.println("There is no potato in backpack.");
                }
            }
            if (cooked) {
                Game.Parsa.backpack.putItem(french_fries);
                System.out.println("You have cooked french fries.");
            }
            else {
                System.out.println("You couldn't cook french fries.");
            }
        }
    }

    public String getStatus() {
        StringBuilder res = new StringBuilder();
        res.append("French Fries:\n");
        res.append("Tools needed:\nKnife\nFrying Pan\n");
        res.append("Ingredients:\nPotato x2\nOil x1\nSalt x1\n");
        res.append("Stats:");
        res.append(french_fries.status());
        return res.toString();
    }

    public void status() {
        System.out.println("French Fries:\n");
        System.out.println("Tools needed:\nKnife\nFrying Pan\n");
        System.out.println("Ingredients:\nPotato x2\nOil x1\nSalt x1\n");
        System.out.println("Stats:");
        french_fries.status();
    }
}
