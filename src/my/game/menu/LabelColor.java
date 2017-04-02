package my.game.menu;

import java.awt.*;
public enum LabelColor {
    RED(new Color(255, 0, 0), new Color(128, 0, 0)),
    GREEN(new Color(0, 255, 0), new Color(0, 128, 0)),
    GREY(new Color(192, 192, 192), new Color(128, 128, 128));

    private Color nameColor, boxColor;
    LabelColor(Color nameColor, Color boxColor){
        this.nameColor = nameColor;
        this.boxColor = boxColor;
    }

    public Color getNameColor() {
        return nameColor;
    }

    public Color getBoxColor() {
        return boxColor;
    }
}