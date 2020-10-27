package graphic.Handle.environment.farm.home.kitchen;

import game.Game;
import game.environment.Farm.Home.Kitchen.Kitchen;
import game.environment.Farm.Home.Kitchen.Recipe.Cheesecake_Recipe.Cheesecake_Recipe;
import game.environment.Farm.Home.Kitchen.Recipe.Recipe;
import game.farmer.Farmer;
import game.objectable.Objectable;
import game.objectable.Tools.Cooking.Cooking;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.util.List;

public class Kitchen_Graphic{
    static Kitchen kitchen = Game.farm.home.kitchen;
    public static void inspect (EnvGroup root) {
        Menu menu = new Menu("Kitchen", root);
        MenuItem cook = new MenuItem("Cook a meal");
        MenuItem check = new MenuItem("Check Tool Shelf");
        MenuItem recipes = new MenuItem("Check recipes");
        menu.addAll(cook, check, recipes);
        cook.setGoesTo( cook() );
        recipes.setGoesTo(recipes());
        check.setGoesTo( () -> {
            Menu checkMenu = new Menu("Choose a tool", root, menu);
            for(Cooking tool : kitchen.shelf.tools) {
                MenuItem item = new MenuItem(tool.name);
                checkMenu.addAll(item);
                item.setGoesTo(() -> {
                    if (!tool.isInShelf){
                        Menu nxt = new Menu("", root, checkMenu);
                        MenuItem put = new MenuItem("Put this tool in shelf");
                        nxt.addAll(put);
                        put.setGoesTo(()->Menu.accessBackpack(root, nxt, ()->{
                            System.out.println("***" + Menu.selected + "***");
                            Objectable getTool = Game.Parsa.backpack.geti(Menu.selected);
                            if (getTool.name.equals(tool.name)) {
                                Game.Parsa.backpack.takeItem(getTool);
                                tool.isInShelf = true;
//                                Message message = new Message("You have placed " + tool.name + " in the shelf.");
//                                message.start();
                            }
                            else {
//                                Message message = new Message("You have to choose a(n) " + tool.name);
//                                message.start();
                            }
                        }));
                        item.goesTo = nxt;
                        nxt.start();
                    }
                    else{
                        Menu nxt = new Menu("", root, checkMenu);
                        MenuItem status = new MenuItem("Status");
                        MenuItem replace = new MenuItem("Replace");
                        MenuItem remove = new MenuItem("Remove");
                        nxt.addAll(status, replace, remove);
                        status.setGoesTo(new Message(tool.status()));
                        remove.setGoesTo(()->{
                            tool.isInShelf = false;
                            Game.Parsa.backpack.putItem(tool);
                            //System.out.println(tool.name + " has been removed to your backpack.");
                        });
                        replace.setGoesTo(()->Menu.accessBackpack(root, nxt, ()->{
                            Objectable getTool = Game.Parsa.backpack.geti(Menu.selected);
                            if (getTool.name.equals(tool.name)) {
                                Game.Parsa.backpack.takeItem(getTool);
                                tool.isInShelf = true;
                                //System.out.println("You have replaced " + tool.name + " in the shelf.");
                            }
                            else {
                                //System.out.println("You have to choose a(n) " + tool.name);
                            }
                        }));
                        item.goesTo = nxt;
                        nxt.start();
                    }
                });
            }
            check.goesTo = checkMenu;
            checkMenu.start();
        });
        menu.start();
    }

    public static Menu cook(){
        Menu menu = new Menu("Choose a recipe");
        List <Recipe> list = kitchen.getRecipesCheck();
        for (Recipe r : list) {
            MenuItem item = new MenuItem(r.toString());
            menu.addAll(item);
            item.setGoesTo(r.getItemsMenu());
        }
        return menu;
    }

    public static Menu recipes(){
        Menu menu = new Menu("Choose a recipe");
        List <Recipe> list = kitchen.getRecipesCheck();
        for (Recipe r : list) {
            MenuItem item = new MenuItem(r.toString());
            menu.addAll(item);
            item.setGoesTo(new Message(r.getStatus()));
        }
        return menu;
    }
}
