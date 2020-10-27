package game.environment.Farm.Home.Kitchen.Recipe.Mirza_Ghasemi_Recipe;

import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.Game;
import game.objectable.Food.Human_Food.Mirza_Ghasemi.Mirza_Ghasemi;
import game.objectable.Food.Human_Food.Other_Foods.Cheese.Cheese;
import game.objectable.Food.Human_Food.Other_Foods.Milk.Milk;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;
import game.objectable.Fruits_and_Vegs.Spring.Eggplant.Eggplant;
import game.objectable.Fruits_and_Vegs.Spring.Garlic.Garlic;
import game.objectable.Goods.Food_Goods.Egg.Egg;
import game.objectable.Goods.Food_Goods.Oil.Oil;
import game.objectable.Goods.Food_Goods.Spices.Salt.Salt;
import game.objectable.Goods.Food_Goods.Spices.Sugar.Sugar;
import game.objectable.Tools.Cooking.Cooking;
import game.objectable.Tools.Cooking.Frying_Pan.Frying_Pan;
import game.objectable.Tools.Cooking.Knife.Knife;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mirza_Ghasemi_Recipe extends Recipe {
    ArrayList<Cooking> tools = new ArrayList<>(Arrays.asList(new Knife(), new Frying_Pan()));
    Mirza_Ghasemi mirza_ghasemi = new Mirza_Ghasemi();

    public String toString(){
        return "Mirza Ghasemi";
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
            if (checkInBackpack(new Eggplant()) && get(new Eggplant(), 1, "Mirza Ghasemi")) {
                if (checkInBackpack(new Oil()) && get(new Oil(), 1, "Mirza Ghasemi")) {
                    if (checkInBackpack(new Salt()) && get(new Salt(), 1, "Mirza Ghasemi")) {
                        if (checkInBackpack(new Tomato()) && get(new Tomato(), 2, "Mirza Ghasemi")) {
                            if (checkInBackpack(new Egg()) && get(new Egg(), 2, "Mirza Ghasemi")) {
                                if (checkInBackpack(new Garlic()) && get(new Garlic(), 1, "Mirza Ghasemi")) {
                                    cooked = true;
                                    Game.Parsa.backpack.putItem(mirza_ghasemi);
                                    toCook = new Message("You have cooked mirza ghasemi.");
                                } else {
                                    toCook = new Message("There is no garlic in backpack.");
                                    Game.Parsa.backpack.putItem(new Eggplant());
                                    Game.Parsa.backpack.putItem(new Oil());
                                    Game.Parsa.backpack.putItem(new Salt());
                                    Game.Parsa.backpack.putItem(new Tomato());
                                    Game.Parsa.backpack.putItem(new Tomato());
                                    Game.Parsa.backpack.putItem(new Egg());
                                    Game.Parsa.backpack.putItem(new Egg());
                                }
                            } else {
                                toCook = new Message("There is no egg in backpack.");
                                Game.Parsa.backpack.putItem(new Eggplant());
                                Game.Parsa.backpack.putItem(new Oil());
                                Game.Parsa.backpack.putItem(new Salt());
                                Game.Parsa.backpack.putItem(new Tomato());
                                Game.Parsa.backpack.putItem(new Tomato());
                            }
                        } else {
                            toCook = new Message("There is no tomato in backpack.");
                            Game.Parsa.backpack.putItem(new Eggplant());
                            Game.Parsa.backpack.putItem(new Oil());
                            Game.Parsa.backpack.putItem(new Salt());
                        }
                    } else {
                        toCook = new Message("There is no salt in backpack.");
                        Game.Parsa.backpack.putItem(new Eggplant());
                        Game.Parsa.backpack.putItem(new Oil());
                    }
                } else {
                    toCook = new Message("There is no oil in backpack.");
                    Game.Parsa.backpack.putItem(new Eggplant());
                }
            }
            else {
                toCook = new Message("There is no eggplant in backpack.");
            }
        }
        yes.setGoesTo(toCook);
        return menu;
    }

    public void getItems() {
        Scanner scanner = new Scanner(System.in);
        if(Game.Parsa.backpack.capacity < 1) {
            System.out.println("You don't have enough capacity.");
            return;
        }
        boolean cooked = false;
        boolean hasTools = true;
        boolean hasBroken = false;
        for(Cooking tool : tools) {
            hasTools = hasTools && checkInShelf(tool);
            hasBroken = hasBroken || checkIsBroken(tool);
        }
        status();
        System.out.println("\nDo you want to cook this meal? (Y/N)");
        String yn = scanner.nextLine();
        if(yn.equals("Back")) {

        }
        else if(yn.equals("WhereAmI")) {
            status();
            System.out.println("\nDo you want to cook this meal? (Y/N)");
        }
        else if(yn.equals("Y")) {
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
                if (checkInBackpack(new Eggplant()) && get(new Eggplant(), 1, "Mirza Ghasemi")) {
                    if (checkInBackpack(new Oil()) && get(new Oil(), 1, "Mirza Ghasemi")) {
                        if (checkInBackpack(new Salt()) && get(new Salt(), 1, "Mirza Ghasemi")) {
                            if (checkInBackpack(new Tomato()) && get(new Tomato(), 2, "Mirza Ghasemi")) {
                                if (checkInBackpack(new Egg()) && get(new Egg(), 2, "Mirza Ghasemi")) {
                                    if (checkInBackpack(new Garlic()) && get(new Garlic(), 1, "Mirza Ghasemi")) {
                                        cooked = true;
                                    }
                                    else {
                                        System.out.println("There is no garlic in backpack.");
                                        Game.Parsa.backpack.putItem(new Eggplant());
                                        Game.Parsa.backpack.putItem(new Oil());
                                        Game.Parsa.backpack.putItem(new Salt());
                                        Game.Parsa.backpack.putItem(new Tomato());
                                        Game.Parsa.backpack.putItem(new Tomato());
                                        Game.Parsa.backpack.putItem(new Egg());
                                        Game.Parsa.backpack.putItem(new Egg());
                                    }
                                }
                                else {
                                    System.out.println("There is no egg in backpack.");
                                    Game.Parsa.backpack.putItem(new Eggplant());
                                    Game.Parsa.backpack.putItem(new Oil());
                                    Game.Parsa.backpack.putItem(new Salt());
                                    Game.Parsa.backpack.putItem(new Tomato());
                                    Game.Parsa.backpack.putItem(new Tomato());
                                }
                            }
                            else {
                                System.out.println("There is no tomato in backpack.");
                                Game.Parsa.backpack.putItem(new Eggplant());
                                Game.Parsa.backpack.putItem(new Oil());
                                Game.Parsa.backpack.putItem(new Salt());
                            }
                        }
                        else {
                            System.out.println("There is no salt in backpack.");
                            Game.Parsa.backpack.putItem(new Eggplant());
                            Game.Parsa.backpack.putItem(new Oil());
                        }
                    }
                    else {
                        System.out.println("There is no oil in backpack.");
                        Game.Parsa.backpack.putItem(new Eggplant());
                    }
                }
                else {
                    System.out.println("There is no eggplant in backpack.");
                }
            }
        }
        if (cooked) {
            Game.Parsa.backpack.putItem(mirza_ghasemi);
            System.out.println("You have cooked mirza ghasemi.");
        }
        else {
            System.out.println("You couldn't cook mirza ghasemi.");
        }
    }

    public String getStatus(){
        StringBuilder res = new StringBuilder();
        res.append("Mirza Ghasemi:\n");
        res.append("Tools needed:\nKnife\nFrying Pan\n");
        res.append("Ingredients:\nEggplant x1\nOil x1\nSalt x1\nTomato x2\nEgg x2\nGarlic x1\n");
        res.append("Stats:");
        res.append(mirza_ghasemi.status());
        return res.toString();
    }

    public void status() {
        System.out.println("Mirza Ghasemi:\n");
        System.out.println("Tools needed:\nKnife\nFrying Pan\n");
        System.out.println("Ingredients:\nEggplant x1\nOil x1\nSalt x1\nTomato x2\nEgg x2\nGarlic x1\n");
        System.out.println("Stats:");
        mirza_ghasemi.status();
    }
}
