package game.environment.Village.Ranch;

import game.Game;
import game.objectable.Animals.Animals;
import game.objectable.Animals.Chicken.Chicken;
import game.objectable.Animals.Cow.Cow;
import game.objectable.Animals.Sheep.Sheep;
import game.objectable.Food.Animal_Food.Alfalfa.Alfalfa;
import game.objectable.Food.Animal_Food.Seed.Seed;
import game.objectable.Medicine.Animal_Medicine.Animal_Medicine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ranch {
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Village"));
    public ArrayList<Animals> animals = new ArrayList<>(Arrays.asList(new Cow("1"), new Sheep("1"), new Chicken("1")));

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ranch\n1. Check this shop\n2. Buy and item\n3. Buy an animal");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("WhereAmI")) {
                System.out.println("Ranch\n1. Check this shop\n2. Buy and item\n3. Buy an animal");
            }
            else if(line.equals("GoTo Village")) {
                Game.Parsa.goTo("Village");
                break;
            }
            else if(line.equals("1")) {
                check();
            }
            else if(line.equals("2")) {
                buyItem();
            }
            else if(line.equals("3")) {
                buyAnimal();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Animals:\n1. Cows\n2. Sheep\n3. Chickens");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Animals:\n1. Cows\n2. Sheep\n3. Chickens");
            }
            else if(line.equals("1")) {
                animals.get(0).sellStatus();
            }
            else if(line.equals("2")) {
                animals.get(1).sellStatus();
            }
            else if(line.equals("3")) {
                animals.get(2).sellStatus();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void buyItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Items you can buy:\n1. Animal medicine (for all animals)\n2. Alfalfa (for cows and sheep)\n3. Seed (for chicken)");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Items you can buy:\n1. Animal medicine (for all animals)\n2. Alfalfa (for cows and sheep)\n3. Seed (for chicken)");
            }
            else if(line.equals("1")) {
                System.out.println("How many of this item you want to buy?");
                while (true) {
                    Animal_Medicine animal_medicine = new Animal_Medicine();
                    String num = scanner.nextLine();
                    if(num.equals("Back")) {
                        break;
                    }
                    else if(num.equals("WhereAmI")) {
                        System.out.println("How many of this item you want to buy?");
                    }
                    else {
                        int j;
                        try {
                            j = Integer.parseInt(num);
                        } catch (Exception e) {
                            System.out.println("Invalid Command!");
                            continue;
                        }
                        System.out.println("Do you want to buy " + animal_medicine.name + " x" + j + " for " + j * animal_medicine.money + " Gil? (Y/N)");
                        while (true) {
                            String yn = scanner.nextLine();
                            if(yn.equals("Back") || yn.equals("N")) {
                                break;
                            }
                            else if(yn.equals("WhereAmI")) {
                                System.out.println("Do you want to buy " + animal_medicine.name + " x" + j + " for " + j * animal_medicine.money + " Gil? (Y/N)");
                            }
                            else {
                                if (Game.Parsa.money < j * animal_medicine.money) {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                                if (Game.Parsa.backpack.capacity < j) {
                                    System.out.println("You don't have enough capacity.");
                                    break;
                                }
                                System.out.println("You have bought x" + j + " " + animal_medicine.name + "(s).");
                                Game.Parsa.money -= j * animal_medicine.money;
                                for(int i = 0; i < j; i++) {
                                    Game.Parsa.backpack.putItem(new Animal_Medicine());
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            else if(line.equals("2")) {
                System.out.println("How many of this item you want to buy?");
                while (true) {
                    Alfalfa alfalfa = new Alfalfa();
                    String num = scanner.nextLine();
                    if(num.equals("Back")) {
                        break;
                    }
                    else if(num.equals("WhereAmI")) {
                        System.out.println("How many of this item you want to buy?");
                    }
                    else {
                        int j;
                        try {
                            j = Integer.parseInt(num);
                        } catch (Exception e) {
                            System.out.println("Invalid Command!");
                            continue;
                        }
                        System.out.println("Do you want to buy " + alfalfa.name + " x" + j + " for " + j * alfalfa.money + " Gil? (Y/N)");
                        while (true) {
                            String yn = scanner.nextLine();
                            if(yn.equals("Back") || yn.equals("N")) {
                                break;
                            }
                            else if(yn.equals("WhereAmI")) {
                                System.out.println("Do you want to buy " + alfalfa.name + " x" + j + " for " + j * alfalfa.money + " Gil? (Y/N)");
                            }
                            else {
                                if (Game.Parsa.money < j * alfalfa.money) {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                                if (Game.Parsa.backpack.capacity < j) {
                                    System.out.println("You don't have enough capacity.");
                                    break;
                                }
                                System.out.println("You have bought x" + j + " " + alfalfa.name + "(s).");
                                Game.Parsa.money -= j * alfalfa.money;
                                for(int i = 0; i < j; i++) {
                                    Game.Parsa.backpack.putItem(new Alfalfa());
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            else if(line.equals("3")) {
                System.out.println("How many of this item you want to buy?");
                while (true) {
                    Seed seed = new Seed();
                    String num = scanner.nextLine();
                    if(num.equals("Back")) {
                        break;
                    }
                    else if(num.equals("WhereAmI")) {
                        System.out.println("How many of this item you want to buy?");
                    }
                    else {
                        int j;
                        try {
                            j = Integer.parseInt(num);
                        } catch (Exception e) {
                            System.out.println("Invalid Command!");
                            continue;
                        }
                        System.out.println("Do you want to buy " + seed.name + " x" + j + " for " + j * seed.money + " Gil? (Y/N)");
                        while (true) {
                            String yn = scanner.nextLine();
                            if(yn.equals("Back") || yn.equals("N")) {
                                break;
                            }
                            else if(yn.equals("WhereAmI")) {
                                System.out.println("Do you want to buy " + seed.name + " x" + j + " for " + j * seed.money + " Gil? (Y/N)");
                            }
                            else {
                                if (Game.Parsa.money < j * seed.money) {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                                if (Game.Parsa.backpack.capacity < j) {
                                    System.out.println("You don't have enough capacity.");
                                    break;
                                }
                                System.out.println("You have bought x" + j + " " + seed.name + "(s).");
                                Game.Parsa.money -= j * seed.money;
                                for(int i = 0; i < j; i++) {
                                    Game.Parsa.backpack.putItem(new Seed());
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void buyAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Animals:\n1. Cow\n2. Sheep\n3. Chicken");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Animals:\n1. Cows\n2. Sheep\n3. Chickens");
            }
            else if(line.equals("1")) {
                sell(animals.get(0));
            }
            else if(line.equals("2")) {
                sell(animals.get(1));
            }
            else if(line.equals("3")) {
                sell(animals.get(2));
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void sell(Animals animal) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many of this animal do you want to buy?");
        while (true) {
            String r = scanner.nextLine();
            if(r.equals("Back")) {
                break;
            }
            else if(r.equals("WhereAmI")) {
                System.out.println("How many of this animal do you want to buy?");
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(r);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");

                    continue;
                }
                if(animal.type.equals("Cow")) {
                    if(j < Game.farm.barn.getCapCow()) {
                        if(Game.Parsa.money >= j * animal.money) {
                            for(int i = 0; i < j; i++) {
                                System.out.println("Choose a name for your cow:");
                                String name = scanner.nextLine();
                                if(Game.farm.barn.cowName(name)) {
                                    Game.farm.barn.cows.add(new Cow(name));
                                    System.out.println("Cow " + name + " added to your barn.");
                                }
                                else {
                                    System.out.println("This name is used.");
                                    i--;
                                }
                            }
                            Game.Parsa.money -= j * animal.money;
                        }
                        else {
                            System.out.println("You don't have enough money.");
                        }
                    }
                    else {
                        System.out.println("Your barn doesn't have enough capacity.");
                    }
                }
                else if(animal.type.equals("Sheep")) {
                    if(j < Game.farm.barn.getCapSheep()) {
                        if(Game.Parsa.money >= j * animal.money) {
                            for(int i = 0; i < j; i++) {
                                System.out.println("Choose a name for your sheep:");
                                String name = scanner.nextLine();
                                if(Game.farm.barn.sheepName(name)) {
                                    Game.farm.barn.sheeps.add(new Sheep(name));
                                    System.out.println("Sheep " + name + " added to your barn.");
                                }
                                else {
                                    System.out.println("This name is used.");
                                    i--;
                                }
                            }
                            Game.Parsa.money -= j * animal.money;
                        }
                        else {
                            System.out.println("You don't have enough money.");
                        }
                    }
                    else {
                        System.out.println("Your barn doesn't have enough capacity.");
                    }
                }
                else if(animal.type.equals("Chicken")) {
                    if(j < Game.farm.barn.getCapChicken()) {
                        if(Game.Parsa.money >= j * animal.money) {
                            for(int i = 0; i < j; i++) {
                                System.out.println("Choose a name for your chicken:");
                                String name = scanner.nextLine();
                                if(Game.farm.barn.chickenName(name)) {
                                    Game.farm.barn.chickens.add(new Chicken(name));
                                    System.out.println("Chicken " + name + " added to your barn.");
                                }
                                else {
                                    System.out.println("This name is used.");
                                    i--;
                                }
                            }
                            Game.Parsa.money -= j * animal.money;
                        }
                        else {
                            System.out.println("You don't have enough money.");
                        }
                    }
                    else {
                        System.out.println("Your barn doesn't have enough capacity.");
                    }
                }
            }
        }
    }
}