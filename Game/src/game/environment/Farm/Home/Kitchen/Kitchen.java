package game.environment.Farm.Home.Kitchen;

import game.environment.Farm.Home.Kitchen.Recipe.Cheesecake_Recipe.Cheesecake_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.French_Fries_Recipe.French_Fries_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Mirza_Ghasemi_Recipe.Mirza_Ghasemi_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Shirazi_Salad_Recipe.Shirazi_Salad_Recipe;
import game.environment.Farm.Home.Kitchen.Shelf.*;
import graphic.Menu.Menu;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kitchen {
    public Shelf shelf = new Shelf();

    public void inspect() {
        System.out.println("Kitchen\n1. Cook a meal\n2. Check Tool Shelf\n3. Check recipes");
    }

    public void inspectKitchen() {
        Scanner scanner = new Scanner(System.in);
        inspect();
        label:
        while (true) {
            String cook = scanner.nextLine();
            switch (cook) {
                case "Back":
                    break label;
                case "WhereAmI":
                    inspect();
                    break;
                case "1":
                    shelf.cook();
                    break;
                case "2":
                    shelf.inspectShelf();
                    break;
                case "3":
                    recipesCheck();
                    break;
            }
        }
    }

    public List<Recipe> getRecipesCheck() {
        return Arrays.asList(
                new French_Fries_Recipe(),
                new Mirza_Ghasemi_Recipe(),
                new Shirazi_Salad_Recipe(),
                new Cheesecake_Recipe());
    }

    private void recipesCheck() {
        French_Fries_Recipe french_fries_recipe = new French_Fries_Recipe();
        Mirza_Ghasemi_Recipe mirza_ghasemi_recipe = new Mirza_Ghasemi_Recipe();
        Shirazi_Salad_Recipe shirazi_salad_recipe = new Shirazi_Salad_Recipe();
        Cheesecake_Recipe cheesecake_recipe = new Cheesecake_Recipe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a recipe\n1. French Fries\n2. Mirza Ghasemi\n3. Salad Shirazi\n4. Cheesecake");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose a recipe\n1. French Fries\n2. Mirza Ghasemi\n3. Salad Shirazi\n4. Cheesecake");
            }
            else if(line.equals("1")) {
                french_fries_recipe.status();
            }
            else if(line.equals("2")) {
                mirza_ghasemi_recipe.status();
            }
            else if(line.equals("3")) {
                shirazi_salad_recipe.status();
            }
            else if(line.equals("4")) {
                cheesecake_recipe.status();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
