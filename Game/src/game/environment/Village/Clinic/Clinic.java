package game.environment.Village.Clinic;

import game.Game;
import game.objectable.Medicine.Animal_Medicine.Animal_Medicine;
import game.objectable.Medicine.Medicine;
import game.objectable.Medicine.Ordinary_Medicine.Ordinary_Medicine;
import game.objectable.Medicine.Strong_Medicine.Strong_Medicine;
import game.objectable.Medicine.Super_Medicine.Super_Medicine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Clinic {
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Village"));
    private ArrayList<Medicine> items = new ArrayList<>(Arrays.asList(new Ordinary_Medicine(), new Strong_Medicine(), new Super_Medicine(), new Animal_Medicine()));

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Clinic\n1. Check this shop\n2. Buy an item\n3. Heal up");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("WhereAmI")) {
                System.out.println("Clinic\n1. Check this shop\n2. Buy an item\n3. Heal up");
            }
            else if(line.equals("GoTo Village")) {
                Game.Parsa.goTo("Village");
                break;
            }
            else if(line.equals("1")) {
                check();
            }
            else if(line.equals("2")) {
                buy();
            }
            else if(line.equals("3")) {
                heal();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Medicines\n1. Ordinary Medicine\n2. Strong Medicine\n3. Super Medicine\n4. Animal Medicine");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Medicines\n1. Ordinary Medicine\n2. Strong Medicine\n3. Super Medicine\n4. Animal Medicine");
            }
            else if(line.equals("1")) {
                items.get(0).status();
            }
            else if(line.equals("2")) {
                items.get(1).status();
            }
            else if(line.equals("3")) {
                items.get(2).status();
            }
            else if(line.equals("4")) {
                items.get(3).status();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buy Medicines\n1. Ordinary Medicine\n2. Strong Medicine\n3. Super Medicine\n4. Animal Medicine");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            if(line.equals("WhereAmI")) {
                System.out.println("Buy Medicines\n1. Ordinary Medicine\n2. Strong Medicine\n3. Super Medicine\n4. Animal Medicine");
            }
            else if(line.equals("1")) {
                items.get(0).buy();
            }
            else if(line.equals("2")) {
                items.get(1).buy();
            }
            else if(line.equals("3")) {
                items.get(2).buy();
            }
            else if(line.equals("4")) {
                items.get(3).buy();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void heal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will Heal up for 500 Gil. Is this okay? (Y/N)");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back") || line.equals("N")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("You will Heal up for 500 Gil. Is this okay? (Y/N)");
            }
            else {
                if(Game.Parsa.money < 500) {
                    System.out.println("You don't have enough money.");
                    break;
                }
                System.out.println("You have been healed.");
                Game.Parsa.money -= 500;
                Game.Parsa.health = Game.Parsa.maxHealth;
                break;
            }
        }
    }
}