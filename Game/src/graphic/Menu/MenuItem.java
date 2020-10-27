package graphic.Menu;

import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

public class MenuItem extends HBox{
    Text text;
    public Menu parent, goesTo;

    public MenuItem (String name){
        text = new Text(name);
        text.setFont(new Font("Snickles", 50));
        getChildren().add(text);
        setActive(false);
        this.setAlignment(Pos.CENTER);
        this.setHeight(50);
        this.setWidth(200);
        goesTo = parent = null;
    }

    public MenuItem (String name, Menu par){
        this(name);
        parent = par;
        goesTo = null;
    }

    public void setParent(Menu par){
        parent = par;
    }

    public void setText(String s){
        text.setText(s);
    }

    public void setGoesTo(Menu menu){
        goesTo = menu;
        goesTo.setRoot(parent.getRoot());
        goesTo.setParent(parent);
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                goesTo.start();
        });
    }

    public void setGoesTo(Runnable runnable){
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                runnable.run();
            }
        });
    }

    void setActive(boolean b){
        text.setFill(b ? Color.MIDNIGHTBLUE : Color.CADETBLUE);
    }
}
