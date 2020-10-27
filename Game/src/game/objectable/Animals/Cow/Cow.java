package game.objectable.Animals.Cow;

import game.Game;
import game.objectable.Animals.*;
import game.objectable.Food.Human_Food.Other_Foods.Milk.Milk;
import game.objectable.Objectable;

import java.util.Scanner;

public class Cow extends Animals {
    public String name;

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cow " + name + ":");
        System.out.println("1. Status\n2. Feed this cow\n3. Heal this cow\n4. Milk this cow");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Cow " + name + ":");
                System.out.println("1. Status\n2. Feed this cow\n3. Heal this cow\n4. Milk this cow");
            }
            else if(line.equals("1")) {
                status();
            }
            else if(line.equals("2")) {
                feedCowAndSheep();
            }
            else if(line.equals("3")) {
                heal();
            }
            else if(line.equals("4")) {
                milk();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Cow " + name + ":\n");
        res.append("Health: " + health + '\n');
        res.append("Satiety: " + satiety + '\n');
        res.append("Feed today: " + feedToday + '\n');
        return res.toString();
    }

    public void milk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Milker:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose a Milker:");
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
                if(!item.name.equals("Milker")) {
                    System.out.println("You have to choose a milker.");
                }
                else {
                    System.out.println("Your cow has been milked.");
                    Game.Parsa.backpack.putItem(new Milk());
                    if(item.breaking(10)) {
                        System.out.println("Your Milker has been broken.");
                    }
                }
            }
        }
    }

    public Cow(String name) {
        super(name, "Cow");
        this.name = name;
        this.money = 4000;
    }
}
