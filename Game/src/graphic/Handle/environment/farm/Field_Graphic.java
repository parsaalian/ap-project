package graphic.Handle.environment.farm;

import game.Game;
import game.environment.Farm.Arable.Field.Bean_Field.Bean_Field;
import game.environment.Farm.Arable.Field.Carrot_Field.Carrot_Field;
import game.environment.Farm.Arable.Field.Cucumber_Field.Cucumber_Field;
import game.environment.Farm.Arable.Field.Eggplant_Field.Eggplant_Field;
import game.environment.Farm.Arable.Field.Field;
import game.environment.Farm.Arable.Field.Garlic_Field.Garlic_Field;
import game.environment.Farm.Arable.Field.Lettuce_Field.Lettuce_Field;
import game.environment.Farm.Arable.Field.Melon_Field.Melon_Field;
import game.environment.Farm.Arable.Field.Onion_Field.Onion_Field;
import game.environment.Farm.Arable.Field.Potato_Field.Potato_Field;
import game.environment.Farm.Arable.Field.Tomato_Field.Tomato_Field;
import game.environment.Farm.Arable.Field.Turnip_Field.Turnip_Field;
import game.environment.Farm.Arable.Field.Watermelon_Field.Watermelon_Field;
import game.objectable.Objectable;
import game.objectable.Seeds.Seeds;
import game.objectable.Tools.Shovel.Shovel;
import game.objectable.Tools.Watering_Can.Watering_Can;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;
import javafx.scene.image.Image;

import java.util.Scanner;

/**
 * Created by seyedparsa on 7/19/2017 AD.
 */
