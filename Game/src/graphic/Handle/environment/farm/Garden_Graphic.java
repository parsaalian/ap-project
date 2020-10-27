package graphic.Handle.environment.farm;

import game.Game;
import game.environment.Farm.Arable.Garden.Garden;
import game.objectable.Objectable;
import game.objectable.Tools.Watering_Can.Watering_Can;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;
import javafx.scene.image.Image;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Garden_Graphic {
    public static void inspectGarden(EnvGroup root){
        Menu menu = new Menu("Fruit Garden", root);
        for (Garden tree : Game.farm.gardens){
            if (!tree.buy){
                MenuItem item = new MenuItem("Buy " + tree.type + " Tree");
                menu.addAll(item);
                item.setGoesTo(()->{
                    if(!Game.season.equals(tree.under.getSeason())) {
                        Message message = new Message("You can't buy this tree in this season.", root, menu);
                        message.start();
                    }
                    else {
                        Menu req = new Menu("This will cost you " + tree.money + " Gil. Is this OK? (Y/N)", root, menu);
                        MenuItem yes = new MenuItem("Yes");
                        MenuItem no = new MenuItem("No");
                        req.addAll(yes, no);
                        no.setGoesTo(() -> {
                            req.exitBack();
                        });
                        req.setBack(no);
                        yes.setGoesTo(() -> {
                            if (Game.Parsa.money >= tree.money && Game.season.equals(tree.under.getSeason())) {
                                tree.buy();
                                Game.Parsa.money -= tree.money;
                                Message message = new Message("You have bought this garden.", root, null);
                                req.endWith(message);
                                EnvGroup.appleTree.setImage(new Image("graphic/sources/fruits/apple_tree/tree 1.png"));
                            }
                            else{
                                Message message = new Message("You don't have enough money.", root, menu);
                                req.exitTo(message);
                            }
                        });
                        req.start();
                    }
                });
            }
            else {
                MenuItem item = new MenuItem(tree.type + " Tree");
                menu.addAll(item);
                item.setGoesTo(()->{
                    Menu menu1 = new Menu(tree.type + " Tree", root, menu);
                    MenuItem status = new MenuItem("Status");
                    MenuItem water = new MenuItem("Water this tree");
                    MenuItem collect = new MenuItem("Collect fruits");
                    menu1.addAll(status, water, collect);
                    status.setGoesTo(new Message(tree.status()));
                    water.setGoesTo(()->Menu.accessBackpackThen(root, menu1, ()->{
                        Objectable waterCan = Game.Parsa.backpack.geti(Menu.selected);
                        if (!waterCan.type.equals("Watering Can")) {
                            Menu.message = new Message("You have to choose a Watering Can");
                        } else {
                            Watering_Can can = (Watering_Can) Game.Parsa.backpack.geti(Menu.selected);
                            if (can.getInside() == 0) {
                                Menu.message = new Message("Watering Can is empty");
                            } else if (can.broken) {
                                Menu.message = new Message("Watering Can is broken");
                            } else {
                                StringBuilder out = new StringBuilder();
                                can.setInside(can.getInside() - tree.needWater);
                                out.append("Your " + tree.type + " Field has been watered");
                                tree.water = true;
                                if(can.breaking(can.p)) {
                                    out.append("\nYour can broke during the operation.");
                                    can.broken = true;
                                }
                                Game.Parsa.energy += can.changeEnergy;
                                Menu.message = new Message(out.toString());
                            }
                        }
                    }));
                    collect.setGoesTo(()->{
                        menu1.exitTo(new Message(tree.collect()));
                    });
                    menu1.start();
                });
            }
        }
        menu.start();
    }
}
