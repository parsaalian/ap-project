package graphic.Handle.environment.farm.home.bed;

import game.Game;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;

public class Bed_Graphic {
    public static void inspect (EnvGroup root) {
        Menu menu = new Menu("‌Bed", root);
        MenuItem save = new MenuItem("Sleep and save game");
        MenuItem sleep = new MenuItem("Sleep without save");
        menu.addAll(save, sleep);
        save.setGoesTo(()->{
            Game.changeDay();
        menu.exitBack();});
        sleep.setGoesTo(()->{Game.changeDay();
        menu.exitBack();
        });
        menu.start();
    }
}
