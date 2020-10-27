package game.environment.Jungle.Cave;

import game.environment.Jungle.Stones.Stones;

import java.util.Scanner;

public class Cave {
    private Stones stones = new Stones();

    public void inspectRocks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rocks:\n1. Collect Stone\n2. Collect Iron Ore\n3. Collect Silver Ore\n4. Collect Adamantium Ore");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Rocks:\n1. Collect Stone\n2. Collect Iron Ore\n3. Collect Silver Ore\n4. Collect Adamantium Ore");
            }
            else if(line.equals("1")) {
                stones.collectStones();
            }
            else if(line.equals("2")) {
                stones.collectIron();
            }
            else if(line.equals("3")) {
                stones.collectSilver();
            }
            else if(line.equals("4")) {
                stones.collectAdamantium();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
