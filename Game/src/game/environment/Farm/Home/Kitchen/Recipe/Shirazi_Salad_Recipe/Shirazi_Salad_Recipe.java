package game.environment.Farm.Home.Kitchen.Recipe.Shirazi_Salad_Recipe;

import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.Game;
import game.objectable.Food.Human_Food.Other_Foods.Juice.Lemon_Juice.Lemon_Juice;
import game.objectable.Food.Human_Food.Shirazi_Salad.Shirazi_Salad;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;
import game.objectable.Fruits_and_Vegs.Summer.Cucumber.Cucumber;
import game.objectable.Fruits_and_Vegs.Summer.Onion.Onion;
import game.objectable.Tools.Cooking.Cooking;
import game.objectable.Tools.Cooking.Knife.Knife;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shirazi_Salad_Recipe extends Recipe {
    ArrayList<Cooking> tools = new ArrayList<>(Arrays.asList(new Knife()));
    Shirazi_Salad shirazi_salad = new Shirazi_Salad();

    public String toString(){
        return "Salad Shirazi";
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
            if (checkInBackpack(new Cucumber()) && get(new Cucumber(), 1, "Salad Shirazi")) {
                if (checkInBackpack(new Tomato()) && get(new Tomato(), 1, "Salad Shirazi")) {
                    if (checkInBackpack(new Onion()) && get(new Onion(), 1, "Salad Shirazi")) {
                        if (checkInBackpack(new Lemon_Juice()) && get(new Lemon_Juice(), 1, "Salad Shirazi")) {
                            cooked = true;
                            Game.Parsa.backpack.putItem(shirazi_salad);
                            toCook = new Message("You have cooked salad shirazi.");
                        }
                        else {
                            toCook = new Message("There is no Lemon Juice in backpack.");
                            Game.Parsa.backpack.putItem(new Tomato());
                            Game.Parsa.backpack.putItem(new Cucumber());
                            Game.Parsa.backpack.putItem(new Onion());
                        }
                    }
                    else {
                        toCook = new Message(("There is no onion in backpack."));
                        Game.Parsa.backpack.putItem(new Tomato());
                        Game.Parsa.backpack.putItem(new Cucumber());
                    }
                }
                else {
                    toCook = new Message(("There is no tomato in backpack."));
                    Game.Parsa.backpack.putItem(new Cucumber());
                }
            }
            else {
                toCook = new Message(("There is no cucumber in backpack."));
            }
        }
        yes.setGoesTo(toCook);
        return menu;
    }

    public void getItems() {
        Scanner scanner = new Scanner(System.in);
        if (Game.Parsa.backpack.capacity < 1) {
            System.out.println("You don't have enough capacity.");
            return;
        }
        boolean cooked = false;
        boolean hasTools = true;
        boolean hasBroken = false;
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
            else if(hasTools && hasBroken) {
                for (Cooking tool : tools) {
                    if (tool.broken) {
                        System.out.println(tool.name + " is broken.");
                    }
                }
            }
            else {
                if (checkInBackpack(new Cucumber()) && get(new Cucumber(), 1, "Salad Shirazi")) {
                    if (checkInBackpack(new Tomato()) && get(new Tomato(), 1, "Salad Shirazi")) {
                        if (checkInBackpack(new Onion()) && get(new Onion(), 1, "Salad Shirazi")) {
                            if (checkInBackpack(new Lemon_Juice()) && get(new Lemon_Juice(), 1, "Salad Shirazi")) {
                                cooked = true;
                            }
                            else {
                                System.out.println("There is no Lemon Juice in backpack.");
                                Game.Parsa.backpack.putItem(new Tomato());
                                Game.Parsa.backpack.putItem(new Cucumber());
                                Game.Parsa.backpack.putItem(new Onion());
                            }
                        }
                        else {
                            System.out.println("There is no onion in backpack.");
                            Game.Parsa.backpack.putItem(new Tomato());
                            Game.Parsa.backpack.putItem(new Cucumber());
                        }
                    }
                    else {
                        System.out.println("There is no tomato in backpack.");
                        Game.Parsa.backpack.putItem(new Cucumber());
                    }
                }
                else {
                    System.out.println("There is no cucumber in backpack.");
                }
            }
        }
        if (cooked) {
            Game.Parsa.backpack.putItem(shirazi_salad);
            System.out.println("You have cooked salad shirazi.");
        } else {
            System.out.println("You couldn't cook salad shirazi.");
        }
    }

    public String getStatus(){
        StringBuilder res = new StringBuilder();
        res.append("Salad Shirazi:\n");
        res.append("Tools needed:\nKnife\n");
        res.append("Ingredients:\nCucumber x1\nTomato x1\nLemon Juice x1\nOnion x1\n");
        res.append("Stats:");
        res.append(shirazi_salad.status());
        return res.toString();
    }

    public void status() {
        System.out.println("Salad Shirazi:\n");
        System.out.println("Tools needed:\nKnife\n");
        System.out.println("Ingredients:\nCucumber x1\nTomato x1\nLemon Juice x1\nOnion x1\n");
        System.out.println("Stats:");
        shirazi_salad.status();
    }
}
