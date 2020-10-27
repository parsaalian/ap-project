package game.environment.Farm.Home.Kitchen.Recipe.Cheesecake_Recipe;

import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.Game;
import game.objectable.Food.Human_Food.Cheesecake.Cheesecake;
import game.objectable.Food.Human_Food.Other_Foods.Cheese.Cheese;
import game.objectable.Food.Human_Food.Other_Foods.Milk.Milk;
import game.objectable.Goods.Food_Goods.Egg.Egg;
import game.objectable.Goods.Food_Goods.Spices.Sugar.Sugar;
import game.objectable.Tools.Cooking.Cooking;
import game.objectable.Tools.Cooking.Mixer.Mixer;
import game.objectable.Tools.Cooking.Oven.Oven;
import game.objectable.Tools.Cooking.Pot.Pot;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cheesecake_Recipe extends Recipe {
    ArrayList<Cooking> tools = new ArrayList<>(Arrays.asList(new Pot(), new Mixer(), new Oven()));
    Cheesecake cheesecake = new Cheesecake();

    public String toString(){
        return "Cheese Cake";
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
            if (checkInBackpack(new Milk()) && get(new Milk(), 1, "Cheesecake")) {
                if (checkInBackpack(new Cheese()) && get(new Cheese(), 1, "Cheesecake")) {
                    if (checkInBackpack(new Egg()) && get(new Egg(), 1, "Cheesecake")) {
                        if (checkInBackpack(new Sugar()) && get(new Sugar(), 1, "Cheesecake")) {
                            cooked = true;
                            Game.Parsa.backpack.putItem(cheesecake);
                            toCook = new Message("You have cooked cheesecake.");
                        } else {
                            toCook = new Message("There is no sugar in backpack.");
                            Game.Parsa.backpack.putItem(new Milk());
                            Game.Parsa.backpack.putItem(new Cheese());
                            Game.Parsa.backpack.putItem(new Egg());
                        }
                    } else {
                        toCook = new Message("There is no egg in backpack.");
                        Game.Parsa.backpack.putItem(new Milk());
                        Game.Parsa.backpack.putItem(new Cheese());
                    }
                } else {
                    toCook = new Message("There is no cheese in backpack.");
                    Game.Parsa.backpack.putItem(new Milk());
                }
            } else {
                toCook = new Message("There is no milk in backpack.");
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
                if (checkInBackpack(new Milk()) && get(new Milk(), 1, "Cheesecake")) {
                    if (checkInBackpack(new Cheese()) && get(new Cheese(), 1, "Cheesecake")) {
                        if (checkInBackpack(new Egg()) && get(new Egg(), 1, "Cheesecake")) {
                            if (checkInBackpack(new Sugar()) && get(new Sugar(), 1, "Cheesecake")) {
                                cooked = true;
                            }
                            else {
                                System.out.println("There is no sugar in backpack.");
                                Game.Parsa.backpack.putItem(new Milk());
                                Game.Parsa.backpack.putItem(new Cheese());
                                Game.Parsa.backpack.putItem(new Egg());
                            }
                        }
                        else {
                            System.out.println("There is no egg in backpack.");
                            Game.Parsa.backpack.putItem(new Milk());
                            Game.Parsa.backpack.putItem(new Cheese());
                        }
                    }
                    else {
                        System.out.println("There is no cheese in backpack.");
                        Game.Parsa.backpack.putItem(new Milk());
                    }
                }
                else {
                    System.out.println("There is no milk in backpack.");
                }
            }
        }
        if (cooked) {
            Game.Parsa.backpack.putItem(cheesecake);
            System.out.println("You have cooked cheesecake.");
        } else {
            System.out.println("You couldn't cook cheesecake.");
        }
    }

    public String getStatus(){
        StringBuilder res = new StringBuilder();
        res.append("Cheesecake:\n");
        res.append("Tools needed:\nPot\nOven\nMixer\n");
        res.append("Ingredients:\nMilk x1\nCheese x1\nEgg x1\nSugar x1\n");
        res.append("Stats:");
        res.append(cheesecake.status());
        return res.toString();
    }

    public void status() {
        System.out.println("Cheesecake:\n");
        System.out.println("Tools needed:\nPot\nOven\nMixer\n");
        System.out.println("Ingredients:\nMilk x1\nCheese x1\nEgg x1\nSugar x1\n");
        System.out.println("Stats:");
        cheesecake.status();
    }
}