package graphic.Handle.environment.village.Market_Graphic;

import game.Game;
import game.objectable.Fruits_and_Vegs.Fruits_and_Vegs;
import game.objectable.Goods.Food_Goods.Food_Goods;
import game.objectable.Objectable;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.ArrayList;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Market_Graphic {
    public static void inspectMarket(EnvGroup root){
        Menu menu = new Menu("Market", root);
        MenuItem grocery = new MenuItem("Grocery Store");
        MenuItem general = new MenuItem("General Store");
        MenuItem butchery = new MenuItem("Butchery");
        menu.addAll(grocery, general, butchery);
        grocery.setGoesTo(()->{
            Menu gro = new Menu("Groceries Store", root, menu);
            MenuItem check = new MenuItem("Check this shop");
            MenuItem buy = new MenuItem("Buy an item");
            MenuItem sell = new MenuItem("Sell an item");
            gro.addAll(check, buy, sell);
            check.setGoesTo(()->{
                Menu checkMenu = new Menu("Check", root, gro);
                ArrayList<Fruits_and_Vegs> list = Game.village.market.grocery_store.listItems();
                for (Fruits_and_Vegs f : list) {
                    MenuItem item = new MenuItem(f.name);
                    checkMenu.addAll(item);
                    item.setGoesTo(new Message(f.status() + "\nPrice: " + f.money));
                }
                checkMenu.start();
            });
            buy.setGoesTo(()->{
                Menu buyMenu = new Menu("Buy", root, gro);
                ArrayList<Fruits_and_Vegs> list = Game.village.market.grocery_store.listItems();
                for (Fruits_and_Vegs f : list) {
                    MenuItem item = new MenuItem(f.name);
                    buyMenu.addAll(item);
                    item.setGoesTo(()->{
                        Menu yn = new Menu("You will buy " + f.name + " for " + f.money + " Gill. Is this okay? (Y/N)", root, buyMenu);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(()->{
                        if (Game.Parsa.backpack.capacity >= 1 && Game.Parsa.money >= f.money) {
                            Game.Parsa.backpack.capacity--;
                            Game.Parsa.money -= f.money;
                            Game.Parsa.backpack.putItem(f);
                            yn.exitTo(new Message("Done"));
                        }
                        else
                            yn.exitTo(new Message("Not enough capacity or money."));
                        });
                        yn.start();
                    });
                }
                buyMenu.start();
            });
            sell.setGoesTo(()->Menu.accessBackpackTo(root, gro, ()->{
                Objectable obj = Game.Parsa.backpack.geti(Menu.selected);
                if (!Fruits_and_Vegs.tropical_fruits.contains(obj) && !Fruits_and_Vegs.autumn_fruits.contains(obj) &&
                        !Fruits_and_Vegs.spring_fruits.contains(obj) && !Fruits_and_Vegs.summer_fruits.contains(obj)){
                    Menu.message = (new Message("Invalid"));
                }
                else {
                    if (Game.Parsa.backpack.frequency(obj) < 1) {
                        Menu.message = (new Message("There isn't any"));
                    } else {
                        int price = obj.money;
                        Menu yn = new Menu("You will sell " + obj.name + " for " + price + " Gil. Is this okay? (Y/N)");
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(() -> {
                            Game.Parsa.money += price;
                            Game.Parsa.backpack.takeItem(obj);
                            Menu.message = (new Message("Accepted"));
                        });
                        yn.start();
                    }
                }
            }));
            gro.start();
        });
        general.setGoesTo(()->{
            Menu gen = new Menu("Groceries Store", root, menu);
            MenuItem check = new MenuItem("Check this shop");
            MenuItem buy = new MenuItem("Buy an item");
            MenuItem sell = new MenuItem("Sell an item");
            gen.addAll(check, buy, sell);
            check.setGoesTo(()->{
                Menu checkMenu = new Menu("Check", root, gen);
                ArrayList<Food_Goods> list = Game.village.market.general_store.listItems();
                for (Food_Goods f : list) {
                    MenuItem item = new MenuItem(f.name);
                    checkMenu.addAll(item);
                    item.setGoesTo(new Message(f.status() + "\nPrice: " + f.money));
                }
                checkMenu.start();
            });
            buy.setGoesTo(()->{
                Menu buyMenu = new Menu("Buy", root, gen);
                ArrayList<Food_Goods> list = Game.village.market.general_store.listItems();
                for (Food_Goods f : list) {
                    MenuItem item = new MenuItem(f.name);
                    buyMenu.addAll(item);
                    item.setGoesTo(()->{
                        Menu yn = new Menu("You will buy " + f.name + " for " + f.money + " Gill. Is this okay? (Y/N)", root, buyMenu);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(()->{
                            if (Game.Parsa.backpack.capacity >= 1 && Game.Parsa.money >= f.money) {
                                Game.Parsa.backpack.capacity--;
                                Game.Parsa.money -= f.money;
                                Game.Parsa.backpack.putItem(f);
                                yn.exitTo(new Message("Done"));
                            }
                            else
                                yn.exitTo(new Message("Not enough capacity or money."));
                        });
                        yn.start();
                    });
                }
                buyMenu.start();
            });
            sell.setGoesTo(()->Menu.accessBackpackTo(root, gen, ()-> {
                Objectable obj = Game.Parsa.backpack.geti(Menu.selected);
                if (!Food_Goods.list.contains(obj)) {
                    Menu.message = (new Message("Invalid"));
                } else {
                    if (Game.Parsa.backpack.frequency(obj) < 1) {
                        Menu.message = (new Message("There isn't any"));
                    } else {
                        int price = obj.money;
                        Menu yn = new Menu("You will sell " + obj.name + " for " + price + " Gil. Is this okay? (Y/N)");
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        yn.addAll(yes, no);
                        yn.setBack(no);
                        yes.setGoesTo(() -> {
                            Game.Parsa.money += price;
                            Game.Parsa.backpack.takeItem(obj);
                            Menu.message = (new Message("Accepted"));
                        });
                        yn.start();
                    }
                }
            }));
            gen.start();
        });
        butchery.setGoesTo(()->{

        });
        menu.start();
    }
}
