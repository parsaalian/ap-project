package game.environment.Farm.Barn;

import game.objectable.Animals.Chicken.*;
import game.objectable.Animals.Sheep.*;
import game.objectable.Animals.Cow.*;
import game.objectable.Machines.*;
import game.objectable.Machines.Spinning.Spinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Barn {

    public int getCapCow() {
        return 5 - cows.size();
    }

    public int getCapSheep() {
        return 5 - sheeps.size();
    }

    public int getCapChicken() {
        return 10 - chickens.size();
    }

    public boolean cowName(String name) {
        for(Cow cow : cows) {
            if(cow.name.equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean sheepName(String name) {
        for(Sheep sheep : sheeps) {
            if(sheep.name.equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean chickenName(String name) {
        for(Chicken chicken : chickens) {
            if(chicken.name.equals(name)) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Sheep> sheeps = new ArrayList<>(Arrays.asList(new Sheep("Steve")));
    public ArrayList<Cow> cows = new ArrayList<>(Arrays.asList(new Cow("Jobs")));
    public ArrayList<Chicken> chickens = new ArrayList<>(Arrays.asList(new Chicken("Who")));
    public ArrayList<Machines> machines = new ArrayList<>(Arrays.asList(new Spinning()));

    private void sheepsMenu() {
        int i = 1;
        System.out.println("Sheep in the barn:");
        for(Sheep sheep : sheeps) {
            System.out.println(i++ + ". " + sheep.name);
        }
    }

    public void inspectSheeps() {
        Scanner scanner = new Scanner(System.in);
        sheepsMenu();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                sheepsMenu();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > sheeps.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Sheep sheep = sheeps.get(j - 1);
                sheep.inspect();
            }
        }
    }

    private void cowsMenu() {
        int i = 1;
        System.out.println("Cows in the barn:");
        for(Cow cow : cows) {
            System.out.println(i++ + ". " + cow.name);
        }
    }

    public void inspectCows() {
        Scanner scanner = new Scanner(System.in);
        cowsMenu();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                cowsMenu();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > cows.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Cow cow = cows.get(j - 1);
                cow.inspect();
            }
        }
    }

    private void chickenMenu() {
        int i = 1;
        System.out.println("Chickens in the barn:");
        for(Chicken chicken : chickens) {
            System.out.println(i++ + ". " + chicken.name);
        }
    }

    public void inspectChicken() {
        Scanner scanner = new Scanner(System.in);
        chickenMenu();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                chickenMenu();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > chickens.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Chicken chicken = chickens.get(j - 1);
                chicken.inspect();
            }
        }
    }

    private void machinesMenu() {
        int i = 1;
        System.out.println("Machines in the barn:");
        for(Machines machine : machines) {
            System.out.println(i++ + ". " + machine.name);
        }
    }

    public void inspectMachines() {
        Scanner scanner = new Scanner(System.in);
        machinesMenu();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                machinesMenu();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > machines.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Machines machine = machines.get(j - 1);
                machine.inspect();
            }
        }
    }
}
