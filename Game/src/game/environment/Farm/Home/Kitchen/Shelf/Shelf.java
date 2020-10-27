package game.environment.Farm.Home.Kitchen.Shelf;


import game.environment.Farm.Home.Kitchen.Recipe.Cheesecake_Recipe.Cheesecake_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.French_Fries_Recipe.French_Fries_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Mirza_Ghasemi_Recipe.Mirza_Ghasemi_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Shirazi_Salad_Recipe.Shirazi_Salad_Recipe;
import game.Game;
import game.objectable.Objectable;
import game.objectable.Tools.Cooking.Cooking;
import game.objectable.Tools.Cooking.Frying_Pan.Frying_Pan;
import game.objectable.Tools.Cooking.Knife.Knife;
import game.objectable.Tools.Cooking.Mixer.Mixer;
import game.objectable.Tools.Cooking.Oven.Oven;
import game.objectable.Tools.Cooking.Pot.Pot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shelf {
    public ArrayList<Cooking> tools = new ArrayList<>(Arrays.asList(new Frying_Pan(), new Knife(), new Mixer(), new Oven(), new Pot()));
    private French_Fries_Recipe french_fries_recipe = new French_Fries_Recipe();
    private Mirza_Ghasemi_Recipe mirza_ghasemi_recipe = new Mirza_Ghasemi_Recipe();
    private Shirazi_Salad_Recipe shirazi_salad_recipe = new Shirazi_Salad_Recipe();
    private Cheesecake_Recipe cheesecake_recipe = new Cheesecake_Recipe();

    public void inspect() {
        int i = 1;
        for(Cooking tool : tools) {
            System.out.println(i++ + ". " + tool.name);
        }
    }

    public void inspectShelf() {
        Scanner scanner = new Scanner(System.in);
        inspect();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                inspect();
            }
            else {
                int i;
                try {
                    i = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(i > 6 || i < 1) {
                    System.out.println("Out of range.");
                    continue;
                }
                Cooking tool = tools.get(i - 1);
                int b = 0;
                if(!tool.isInShelf) {
                    System.out.println(tool.name + ":\n1. Put this tool in shelf");
                    while (true) {
                        String shelfChoice = scanner.nextLine();
                        if(shelfChoice.equals("Back")) {
                            break;
                        }
                        else if(shelfChoice.equals("WhereAmI")) {
                            System.out.println(tool.name + ":\n1. Put this tool in shelf");
                        }
                        else if(shelfChoice.equals("1")) {
                            System.out.println("Choose " + tool.name + " from your backpack.");
                            Game.Parsa.backpack.printItems();
                            while (true) {
                                String item = scanner.nextLine();
                                if(item.equals("Back")) {
                                    break;
                                }
                                else if(item.equals("WhereAmI")) {
                                    System.out.println("Choose a(n) " + tool.name + " from your backpack.");
                                    Game.Parsa.backpack.printItems();
                                }
                                else {
                                    int j = 0;
                                    try {
                                        j = Integer.parseInt(item);
                                    } catch (Exception e) {
                                        System.out.println("Invalid Command!");
                                    }
                                    if(j > Game.Parsa.backpack.getRange() || j < 1) {
                                        System.out.println("Out of range.");
                                        continue;
                                    }
                                    Objectable getTool = Game.Parsa.backpack.geti(j);
                                    if (getTool.name.equals(tool.name)) {
                                        Game.Parsa.backpack.takeItem(getTool);
                                        tool.isInShelf = true;
                                        System.out.println("You have placed " + tool.name + " in the shelf.");
                                        b = 1;
                                        break;
                                    }
                                    else {
                                        System.out.println("You have to choose a(n) " + tool.name);
                                    }
                                }
                            }
                            if(b == 1) {
                                b = 0;
                                inspect();
                                break;
                            }
                        }
                        else {
                            System.out.println("Invalid Command!");
                        }
                    }
                }
                else {
                    System.out.println(tool.name + ":\n1. Status\n2. Replace this tool\n3. Remove this tool");
                    while (true) {
                        String shelfChoice = scanner.nextLine();
                        if(shelfChoice.equals("Back")) {
                            break;
                        }
                        else if(shelfChoice.equals("WhereAmI")) {
                            System.out.println(tool.name + ":\n1. Status\n2. Replace this tool\n3. Remove this tool");
                        }
                        else if(shelfChoice.equals("1")) {
                            tool.status();
                        }
                        else if(shelfChoice.equals("2")) {
                            tool.isInShelf = false;
                            System.out.println("Choose an item to replace:");
                            Game.Parsa.backpack.printItems();
                            while (true) {
                                String item = scanner.nextLine();
                                if(item.equals("Back")) {
                                    break;
                                }
                                else if(item.equals("WhereAmI")) {
                                    System.out.println("Choose a(n) " + tool.name + " to replace.");
                                    Game.Parsa.backpack.printItems();
                                }
                                else {
                                    int j = 0;
                                    try {
                                        j = Integer.parseInt(item);
                                    } catch (Exception e) {
                                        System.out.println("Invalid Command!");
                                    }
                                    if(j > Game.Parsa.backpack.getRange() || j < 1) {
                                        System.out.println("Out of range.");
                                        continue;
                                    }
                                    Objectable getTool = Game.Parsa.backpack.geti(j);
                                    if (getTool.name.equals(tool.name)) {
                                        Game.Parsa.backpack.takeItem(getTool);
                                        tool.isInShelf = true;
                                        System.out.println("You have replaced " + tool.name + " in the shelf.");
                                        break;
                                    }
                                    else {
                                        System.out.println("You have to choose a(n) " + tool.name);
                                    }
                                }
                            }
                            Game.Parsa.backpack.putItem(tool);
                        }
                        else if(shelfChoice.equals("3")) {
                            tool.isInShelf = false;
                            Game.Parsa.backpack.putItem(tool);
                            System.out.println(tool.name + " has been removed to your backpack.");
                            inspect();
                            break;
                        }
                        else {
                            System.out.println("Invalid Command!");
                        }
                    }
                }
            }
        }
    }



    public void cook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a recipe\n1. French Fries\n2. Mirza Ghasemi\n3. Salad Shirazi\n4. Cheesecake");
        while(true) {
            String food = scanner.nextLine();
            if(food.equals("Back")) {
                break;
            }
            else if(food.equals("WhereAmI")) {
                System.out.println("Choose a recipe\n1. French Fries\n2. Mirza Ghasemi\n3. Salad Shirazi\n4. Cheesecake");
            }
            else if(food.equals("1")) {
                french_fries_recipe.getItems();
            }
            else if(food.equals("2")) {
                mirza_ghasemi_recipe.getItems();
            }
            else if(food.equals("3")) {
                shirazi_salad_recipe.getItems();
            }
            else if(food.equals("4")) {
                cheesecake_recipe.getItems();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
