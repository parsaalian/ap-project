package graphic.Handle.environment.farm.home.storage_box;

import game.Game;
import game.objectable.Objectable;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;

import java.util.Scanner;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Storage_Box_Graphic {
    public static void inspect(EnvGroup root) {
        Menu menu = new Menu("Storage Box", root);
        MenuItem put = new MenuItem("Put in item");
        MenuItem take = new MenuItem("Take out item");
        menu.addAll(put, take);
        put.setGoesTo(()->Menu.accessBackpack(root, menu, ()->{
            Objectable get = Game.Parsa.backpack.geti(Menu.selected);
            Game.Parsa.backpack.takeItem(get);
            Game.farm.home.storageBox.putItem(get);
            //System.out.println(n + " " + get.name + "'s has been removed to storage box.");
        }));
        take.setGoesTo(()->Menu.accessStorageBox(root, menu, ()->{
            Objectable item = Game.farm.home.storageBox.geti(Menu.selected2);
            if (Game.Parsa.backpack.capacity > item.capacity) {
                Game.farm.home.storageBox.takeItem(item);
                Game.Parsa.backpack.putItem(item);
                //System.out.println(item.name + " has been removed to your backpack");
            }
            else {
                Message message = new Message("You don't have enought capacity");
                message.setParent(menu);
                message.setRoot(root);
                menu.start();
            }
        }));
        menu.start();
    }
}
