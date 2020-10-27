package graphic.Handle.environment.village.gym;

import game.Game;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Gym_Graphic {
    public static void inspectGym(EnvGroup root){
        Menu menu = new Menu("Gym", root);
        MenuItem health = new MenuItem("Health");
        MenuItem energy = new MenuItem("Energy");
        menu.addAll(health, energy);
        health.setGoesTo(()->{
            Menu nxt = new Menu("Improve Health", root, menu);
            MenuItem mx = new MenuItem("Max amount");
            MenuItem refill = new MenuItem("Refill rate");
            MenuItem cons = new MenuItem("Consumption rate");
            nxt.addAll(mx, refill, cons);
            mx.setGoesTo(()->{
                Menu lst = new Menu("Health max amount", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will add your health max amount 100 points."));
                train.setGoesTo(()->{
                    if(Game.Parsa.maxHealth == 1000) {
                        lst.goTo(new Message("You have the highest max health."));
                    }
                    else {
                        Menu yn = new Menu("This training will cost you " + Game.Parsa.maxHealth + " Gil. Is this okay? (Y/N)", root, lst);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(()->{
                            if (Game.Parsa.money >= Game.Parsa.maxHealth) {
                                Game.Parsa.money -= Game.Parsa.maxHealth;
                                Game.Parsa.maxHealth += 100;
                                yn.exitTo(new Message("Your max health amount added 100 points."));
                            } else {
                                yn.exitTo(new Message("You don't have enough money."));
                            }
                        });
                        yn.start();
                    }
                });
                lst.start();
            });
            refill.setGoesTo(()->{
                Menu lst = new Menu("Health Refill rate", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will add your health refill rate 20 points."));
                train.setGoesTo(()->{
                    Menu yn = new Menu("This training will cost you " + 10 * (-50 + Game.Parsa.healthRefill) + " Gil\n. Is this okay? (Y/N)", root, lst);
                    MenuItem yes = new MenuItem("Yes");
                    MenuItem no = new MenuItem("No");
                    yn.addAll(yes, no);
                    yn.setBack(no);
                    yes.setGoesTo(()->{
                        if(Game.Parsa.money >= 10 * (-50 + Game.Parsa.healthRefill)) {
                            yn.exitTo(new Message("Your health refill rate added 20 points."));
                            Game.Parsa.money -= 10 * (-50 + Game.Parsa.healthRefill);
                            Game.Parsa.healthRefill += 20;
                        }
                        else
                            yn.exitTo(new Message("You don't have enough money."));
                    });
                    yn.start();
                });
                lst.start();
            });
            cons.setGoesTo(()->{
                Menu lst = new Menu("Health Consumption rate", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will lower your health consumption rate 10 points."));
                train.setGoesTo(()->{
                    Menu yn = new Menu("This training will cost you " + 5 * (-Game.Parsa.healthCons + 150) + " Gil. Is this okay? (Y/N)", root, lst);
                    MenuItem yes = new MenuItem("Yes");
                    MenuItem no = new MenuItem("No");
                    yn.addAll(yes, no);
                    yn.setBack(no);
                    yes.setGoesTo(()->{
                        if(Game.Parsa.money >= 5 * (-Game.Parsa.healthCons + 150)) {
                            yn.exitTo(new Message("Your health refill rate lowered 10 points."));
                            Game.Parsa.money -= 5 * (-Game.Parsa.healthCons + 150);
                            Game.Parsa.healthCons -= 10;
                        }
                        else {
                            yn.exitTo(new Message("You don't have enough money."));
                        }
                    });
                    yn.start();
                });
                lst.start();
            });
            nxt.start();
        });
        energy.setGoesTo(()->{
            Menu nxt = new Menu("Improve Energy", root, menu);
            MenuItem mx = new MenuItem("Max amount");
            MenuItem refill = new MenuItem("Refill rate");
            MenuItem cons = new MenuItem("Consumption rate");
            nxt.addAll(mx, refill, cons);
            mx.setGoesTo(()->{
                Menu lst = new Menu("Energy max amount", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will add your energy max amount 200 points."));
                train.setGoesTo(()->{
                    if(Game.Parsa.maxHealth == 2000) {
                        lst.goTo(new Message("You have the highest max energy."));
                    }
                    else {
                        Menu yn = new Menu("This training will cost you " + Game.Parsa.maxEnergy + " Gil. Is this okay? (Y/N)", root, lst);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(()->{
                            if(Game.Parsa.money >= (Game.Parsa.maxEnergy / 2)) {
                                Game.Parsa.money -= Game.Parsa.maxEnergy / 2;
                                Game.Parsa.maxEnergy += 200;
                                yn.exitTo(new Message("Your max energy amount added 200 points."));
                            } else {
                                yn.exitTo(new Message("You don't have enough money."));
                            }
                        });
                        yn.start();
                    }
                });
                lst.start();
            });
            refill.setGoesTo(()->{
                Menu lst = new Menu("Energy Refill rate", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will add your energy refill rate 20 points."));
                train.setGoesTo(()->{
                    if(Game.Parsa.energyRefill == 200) {
                        lst.goTo(new Message("You have the highest energy refill rate."));
                    }
                    else {
                        Menu yn = new Menu("This training will cost you " + 10 * (-50 + Game.Parsa.energyRefill) + " Gil. Is this okay? (Y/N)", root, lst);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(()->{
                            if(Game.Parsa.money >= 10 * (-50 + Game.Parsa.energyRefill)) {
                                yn.exitTo(new Message("Your energy refill rate added 20 points."));
                                Game.Parsa.money -= 10 * (-50 + Game.Parsa.energyRefill);
                                Game.Parsa.energyRefill += 20;
                            }
                            else
                                yn.exitTo(new Message("You don't have enough money."));
                        });
                        yn.start();
                    }
                });
                lst.start();
            });
            cons.setGoesTo(()->{
                Menu lst = new Menu("Energy Consumption rate", root, nxt);
                MenuItem status = new MenuItem("Status");
                MenuItem train = new MenuItem("Train");
                lst.addAll(status, train);
                status.setGoesTo(new Message("This training will lower your energy consumption rate 10 points."));
                train.setGoesTo(()->{
                    if(Game.Parsa.energyCons == 50) {
                        lst.goTo(new Message("You have the lowest energy consumption rate."));
                    }
                    else {
                        Menu yn = new Menu("This training will cost you " + 5 * (-Game.Parsa.energyCons + 150) + " Gil. Is this okay? (Y/N)", root, lst);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(() -> {
                            if(Game.Parsa.money >= 5 * (-Game.Parsa.energyCons + 150)) {
                                yn.exitTo(new Message("Your energy refill rate lowered 10 points."));
                                Game.Parsa.money -= 5 * (-Game.Parsa.energyCons + 150);
                                Game.Parsa.energyCons -= 10;
                            } else {
                                yn.exitTo(new Message("You don't have enough money."));
                            }
                        });
                        yn.start();
                    }
                });
                lst.start();
            });
            nxt.start();
        });
        menu.start();
    }
}
