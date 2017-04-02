package my.game.menu;

import java.awt.*;

public class SlidingOption extends SlidingLabel {
    private boolean highlighted;

    public SlidingOption(int x, int y, int scale, String name, LabelColor color, int startTime) {
        super(x, y, scale, name, color, startTime);
    }

    public SlidingOption(int y, int scale, String name, LabelColor color, int startTime) {
        super(y, scale, name, color, startTime);
    }

    public void render(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, scale));
        if (highlighted) {
            g.setColor(color.getNameColor());
            g.fillRect((int) x, (int) y, this.width, this.height);
            g.setColor(color.getBoxColor());
            g.drawString(this.name, (int) x + this.width / 2 - this.stringWidth / 2, (int) y + this.height - this.height / 4);
        } else {
            super.render(g);
        }
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
}