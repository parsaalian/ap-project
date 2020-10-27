package game.environment.Village.Cafe.MissionBoard;

import game.Game;
import game.objectable.Food.Animal_Food.Seed.Seed;
import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;
import game.objectable.Fruits_and_Vegs.Autumn.Orange.Orange;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;
import game.objectable.Objectable;
import game.objectable.Tools.Axe.Adamantium_Axe.Adamantium_Axe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by seyedparsa on 5/23/2017 AD.
 */
public class MissionBoard {
    public ArrayList<Mission> missions = new ArrayList<>();

    {
        Mission m = new Mission();
        m.deadline = 5;
        m.deposit = 50;
        m.reqs.add(new Req(new Apple(), 3));
        m.reqs.add(new Req(new Orange(), 2));
        m.reqs.add(new Req(new Tomato(), 1));
        m.prize.add(new Seed());
        m.prizeCnt.add(2);
        m.prize.add(new Adamantium_Axe());
        m.prizeCnt.add(1);
        missions.add(m);

    }
    public void inspect(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Mission Board:\n" +
                    "1. Check available missions\n" +
                    "2. Manage active missions");
            String line = scanner.nextLine();
            if (line.equals("Back")){
                break;
            }
            int choice;
            try {
                choice = Integer.parseInt(line) - 1;
            }
            catch (Exception e){
                System.out.println("Invalid Command");
                continue;
            }
            if (choice == 0){
                for (int i = 0; i < missions.size(); i++)
                    System.out.println(i+1 + "." + missions.get(i).name);
                line = scanner.nextLine();
                int id;
                try {
                    id = Integer.parseInt(line) - 1;
                }
                catch (Exception e){
                    continue;
                }
                if (id < 0 || id >= missions.size()){
                    System.out.println("Out of range");
                    continue;
                }
                System.out.println("1.Mission briefing\n2.Accept this mission");
                line = scanner.nextLine();
                int yn;
                try {
                    yn = Integer.parseInt(line) - 1;
                }
                catch (Exception e) {
                    continue;
                }
                if (yn == 0)
                    missions.get(id).status();
                if (yn == 1){
                    System.out.println("Do you deposit " + missions.get(id).deposit + " Gill for this mission?(Y/N)");
                    line = scanner.nextLine();
                    if (line.equals("Y") && Game.Parsa.money >= missions.get(id).deposit){
                        Game.Parsa.money -= missions.get(id).deposit;
                        GiveMission(id);
                    }
                }
            }
            else if (choice == 1){
                for (int i = 0; i < Game.Parsa.missions.size(); i++)
                    System.out.println(i+1 + "." + Game.Parsa.missions.get(i).name);
                line = scanner.nextLine();
                int id;
                try {
                    id = Integer.parseInt(line) - 1;
                }
                catch (Exception e){
                    continue;
                }
                if (id < 0 || id >= Game.Parsa.missions.size()){
                    System.out.println("Out of range");
                    continue;
                }
                System.out.println("1.Mission briefing\n2.Mission progress\n3.Remove this mission");
                boolean comp = Game.Parsa.missions.get(id).Completed();
                if (comp)
                    System.out.println("4.Claim prize");
                line = scanner.nextLine();
                int ch;
                try {
                    ch = Integer.parseInt(line) - 1;
                }
                catch (Exception e) {
                    continue;
                }
                if (ch == 0)
                    Game.Parsa.missions.get(id).status();
                if (ch == 1) {
                    boolean add;
                    ArrayList <Objectable> added = new ArrayList<>();
                    ArrayList <Integer> old = new ArrayList<>();
                    for (int i = 0; i < Game.Parsa.missions.get(id).reqs.size(); i++)
                        old.add(Game.Parsa.missions.get(id).reqs.get(i).prepared);
                    while (true) {
                        Game.Parsa.missions.get(id).progressStatus();
                        System.out.println(Game.Parsa.missions.get(id).reqs.size() + 1 + ".Done");
                        line = scanner.nextLine();
                        if (line.equals("Back")) {
                            add = false;
                            break;
                        }
                        int item;
                        try {
                            item = Integer.parseInt(line) - 1;
                        } catch (Exception e) {
                            continue;
                        }
                        if (item < 0 || item > Game.Parsa.missions.get(id).reqs.size()) continue;
                        if (item == Game.Parsa.missions.get(id).reqs.size()){
                            add = true;
                            break;
                        }
                        Req req = Game.Parsa.missions.get(id).reqs.get(item);
                        int rest = req.needed - req.prepared;
                        System.out.println("You have to put in " + req.obj.name + " x" + rest + ":");
                        Game.Parsa.backpack.printItems();
                        line = scanner.nextLine();
                        int jj;
                        try {
                            jj = Integer.parseInt(line)-1;
                        }
                        catch (Exception e){
                            continue;
                        }
                        if (Game.Parsa.backpack.geti(jj+1).name.equals(req.obj.name)){
                            int cnt = rest;
                            if (Game.Parsa.backpack.frequency(req.obj) < cnt)
                                cnt = Game.Parsa.backpack.frequency(req.obj);
                            for (int i = 0; i < cnt; i++) {
                                Game.Parsa.backpack.takeItem(req.obj);
                                Game.Parsa.missions.get(id).reqs.get(item).prepared++;
                                added.add(req.obj);
                            }
                            continue;
                        }
                        else{
                            continue;
                        }
                    }
                    if (add == false){
                        for (int i = 0; i < Game.Parsa.missions.get(id).reqs.size(); i++)
                            Game.Parsa.missions.get(id).reqs.get(i).prepared = old.get(i);
                        for (Objectable obj : added)
                            Game.Parsa.backpack.putItem(obj);
                        System.out.println("Canceled");
                    }
                    else
                        System.out.println("Done");
                }
                if (ch == 2){
                    System.out.println("Do you want to remove this mission?(Y/N)");
                    line = scanner.nextLine();
                    if (line.equals("Y")){
                        FreeMission(id);
                    }
                }
                if (comp && ch == 3){
                    System.out.println("Do you want to receive your prize?(Y/N)");
                    line = scanner.nextLine();
                    if (line.equals("Y")){
                        DeliverMission(id);
                    }
                }


            }
        }
    }

    void addMission(){

    }

    String GiveMission(int id){
        Game.Parsa.missions.add(missions.get(id));
        missions.remove(id);
        return "Done";
    }

    String FreeMission(int id){
        for (Req req : Game.Parsa.missions.get(id).reqs)
            for (int i = 0; i < req.prepared; i++)
                Game.Parsa.backpack.putItem(req.obj);
        for (int i = 0; i < Game.Parsa.missions.get(id).reqs.size(); i++)
            Game.Parsa.missions.get(id).reqs.get(i).prepared = 0;
        if (Game.Parsa.missions.get(id).deadline > 0)
            missions.add(Game.Parsa.missions.get(id));
        Game.Parsa.missions.remove(id);
        return "Done";
    }

    String DeliverMission(int id) {
        if (Game.Parsa.missions.get(id).deadline <= 0){
            return "It's Late...";
        }
        Game.Parsa.money += Game.Parsa.missions.get(id).deposit;
        for (int i = 0; i < Game.Parsa.missions.get(id).prize.size(); i++)
            for (int j = 0; j < Game.Parsa.missions.get(id).prizeCnt.get(i); j++)
                Game.Parsa.backpack.putItem(Game.Parsa.missions.get(id).prize.get(j));
        return "Done";
    }
}
