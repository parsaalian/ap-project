package game.environment.Farm.Home.Bed;

import game.Game;

import java.util.Scanner;

public class Bed {
    public String inspect() {
        return "1. Sleep and save game\n2. Sleep without save";
    }

    private void Sleep() {
        Game.changeDay();
    }

    private void SleepAndSave() {
        Game.changeDay();
    }

    public void inspectBed() {
        Scanner scanner = new Scanner(System.in);
        inspect();
        label:
        while (true) {
            String sleep = scanner.nextLine();
            switch (sleep) {
                case "Back":
                    break label;
                case "WhereAmI":
                    inspect();
                    break;
                case "1":
                    SleepAndSave();
                    break;
                case "2":
                    Sleep();
                    break;
            }
        }
    }
}
