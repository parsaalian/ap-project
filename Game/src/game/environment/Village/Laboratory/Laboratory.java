package game.environment.Village.Laboratory;

import game.Game;
import game.objectable.Machines.Cheese_Maker.Cheese_Maker;
import game.objectable.Machines.Juicer.Juicer;
import game.objectable.Machines.Machines;
import game.objectable.Machines.Spinning.Spinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Laboratory {
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Village"));
    private ArrayList<Machines> machines = new ArrayList<>(Arrays.asList(new Cheese_Maker(), new Juicer(), new Spinning()));

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Laboratory\n1. Check machines\n2. Build a machine");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("WhereAmI")) {
                System.out.println("Laboratory\n1. Check machines\n2. Build a machine");
            }
            else if(line.equals("GoTo Village")) {
                Game.Parsa.goTo("Village");
                break;
            }
            else if(line.equals("1")) {
                check();
            }
            else if(line.equals("2")) {
                build();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    private String machineMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        res.append("Machines:\n");
        for (Machines machine : machines) {
            res.append(i++ + ". " + machine.name + '\n');
        }
        return res.toString();
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        machineMenu();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                machineMenu();
            }
            else {
                int j;
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
                machine.status();
            }
        }
    }

    public void removeMachine(Machines machine) {
        for(Machines m : machines) {
            if(machine.name.equals(m.name)) {
                machines.remove(m);
                break;
            }
        }
    }

    private void build() {
        Scanner scanner = new Scanner(System.in);
        machineMenu();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                machineMenu();
            }
            else {
                int j;
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
                machine.build();
            }
        }
    }
}