public class Field_Graphic {
    public static void inspectField(EnvGroup root){
        Menu menu = new Menu("Field", root);
        for(Field field : Game.farm.fields) {
            MenuItem item = new MenuItem(field.type + " Field");
            menu.addAll(item);
            item.setGoesTo(()->{
                if (field.type.equals("Empty")){
                    Menu nxt = new Menu("Empty Field", root, menu);
                    MenuItem status = new MenuItem("Status"),
                            plow = new MenuItem("Plow this field"),
                            water = new MenuItem("Water this field"),
                            plant = new MenuItem("Plant seeds");
                    nxt.addAll(status, plant, plow, water);
                    status.setGoesTo(new Message(field.status()));
                    water.setGoesTo(()->Menu.accessBackpackThen(root, nxt, ()->{
                        Objectable waterCan = Game.Parsa.backpack.geti(Menu.selected);
                        if (!waterCan.type.equals("Watering Can")) {
                            Menu.message = new Message("You have to choose a Watering Can");
                        } else {
                            Watering_Can can = (Watering_Can) Game.Parsa.backpack.geti(Menu.selected);
                            if (can.getInside() == 0) {
                                Menu.message = new Message(("Watering Can is empty"));
                            } else if (can.broken) {
                                Menu.message = new Message(("Watering Can is broken"));
                            } else {
                                StringBuilder out = new StringBuilder();
                                can.setInside(can.getInside() - field.needWater);
                                out.append("Your " + field.type + " Field has been watered");
                                field.water = true;
                                if(can.breaking(can.p)) {
                                    out.append("Your can broke during the operation.");
                                    can.broken = true;
                                }
                                Game.Parsa.energy += can.changeEnergy;
                                Menu.message = new Message(out.toString());
                            }
                        }
                    }));
                    plow.setGoesTo(()->Menu.accessBackpackThen(root, nxt, ()->{
                        Objectable shovelCheck = Game.Parsa.backpack.geti(Menu.selected);
                        if (!shovelCheck.type.equals("Shovel")) {
                            Menu.message = new Message("You have to choose a Shovel");
                        } else {
                            Shovel shovel = (Shovel) Game.Parsa.backpack.geti(Menu.selected);
                            if (shovel.broken) {
                                Menu.message = new Message(("Shovel is broken"));
                            } else {
                                StringBuilder out = new StringBuilder();
                                out.append("Your " + field.type + " Field has been plowed");
                                field.plowed = true;
                                EnvGroup.getImage().setImage(new Image("graphic/sources/maps/farm_change/farm.png"));
                                if(shovel.breaking(shovel.p)) {
                                    out.append("Your shovel broke during the operation.");
                                    shovel.broken = true;
                                }
                                Game.Parsa.energy += shovel.changeEnergy;
                                Menu.message = new Message(out.toString());
                            }
                        }
                    }));

                    plant.setGoesTo(()-> {
                        if (!field.water && !field.plowed) {
                            Message message = (new Message("You have to water and plow this field."));
                            message.setRoot(root);
                            message.setParent(nxt);
                            message.start();
                        }
                        else if(!field.water) {
                            Message message = (new Message("You have to water this field."));
                            message.setRoot(root);
                            message.setParent(nxt);
                            message.start();
                        }
                        else if (!field.plowed) {
                            Message message = (new Message("You have to plow this field."));
                            message.setRoot(root);
                            message.setParent(nxt);
                            message.start();
                        }
                        else {
                            Menu.accessBackpackTo(root, nxt, () -> {
                                Objectable seedCheck = Game.Parsa.backpack.geti(Menu.selected);
                                if (!seedCheck.type.equals("Seed")) {
                                    Menu.message = new Message("You have to choose a seed.");
                                } else {
                                    Seeds seed = (Seeds) Game.Parsa.backpack.geti(Menu.selected);
                                    EnvGroup.getImage().setImage(new Image("graphic/sources/maps/farm_change/farm 2.png"));
                                    if (seed.name.equals("Carrot Seed")) {
                                        if (Game.season.equals("Autumn")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Carrot_Field());
                                            Menu.message = new Message(("You have planted carrot in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Garlic Seed")) {
                                        if (Game.season.equals("Spring")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Garlic_Field());
                                            Menu.message = new Message(("You have planted garlic in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Lettuce Seed")) {
                                        if (Game.season.equals("Spring")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Lettuce_Field());
                                            Menu.message = new Message(("You have planted lettuce in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Onion Seed")) {
                                        if (Game.season.equals("Summer")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Onion_Field());
                                            Menu.message = new Message(("You have planted onion in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Tomato Seed")) {
                                        if (Game.season.equals("Autumn")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Tomato_Field());
                                            Menu.message = new Message(("You have planted tomato in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Bean Seed")) {
                                        if (Game.season.equals("Spring")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Bean_Field());
                                            Menu.message = new Message(("You have planted bean in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Cucumber Seed")) {
                                        if (Game.season.equals("Summer")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Cucumber_Field());
                                            Menu.message = new Message(("You have planted cucumber in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Eggplant Seed")) {
                                        if (Game.season.equals("Spring")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Eggplant_Field());
                                            Menu.message = new Message(("You have planted eggplant in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Melon Seed")) {
                                        if (Game.season.equals("Autumn")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Melon_Field());
                                            Menu.message = new Message(("You have planted melon in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Potato Seed")) {
                                        if (Game.season.equals("Autumn")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Potato_Field());
                                            Menu.message = new Message(("You have planted potato in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Turnip Seed")) {
                                        if (Game.season.equals("Summer")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Turnip_Field());
                                            Menu.message = new Message(("You have planted turnip in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else if (seed.name.equals("Watermelon Seed")) {
                                        if (Game.season.equals("Summer")) {
                                            Game.farm.fields.set(Game.farm.fields.indexOf(field), new Watermelon_Field());
                                            Menu.message = new Message(("You have planted watermelon in this field."));
                                            Game.Parsa.backpack.takeItem(seed);
                                        } else {
                                            Menu.message = new Message(("You can't plant this seed in this season."));
                                        }
                                    } else {
                                        Menu.message = new Message(("You can't plant this seed in the fields."));
                                    }
                                }
                            });
                        }
                    });
                    nxt.start();
                }
                else{
                    Menu nxt = new Menu(field.type + " Field", root, menu);
                    MenuItem status = new MenuItem("Status"),
                            harvest = new MenuItem("Harvest crops"),
                            water = new MenuItem("Water this field"),
                            destroy = new MenuItem("Destroy crops");
                    nxt.addAll(status, harvest, water, destroy);
                    status.setGoesTo(new Message(field.status()));
                    water.setGoesTo(()->Menu.accessBackpackThen(root, nxt, ()->{
                        Objectable waterCan = Game.Parsa.backpack.geti(Menu.selected);
                        if (!waterCan.type.equals("Watering Can")) {
                            Menu.message = new Message("You have to choose a Watering Can");
                        } else {
                            Watering_Can can = (Watering_Can) Game.Parsa.backpack.geti(Menu.selected);
                            if (can.getInside() == 0) {
                                Menu.message = new Message(("Watering Can is empty"));
                            } else if (can.broken) {
                                Menu.message = new Message(("Watering Can is broken"));
                            } else {
                                StringBuilder out = new StringBuilder();
                                can.setInside(can.getInside() - field.needWater);
                                out.append("Your " + field.type + " Field has been watered");
                                field.water = true;
                                if(can.breaking(can.p)) {
                                    out.append("Your can broke during the operation.");
                                    can.broken = true;
                                }
                                Game.Parsa.energy += can.changeEnergy;
                                Menu.message = new Message(out.toString());
                            }
                        }
                    }));
                    harvest.setGoesTo(()->{
                        nxt.endWith(new Message(field.harvest()));
                    });
                    destroy.setGoesTo(()->{
                        field.destroy();
                        nxt.endWith(new Message("Field has been destroyed."));
                    });
                    nxt.start();
                }
            });
        }
        menu.start();
    }
}
