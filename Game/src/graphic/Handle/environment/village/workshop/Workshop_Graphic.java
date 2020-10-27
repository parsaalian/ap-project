package graphic.Handle.environment.village.workshop;

import game.Game;
import game.objectable.Objectable;
import game.objectable.Tools.Tools;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Workshop_Graphic {

    public static void repair(Tools tool, EnvGroup root, Menu yn){
        ArrayList<Objectable> needsTemp = new ArrayList<>();
        for(Objectable objectable : tool.needs) {
            needsTemp.add(objectable);
        }
        if (Game.Parsa.money > tool.repairMoney) {
            Game.Parsa.money -= tool.buildMoney;
            ArrayList<Objectable> temp = new ArrayList<>();
                if(needsTemp.size() > 0) {
                    int r = 0;
                    Objectable need = needsTemp.get(0);
                    for(Objectable item : needsTemp) {
                        if (item.name.equals(need.name)) {
                            temp.add(item);
                            r++;
                        }
                    }
                    for(Objectable item : temp) {
                        needsTemp.remove(item);
                    }
                    int R = r;
                    if(tool.checkInBackpack(need, r)) {
                        Menu.accessBackpack(root, yn, "Get " + need.name + " x" + R, () -> {
                            System.out.println(Menu.selected);
                            Objectable itemt = Game.Parsa.backpack.geti(Menu.selected);
                            if (itemt.name.equals(need.name) && Game.Parsa.backpack.frequency(itemt) >= R) {
                                System.out.println("One");
                                for (int j = 0; j < R; j++) {
                                    Game.Parsa.backpack.takeItem(itemt);
                                }
                            } else if (itemt.name.equals(need.name) && Game.Parsa.backpack.frequency(itemt) < R) {
                                System.out.println("Two");
                                yn.exitTo(new Message("You don't have enough " + need.name + " to build this tool."));
                                for (Objectable o : temp) {
                                    Game.Parsa.backpack.putItem(o);
                                }
                            }
                            repair(tool, root, yn);
                        });
                    }
                    else {
                        for(Objectable o : temp) {
                            Game.Parsa.backpack.putItem(o);
                        }
                        yn.exitTo(new Message("You don't have enough " + need.name + " to build this tool."));
                    }
                }
                else {
                    tool.broken = false;
                    yn.exitTo(new Message("You have repaired " + tool.name + "."));
                }
        }
        else {
            yn.exitTo(new Message("You don't have enough money."));
        }
    }

    public static void make(Tools tool, EnvGroup root, Menu yn){
        ArrayList<Objectable> needsTemp = new ArrayList<>();
        for(Objectable objectable : tool.needs) {
            needsTemp.add(objectable);
        }
        if(Game.Parsa.money >= tool.buildMoney) {
            Game.Parsa.money -= tool.buildMoney;
            ArrayList<Objectable> temp = new ArrayList<>();
            if(needsTemp.size() > 0) {
                int r = 0;
                Objectable need = needsTemp.get(0);
                for(Objectable item2 : needsTemp) {
                    if (item2.name.equals(need.name)) {
                        temp.add(item2);
                        r++;
                    }
                }
                for(Objectable item2 : temp) {
                    needsTemp.remove(item2);
                }
                int R = r;
                if(tool.checkInBackpack(need, R)) {
                    Menu.accessBackpack(root, yn, "Get " + need.name + " x" + R, () -> {
                        System.out.println(Menu.selected);
                        Objectable itemt = Game.Parsa.backpack.geti(Menu.selected);
                        if (itemt.name.equals(need.name) && Game.Parsa.backpack.frequency(itemt) >= R) {
                            System.out.println("One");
                            for (int j = 0; j < R; j++) {
                                Game.Parsa.backpack.takeItem(itemt);
                            }
                        } else if (itemt.name.equals(need.name) && Game.Parsa.backpack.frequency(itemt) < R) {
                            System.out.println("Two");
                            yn.exitTo(new Message("You don't have enough " + need.name + " to build this tool."));
                            for (Objectable o : temp) {
                                Game.Parsa.backpack.putItem(o);
                            }
                        }
                        make(tool, root, yn);
                    });
                }
            }
            else {
                Game.Parsa.backpack.putItem(tool);
                yn.exitTo(new Message("You have made " + tool.name + "."));
            }
        }
        else {
            yn.exitTo(new Message("You don't have enough money."));
        }
    }

    public static void inspectWorkshop(EnvGroup root){
        Menu menu = new Menu("Workshop", root);
        MenuItem check = new MenuItem("Check this shop");
        MenuItem make = new MenuItem("Make a tool");
        MenuItem repair = new MenuItem("Repair a tool");
        MenuItem disassemble = new MenuItem("Disassemble a tool");
        menu.addAll(check, make, repair, disassemble);
        check.setGoesTo(()->{
            Menu nxt = new Menu("Check", root, menu);
            ArrayList<Tools> canBuild = Game.village.workshop.setCanBuild();
            for(Tools tool : canBuild) {
                MenuItem item = new MenuItem(tool.name);
                nxt.addAll(item);
                item.setGoesTo(()->{
                    Message message = new Message(tool.buildStatus());
                    message.setParent(nxt);
                    message.setRoot(root);
                    message.start();
                });
            }
            nxt.start();
        });
        make.setGoesTo(()->{
            Menu nxt = new Menu("Build", root, menu);
            ArrayList<Tools> canBuild = Game.village.workshop.setCanBuild();
            for(Tools tool : canBuild) {
                MenuItem item = new MenuItem(tool.name);
                nxt.addAll(item);
                item.setGoesTo(()->{
                    if (Game.Parsa.backpack.capacity < 1) {
                        nxt.goTo(new Message("You don't have enough capacity."));
                        return;
                    }
                    boolean made = false;
                    Menu yn = new Menu("Do you want to make this tool? (Y/N)\n" + tool.status(), root, nxt);
                    MenuItem yes = new MenuItem("Yes"),
                            no = new MenuItem("No");
                    yn.addAll(yes, no);
                    yes.setGoesTo(()-> make(tool, root, yn));
                    yn.setBack(no);
                    yn.start();
                });
            }
            nxt.start();
        });
        repair.setGoesTo(()->{
            Menu nxt = new Menu("Repair", root, menu);
            ArrayList<Tools> canRepair = Game.village.workshop.setCanRepair();
            for(Tools tool : canRepair) {
                MenuItem item = new MenuItem(tool.name);
                item.setGoesTo(()->{
                    Menu rep = new Menu("Repair?(Y/N)\n" + tool.status(), root, nxt);
                    MenuItem yes = new MenuItem("Yes");
                    MenuItem no = new MenuItem("No");
                    rep.addAll(yes, no);
                    rep.setBack(no);
                    yes.setGoesTo(()->repair(tool, root, rep));
                    rep.start();
                });
            }
        });
        disassemble.setGoesTo(()->Menu.accessBackpackTo(root, menu, ()->{
            Tools tool = (Tools) Game.Parsa.backpack.geti(Menu.selected);
            if (tool.broken){
                Menu dis = new Menu("Disassemble?(Y/N)\n" + tool.showItemStatus(tool.repairs), root, menu);
                MenuItem yes = new MenuItem("Yes");
                MenuItem no = new MenuItem("No");
                dis.addAll(yes, no);
                dis.setBack(no);
                yes.setGoesTo(()->{
                    for (Objectable objectable : tool.repairs) {
                        Game.Parsa.backpack.putItem(objectable);
                    }
                    Game.Parsa.money += tool.repairMoney / 2;
                    dis.endWith(new Message((tool.name + " disassembled.")));
                });
                dis.start();
            }
            else{
                Menu dis = new Menu("Disassemble this tool for?(Y/N):\n" + tool.showItemStatus(tool.repairs), root, menu);
                MenuItem yes = new MenuItem("Yes");
                MenuItem no = new MenuItem("No");
                dis.addAll(yes, no);
                dis.setBack(no);
                yes.setGoesTo(()->{
                    Game.Parsa.money += tool.buildMoney / 2;
                    for(Objectable objectable : tool.needs) {
                        Game.Parsa.backpack.putItem(objectable);
                    }
                    dis.endWith(new Message((tool.name + " disassembled.")));
                });
                dis.start();
            }
        }));
        menu.start();
    }
}
