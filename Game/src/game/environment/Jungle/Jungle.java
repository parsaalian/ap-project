package game.environment.Jungle;

import game.environment.Environment;
import game.environment.Jungle.Cave.Cave;
import game.environment.Jungle.River.River;
import game.environment.Jungle.Stones.Stones;
import game.environment.Jungle.Woods.Woods;
import graphic.Menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jungle extends Environment {
    public Woods woods = new Woods();
    public Stones stones = new Stones();
    public River river = new River();
    public Cave cave = new Cave();
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Cave", "Farm"));

    public void inspectRocks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rocks:\n1. Collect Stones");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Rocks:\n1. Collect Stones");
            }
            else if(line.equals("1")) {
                stones.collectStones();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void inspectWoods() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Woods:\n1. Collect Branch\n2. Collect Old Lumber\n3. Collect Pine Lumber\n4. Collect Oak Lumber");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Woods:\n1. Collect Branch\n2. Collect Old Lumber\n3. Collect Pine Limber\n4. Collect Oak Lumber");
            }
            else if(line.equals("1")) {
                woods.collectBranch();
            }
            else if(line.equals("2")) {
                woods.collectOldLumber();
            }
            else if(line.equals("3")) {
                woods.collectPineLumeber();
            }
            else if(line.equals("4")) {
                woods.collectOakLumber();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void inspectRiver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("River:\n1. Start Fishing");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("River:\n1. Start Fishing");
            }
            else if(line.equals("1")) {
                river.fish();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public Jungle() {
        super();
    }
}
