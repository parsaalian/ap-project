package game.objectable;

import game.*;

import java.util.Random;
import java.util.Scanner;

public class Objectable {
    public int inspectType;
    public int capacity = 1;
    public int money = 0;
    public String name;
    public String type;
    public boolean broken;
    public Game game;

    public Objectable() {

    }

    public void inspect1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ":");
        System.out.println("1. Status\n2. Use\n3. Drop this item");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println(name + ":");
                System.out.println("1. Status\n2. Use\n3. Drop this item");
            }
            else if(line.equals("1")) {
                this.status();
            }
            else if(line.equals("2")) {
                this.use();
                Game.Parsa.backpack.takeItem(this);
                break;
            }
            else if(line.equals("3")) {
                System.out.println(name + " dropped.");
                Game.Parsa.backpack.takeItem(this);
                break;
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void inspect2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ":");
        System.out.println("1. Status\n2. Drop this item");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println(name + ":");
                System.out.println("1. Status\n2. Drop this item");
            }
            else if(line.equals("1")) {
                this.status();
            }
            else if(line.equals("2")) {
                System.out.println(name + " dropped.");
                Game.Parsa.backpack.takeItem(this);
                break;
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public String status(){ return null; }

    public String use(){ return null; }

    public boolean breaking(int p) {
        Random random = new Random();
        int a = random.nextInt(100);
        if(a < p) {
            this.broken = true;
        }
        return broken;
    }

    public Objectable(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
