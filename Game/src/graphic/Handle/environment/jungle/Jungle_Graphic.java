package graphic.Handle.environment.jungle;

import game.Game;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Objectable;
import game.objectable.Tools.Axe.Axe;
import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.environment.cave.Cave_Graphic;
import graphic.Handle.environment.farm.Farm_Graphic;
import graphic.Handle.farmer.Farmer_Graphic;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import graphic.Menu.Message;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Jungle_Graphic {
    public static EnvGroup root;
    private static Timeline interact;

    public static void jungleScene(String where) {
        ImageView background = new ImageView(new Image("graphic/sources/maps/jungle.png"));
        root = new EnvGroup(background);
        Scene scene = new Scene(root, 960, 712.5);

        if (Graphic_Handler.isOnline) {
            root.addOnlineButtons();
        }

        setStart(where);

        Farmer_Graphic.setFarmerBools(root);

        Farmer_Graphic.moveFarmer(root);

        Graphic_Handler.game.setScene(scene);

        moveInJungle();
    }

    private static void moveInJungle() {
        interact = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= root.getImage().getImage().getWidth() - 38
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 670
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 720) {
                Farmer_Graphic.move.stop();
                interact.stop();
                root.animation.stop();
                Farm_Graphic.farmScene("jungle");
            }
            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 290
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 350
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 300) {
                Farmer_Graphic.move.stop();
                interact.stop();
                root.animation.stop();
                Cave_Graphic.caveScene("jungle");
            }
            //inspect branch
            if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 830
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 870
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 100
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 160)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1180
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1220
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 40
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 80)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 760
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 800
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 325
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 375)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1120
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1160
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 485
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 540)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 160
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 190
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 440
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 500)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 190
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 230
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 735
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 795)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 350
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 380
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 880
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 930)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 900
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 930
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 810
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 860)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 900
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 930
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1090
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1160)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1085
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1120
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1215
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1280)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 695
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 740
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1290
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1330)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    inspectBranch(root);
                });
            }
            //inspect old tree
            else if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 900
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 980
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 310
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 330)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 775
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 855
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 500
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 530)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 900
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 980
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 760
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 780)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1030
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1110
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1140
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1170)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 200
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 270
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 410
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 430)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 270
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 330
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 790
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 810)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 420
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 500
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1210
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1230)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    inspectOldLumber(root);
                });
            }
            //inspect for pine tree
            else if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1050
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1120
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 235
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 265)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 465
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 545
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 400
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 430)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 210
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 280
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 625
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 655)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 400
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 480
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 815
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 850)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 660
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 730
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1035
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1075)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1010
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1090
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 945
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 975)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 820
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 900
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1365
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1385)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    inspectPine(root);
                });
            }
            else if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1055
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1135
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 25
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 45)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 600
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 700
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 270
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 300)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 880
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 980
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 530
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 560)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 760
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 860
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 790
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 815)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 790
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 890
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 985
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1015)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 630
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <=730
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1205
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1230)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 340
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 450
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1070
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1105)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 55
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 155
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 510
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 530)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    inspectOak(root);
                });
            }
            //inspect rocks
            else if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1105
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1230
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 100
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 140)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 935
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1010
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 90
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 120)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 780
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 840
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 200
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 250)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 590
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 725
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 390
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 450)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 340
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 390
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 510
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 530)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 110
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 170
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 575
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 595)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 400
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 470
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 660
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 685)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 250
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 295
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 920
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 935)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 750
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 810
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1080
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1110)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1040
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1130
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 770
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 810)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 910
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1040
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1240
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1300)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 975
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1075
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 380
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 420)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    inspectRocks(root);
                });
            }
            else {
                EnvGroup.inspect.setOpacity(0);
            }
        }));
        interact.setCycleCount(Animation.INDEFINITE);
        interact.play();
    }

    private static void setStart(String where) {
        if(where.equals("farm")) {
            root.getImage().setTranslateX(-640);
            root.getImage().setTranslateY(-340);
            root.getPlayer().setLayoutX(900);
            root.getPlayer().setLayoutY(356.25);
        }
        if(where.equals("cave")) {
            root.getImage().setTranslateX(0);
            root.getImage().setTranslateY(0);
            root.getPlayer().setLayoutX(337);
            root.getPlayer().setLayoutY(336);
        }
    }

    public static void inspectRocks(EnvGroup root){
        //System.out.println("Rocks:\n1. Collect Stones");
        Menu menu = new Menu("Rocks", root);
        MenuItem collect = new MenuItem("Collect Stones");
        menu.addAll(collect);
        collect.setGoesTo(()->{
            Message message = new Message(Game.jungle.stones.collectStones());
            message.setParent(menu);
            message.setRoot(root);
            message.start();
        });
        menu.start();
    }

    public static void inspectBranch(EnvGroup root){
        Menu menu = new Menu("Branches", root);
        MenuItem collect = new MenuItem("Collect Branch");
        menu.addAll(collect);
        collect.setGoesTo(()->{
            Message message = new Message(Game.jungle.woods.collectBranch());
            message.setParent(menu);
            message.setRoot(root);
            message.start();
        });
        menu.start();
    }

    public static void inspectOldLumber(EnvGroup root){
        Menu menu = new Menu("Old Lumbers", root);
        MenuItem collect = new MenuItem("Collect Old Lumber\nChoose a Stone axe\nor Stronger\n\n\n");
        menu.addAll(collect);
        collect.setGoesTo(()->Menu.accessBackpackThen(root, menu, ()->{
            Objectable item = Game.Parsa.backpack.geti(Menu.selected);
            StringBuilder out = new StringBuilder();
            if(item.type.equals("Axe")) {
                Axe axe = (Axe) Game.Parsa.backpack.geti(Menu.selected);
                int a = axe.numCollected(new Old_Lumber());
                int e = axe.energyChange(new Old_Lumber());
                for(int i = 0; i < a; i++) {
                    Game.Parsa.backpack.putItem(new Old_Lumber());
                }
                Game.Parsa.energy -= e;
                if(a == 0) {
                    out.append("You have collected nothing.\n");
                }
                else {
                    out.append("You have collected " + a + " Old Lumber(s)\n");
                }
                if(axe.breaking(axe.p)) {
                    out.append("Your axe has broke during the operation.\n");
                    axe.broken = true;
                }
            }
            else
                out.append("Invalid Item.");
            Menu.message = new Message(out.toString());
        }));
        menu.start();
    }

    public static void inspectPine(EnvGroup root){
        Menu menu = new Menu("Pine Lumbers", root);
        MenuItem collect = new MenuItem("Collect Pine Lumber\nChoose an Iron axe\nor Stronger\n\n\n");
        menu.addAll(collect);
        collect.setGoesTo(()->Menu.accessBackpackThen(root, menu, ()->{
            Objectable item = Game.Parsa.backpack.geti(Menu.selected);
            StringBuilder out = new StringBuilder();
            if(item.type.equals("Axe") && !item.name.equals("Stone Axe")) {
                Axe axe = (Axe) Game.Parsa.backpack.geti(Menu.selected);
                int a = axe.numCollected(new Pine_Lumber());
                int e = axe.energyChange(new Pine_Lumber());
                for(int i = 0; i < a; i++) {
                    Game.Parsa.backpack.putItem(new Pine_Lumber());
                }
                Game.Parsa.energy -= e;
                if(a == 0) {
                    out.append("You have collected nothing.\n");
                }
                else {
                    out.append("You have collected " + a + " Pine Lumber(s)\n");
                }
                if(axe.breaking(axe.p)) {
                    out.append("Your axe has broke during the operation.\n");
                    axe.broken = true;
                }
            }
            else
                out.append("Invalid Item.");
            Menu.message = new Message(out.toString());
        }));
        menu.start();
    }

    public static void inspectOak(EnvGroup root){
        Menu menu = new Menu("Oak Lumbers", root);
        MenuItem collect = new MenuItem("Collect Oak Lumber\nChoose an Silver axe\nor Stronger\n\n\n");
        menu.addAll(collect);
        collect.setGoesTo(()->Menu.accessBackpackThen(root, menu, ()->{
            Objectable item = Game.Parsa.backpack.geti(Menu.selected);
            StringBuilder out = new StringBuilder();
            if(item.type.equals("Axe") && !item.name.equals("Stone Axe") && !item.name.equals("Iron")) {
                Axe axe = (Axe) Game.Parsa.backpack.geti(Menu.selected);
                int a = axe.numCollected(new Oak_Lumber());
                int e = axe.energyChange(new Oak_Lumber());
                for(int i = 0; i < a; i++) {
                    Game.Parsa.backpack.putItem(new Oak_Lumber());
                }
                Game.Parsa.energy -= e;
                if(a == 0) {
                    out.append("You have collected nothing.\n");
                }
                else {
                    out.append("You have collected " + a + " Oak Lumber(s)\n");
                }
                if(axe.breaking(axe.p)) {
                    out.append("Your axe has broke during the operation.\n");
                    axe.broken = true;
                }
            }
            else
                out.append("Invalid Item.");
            Menu.message = new Message(out.toString());
        }));
        menu.start();
    }
}
