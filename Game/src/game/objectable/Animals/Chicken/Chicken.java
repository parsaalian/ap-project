package game.objectable.Animals.Chicken;

import game.Game;
import game.objectable.Animals.*;
import game.objectable.Goods.Food_Goods.Egg.Egg;
import game.objectable.Objectable;

import java.util.Scanner;

public class Chicken extends Animals {
    public String name;
    public int numEgg = 0;

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chicken " + name + ":");
        System.out.println("1. Status\n2. Feed this cow\n3. Heal this cow\n4. Milk this cow");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Chicken " + name + ":");
                System.out.println("1. Status\n2. Feed this chicken\n3. Heal this chicken\n4. Egg this chicken");
            }
            else if(line.equals("1")) {
                status();
            }
            else if(line.equals("2")) {
                feedChicken();
            }
            else if(line.equals("3")) {
                heal();
            }
            else if(line.equals("4")) {
                egg();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void feedChicken() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Seed to eat:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose Seed to eat:");
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
                if(!item.name.equals("Seed")) {
                    System.out.println("You have to choose seed.");
                }
                else {
                    System.out.println("Your animal has been feed.");
                    satiety = 100;
                    feedToday = true;
                    Game.Parsa.backpack.takeItem(item);
                    break;
                }
            }
        }
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Chicken " + name + ":\n");
        res.append("Health: " + health + '\n');
        res.append("Satiety: " + satiety + '\n');
        res.append("Feed today: " + feedToday + '\n');
        return res.toString();
    }

    public String egg() {
        StringBuilder res = new StringBuilder();
        if(numEgg == 0) {
            res.append("There is no egg to collect.\n");
        }
        else {
            for(int i = 0; i < numEgg; i++) {
                Game.Parsa.backpack.putItem(new Egg());
            }
            res.append(numEgg + " Eggs added to your backpack.\n");
            numEgg = 0;
        }
        return res.toString();
    }

    public Chicken(String name) {
        super(name, "Chicken");
        this.name = name;
        this.money = 1000;
    }
}
