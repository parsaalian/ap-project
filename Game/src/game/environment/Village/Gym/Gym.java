package game.environment.Village.Gym;

import game.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gym {
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Village"));

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gym:\n1. Health\n2. Energy");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Gym:\n1. Health\n2. Energy");
            }
            else if(line.equals("GoTo Village")) {
                Game.Parsa.goTo("Village");
                break;
            }
            else if(line.equals("1")) {
                healthMenu();
            }
            else if(line.equals("2")) {
                energyMenu();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void healthMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Improve Health:\n1. Max amount\n2. Refill rate\n3. Consumption rate");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Improve Health:\n1. Max amount\n2. Refill rate\n3. Consumption rate");
            }
            else if(line.equals("1")) {
                System.out.println("Health max amount:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Health max amount:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will add your health max amount 100 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.maxHealth == 1000) {
                            System.out.println("You have the highest max health.");
                            break;
                        }
                        System.out.println("This training will cost you " + Game.Parsa.maxHealth + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + Game.Parsa.maxHealth + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= Game.Parsa.maxHealth) {
                                    System.out.println("Your max health amount added 100 points.");
                                    Game.Parsa.money -= Game.Parsa.maxHealth;
                                    Game.Parsa.maxHealth += 100;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else if(line.equals("2")) {
                System.out.println("Health Refill rate:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Health Refill rate:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will add your health refill rate 20 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.healthRefill == 200) {
                            System.out.println("You have the highest health refill rate.");
                            break;
                        }
                        System.out.println("This training will cost you " + 10 * (-50 + Game.Parsa.healthRefill) + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + 10 * (-50 + Game.Parsa.healthRefill) + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= 10 * (-50 + Game.Parsa.healthRefill)) {
                                    System.out.println("Your health refill rate added 20 points.");
                                    Game.Parsa.money -= 10 * (-50 + Game.Parsa.healthRefill);
                                    Game.Parsa.healthRefill += 20;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else if(line.equals("3")) {
                System.out.println("Health Consumption rate:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Health Consumption rate:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will lower your health consumption rate 10 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.healthCons == 50) {
                            System.out.println("You have the lowest health consumption rate.");
                            break;
                        }
                        System.out.println("This training will cost you " + 5 * (-Game.Parsa.healthCons + 150) + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + 5 * (-Game.Parsa.healthCons + 150) + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= 5 * (-Game.Parsa.healthCons + 150)) {
                                    System.out.println("Your health refill rate lowered 10 points.");
                                    Game.Parsa.money -= 5 * (-Game.Parsa.healthCons + 150);
                                    Game.Parsa.healthCons -= 10;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private void energyMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Improve Energy:\n1. Max amount\n2. Refill rate\n3. Consumption rate");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Improve Energy:\n1. Max amount\n2. Refill rate\n3. Consumption rate");
            }
            else if(line.equals("1")) {
                System.out.println("Energy max amount:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Energy max amount:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will add your energy max amount 200 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.maxEnergy == 2000) {
                            System.out.println("You have the highest max energy.");
                            break;
                        }
                        System.out.println("This training will cost you " + Game.Parsa.maxEnergy + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + (Game.Parsa.maxEnergy / 2) + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= (Game.Parsa.maxEnergy / 2)) {
                                    System.out.println("Your max energy amount added 200 points.");
                                    Game.Parsa.money -= Game.Parsa.maxEnergy / 2;
                                    Game.Parsa.maxEnergy += 200;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else if(line.equals("2")) {
                System.out.println("Energy Refill rate:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Energy Refill rate:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will add your energy refill rate 20 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.energyRefill == 200) {
                            System.out.println("You have the highest energy refill rate.");
                            break;
                        }
                        System.out.println("This training will cost you " + 10 * (-50 + Game.Parsa.energyRefill) + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + 10 * (-50 + Game.Parsa.energyRefill) + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= 10 * (-50 + Game.Parsa.energyRefill)) {
                                    System.out.println("Your energy refill rate added 20 points.");
                                    Game.Parsa.money -= 10 * (-50 + Game.Parsa.energyRefill);
                                    Game.Parsa.energyRefill += 20;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else if(line.equals("3")) {
                System.out.println("Energy Consumption rate:\n1. Status\n2. Train");
                while (true) {
                    String st = scanner.nextLine();
                    if(st.equals("Back")) {
                        break;
                    }
                    else if(st.equals("WhereAmI")) {
                        System.out.println("Energy Consumption rate:\n1. Status\n2. Train");
                    }
                    else if(st.equals("1")) {
                        System.out.println("This training will lower your energy consumption rate 10 points.");
                    }
                    else if(st.equals("2")) {
                        if(Game.Parsa.energyCons == 50) {
                            System.out.println("You have the lowest energy consumption rate.");
                            break;
                        }
                        System.out.println("This training will cost you " + 5 * (-Game.Parsa.energyCons + 150) + " Gil. Is this okay? (Y/N)");
                        while (true) {
                            String c = scanner.nextLine();
                            if(c.equals("Back") || c.equals("N")) {
                                break;
                            }
                            else if(c.equals("WhereAmI")) {
                                System.out.println("This training will cost you " + 5 * (-Game.Parsa.energyCons + 150) + " Gil. Is this okay? (Y/N)");
                            }
                            else if(c.equals("Y")) {
                                if(Game.Parsa.money >= 5 * (-Game.Parsa.energyCons + 150)) {
                                    System.out.println("Your energy refill rate lowered 10 points.");
                                    Game.Parsa.money -= 5 * (-Game.Parsa.energyCons + 150);
                                    Game.Parsa.energyCons -= 10;
                                    break;
                                }
                                else {
                                    System.out.println("You don't have enough money.");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
}