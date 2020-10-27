package graphic.Menu;

import graphic.Handle.EnvGroup;
import javafx.geometry.Pos;

/**
 * Created by seyedparsa on 7/15/2017 AD.
 */
public class Message extends Menu {
    public Message (String s){
        getChildren().remove(0);
        ((MenuItem)getChildren().get(0)).setText(s);
        adjust();
    }

    public Message (String s, EnvGroup root, Menu parent){
        this(s);
        setRoot(root);
        setParent(parent);
    }

    public void adjust(){
        double width = 0, height = 0;
        String[] s = ((MenuItem)getChildren().get(0)).text.getText().split("\n");
        for (String ss : s) {
            System.out.println(ss);
            width = Math.max(width, ((MenuItem) getChildren().get(0)).text.getFont().getSize() * ss.length() / 2);
            height += ((MenuItem) getChildren().get(0)).getHeight() * 2;
        }
        menuFrame.setLayoutX(960/2 - width/2);
        menuFrame.setLayoutY(712.5/2 - height/2);
        menuFrame.frame.setWidth(width);
        menuFrame.frame.setHeight(height);
    }

}
