package graphic.Menu;

import game.Game;
import game.environment.Farm.Farm;
import graphic.Handle.EnvGroup;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Menu extends VBox {
    MenuFrame menuFrame;
    private Menu parent;
    private EnvGroup root;
    String name;
    Text text;
    int current = 0;
    protected Menu () {
        setSpacing(10);
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP){
                if (current > 0) {
                    getMenuItem(current).setActive(false);
                    getMenuItem(--current).setActive(true);
                }
            }
            if (event.getCode() == KeyCode.DOWN){
                if (current+1 < menuSize()){
                    getMenuItem(current).setActive(false);
                    getMenuItem(++current).setActive(true);
                }
            }
            getMenuItem(current).requestFocus();
        });
        this.setAlignment(Pos.CENTER);

        text = new Text();
        text.setFont(new Font("Snickles", 40));
        text.setFill(Color.BLACK);
        getChildren().add(text);

        MenuItem backItem = new MenuItem("Back", this);
        backItem.setActive(true);
        backItem.setGoesTo(()->{exitBack();});
        getChildren().add(backItem);

        menuFrame = new MenuFrame(this);
    }

    public Menu (String name){
        this();
        this.name = name;
        text.setText(name);
        parent = null;
    }

    public Menu (String name, EnvGroup root) {
        this(name);
        this.root = root;
    }

    public Menu (String name, EnvGroup root, Menu parent){
        this(name, root);
        this.parent = parent;
    }

    public void setBack(MenuItem item){
        item.setGoesTo(()->exitBack());
        getChildren().remove(1);
        ((MenuItem)getChildren().get(1)).setActive(true);
    }

    public boolean hasTitle(){
        return getChildren().contains(text);
    }

    public int menuSize(){
        return getChildren().size()-(hasTitle() ? 1 : 0);
    }

    public MenuItem getMenuItem(int idx){
        return (MenuItem)getChildren().get(idx+(hasTitle() ? 1 : 0));
    }

    public EnvGroup getRoot(){
        if (root != null) return root;
        if (parent == null) return null;
        return root = parent.getRoot();
    }

    public void add(String name){
        getChildren().add(new MenuItem(name, this));
        adjust();
    }

    public void addAll(String... name){
        for (int i = 0; i < name.length; i++)
            add(name[i]);
        adjust();
    }

    public void setRoot(EnvGroup root){
        this.root = root;
    }

    public void setParent(Menu par){
        this.parent = par;
    }

    private void exit(){
        if (isActive())
            getRoot().getChildren().remove(menuFrame);
    }

    public void start(){
        if (parent != null)
            parent.exit();
        else
            getRoot().Pause(this);
        if (getRoot() != null) {
            getRoot().getChildren().add(menuFrame);
            if (menuSize() > 0)
                getMenuItem(current).requestFocus();
            getRoot().setActiveMenu(this);
        }
    }

    public void exitBack(){
        System.out.println(":D");
        exit();
        if (parent != null)
            parent.start();
        else if (getRoot() != null)
            getRoot().Play();
    }

    public void endWith(Menu menu){
        exit();
        menu.setRoot(getRoot());
        menu.start();
    }

    public void exitTo(Menu menu){
        exit();
        if (parent != null){
            menu.setRoot(parent.getRoot());
            menu.setParent(parent);
        }
        menu.start();
    }

    public void goTo(Menu menu){
        exit();
        menu.setRoot(getRoot());
        menu.setParent(this);
        menu.start();
    }

    private void add (MenuItem item){
        item.setParent(this);
        getChildren().add(item);
    }

    public void addAll(MenuItem... items){
        for (MenuItem item : items)
            add(item);
        adjust();
    }

    public boolean isActive(){
        return getRoot() != null && getRoot().getChildren().contains(menuFrame);
    }

    protected void adjust(){
        text.setFont(new Font("Snickles", 100 - 10*Math.sqrt(text.getText().length())));
        double width = text.getFont().getSize()*text.getText().length()/2, height = 0;
        for (int i = 0; i < menuSize(); i++) {
            getMenuItem(i).text.setFont(new Font("Snickles", Math.min(getMenuItem(i).text.getFont().getSize(), 300/menuSize())));
            height += getMenuItem(i).getHeight() * 2;
            double w = getMenuItem(i).getWidth() * 2;
            if (w > width) width = w;
        }
        menuFrame.setLayoutX(960/2 - width/2);
        menuFrame.setLayoutY(712.5/2 - height/2);
        menuFrame.frame.setWidth(width);
        menuFrame.frame.setHeight(height);
    }

    public static int selected, selected2;
    public static Menu backpackMenu, storageBoxMenu;
    public static Message message;

    public static void accessBackpackTo (EnvGroup root, Menu parent, Runnable r){
        backpackMenu = new Menu("Choose from backpack", root, parent);
        String s = Game.Parsa.backpack.printItems();
        String[] items = s.split("\n");
        int id = 1;
        for (String item : items){
            MenuItem mitem = new MenuItem(item);
            backpackMenu.addAll(mitem);
            final int tmp = id;
            mitem.setGoesTo(()->{
                selected = tmp;
                r.run();
                backpackMenu.endWith(message);
            });
            id++;
        }
        backpackMenu.start();
    }


    public static void accessBackpackThen (EnvGroup root, Menu parent, Runnable r){
        backpackMenu = new Menu("Choose from backpack", root, parent);
        String s = Game.Parsa.backpack.printItems();
        String[] items = s.split("\n");
        int id = 1;
        for (String item : items){
            MenuItem mitem = new MenuItem(item);
            backpackMenu.addAll(mitem);
            final int tmp = id;
            mitem.setGoesTo(()->{
                selected = tmp;
                r.run();
                backpackMenu.exitTo(message);
            });
            id++;
        }
        backpackMenu.start();
    }

    public static void accessBackpack (EnvGroup root, Menu parent, Runnable r){
        backpackMenu = new Menu("Choose from backpack", root, parent);
        String s = Game.Parsa.backpack.printItems();
        String[] items = s.split("\n");
        int id = 1;
        for (String item : items){
            MenuItem mitem = new MenuItem(item);
            backpackMenu.addAll(mitem);
            final int tmp = id;
            mitem.setGoesTo(()->{
                selected = tmp;
                r.run();
                backpackMenu.exitBack();
            });
            id++;
        }
        backpackMenu.start();
    }

    public static void accessBackpack (EnvGroup root, Menu parent, String name, Runnable r){
        backpackMenu = new Menu(name, root, parent);
        String s = Game.Parsa.backpack.printItems();
        String[] items = s.split("\n");
        int id = 1;
        for (String item : items){
            MenuItem mitem = new MenuItem(item);
            backpackMenu.addAll(mitem);
            final int tmp = id;
            mitem.setGoesTo(()->{
                selected = tmp;
                r.run();
                backpackMenu.exitBack();
            });
            id++;
        }
        System.out.println("!!");
        backpackMenu.start();
    }

    public static void accessStorageBox (EnvGroup root, Menu parent, Runnable r){
        storageBoxMenu = new Menu("Choose from storage box", root, parent);
        String s = Game.farm.home.storageBox.printItems();
        String[] items = s.split("\n");
        int id = 1;
        for (String item: items){
            MenuItem mitem = new MenuItem(item);
            storageBoxMenu.addAll(mitem);
            final int tmp = id;
            mitem.setGoesTo(()->{
                selected2 = tmp;
                r.run();
                storageBoxMenu.exitBack();
            });
            id++;
        }
        storageBoxMenu.start();
    }

}
